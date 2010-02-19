/* This autogenerated file is part of jpcsp. */
/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.HLE.modules150;

import java.util.LinkedList;
import java.util.List;

import jpcsp.Emulator;
import jpcsp.Memory;
import jpcsp.Processor;
import jpcsp.Allegrex.CpuState;
import jpcsp.HLE.Modules;
import jpcsp.HLE.ThreadMan;
import jpcsp.HLE.kernel.Managers;
import jpcsp.HLE.kernel.types.IAction;
import jpcsp.HLE.kernel.types.SceKernelThreadInfo;
import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

public class sceCtrl implements HLEModule {

	private int cycle;
    private int mode;
    private int uiMake;
    private int uiBreak;
    private int uiPress;
    private int uiRelease;

    private int TimeStamp; // microseconds
    private byte Lx;
    private byte Ly;
    private int Buttons;

    // IdleCancelThreshold
    private int idlereset;
    private int idleback;

    public final static int PSP_CTRL_SELECT = 0x000001;
    public final static int PSP_CTRL_START = 0x000008;
    public final static int PSP_CTRL_UP = 0x000010;
    public final static int PSP_CTRL_RIGHT = 0x000020;
    public final static int PSP_CTRL_DOWN = 0x000040;
    public final static int PSP_CTRL_LEFT = 0x000080;
    public final static int PSP_CTRL_LTRIGGER = 0x000100;
    public final static int PSP_CTRL_RTRIGGER = 0x000200;
    public final static int PSP_CTRL_TRIANGLE = 0x001000;
    public final static int PSP_CTRL_CIRCLE = 0x002000;
    public final static int PSP_CTRL_CROSS = 0x004000;
    public final static int PSP_CTRL_SQUARE = 0x008000;
    public final static int PSP_CTRL_HOME = 0x010000;
    public final static int PSP_CTRL_HOLD = 0x020000;
    public final static int PSP_CTRL_NOTE = 0x800000;
    public final static int PSP_CTRL_SCREEN = 0x400000;
    public final static int PSP_CTRL_VOLUP = 0x100000;
    public final static int PSP_CTRL_VOLDOWN = 0x200000;
    public final static int PSP_CTRL_WLAN_UP = 0x040000;
    public final static int PSP_CTRL_REMOTE = 0x080000;
    public final static int PSP_CTRL_DISC = 0x1000000;
    public final static int PSP_CTRL_MS = 0x2000000;

    // PspCtrlMode
    public final static int PSP_CTRL_MODE_DIGITAL = 0;
    public final static int PSP_CTRL_MODE_ANALOG = 1;
    protected IAction sampleAction = null;
    protected Sample samples[];
    protected int currentSamplingIndex;
    protected int currentReadingIndex;
    protected int latchSamplingCount;
    protected final static int SAMPLE_BUFFER_SIZE = 10;
    protected List<ThreadWaitingForSampling> threadsWaitingForSampling;

    public boolean isModeDigital() {
        if (mode == PSP_CTRL_MODE_DIGITAL)
            return true;
        return false;
    }

    /** Need to call setButtons even if the user didn't move any fingers, otherwise we can't track "press" properly */
    public void setButtons(byte Lx, byte Ly, int Buttons)
    {
        int oldButtons = this.Buttons;

        this.TimeStamp = (int)(System.currentTimeMillis() * 1000L) & 0x7FFFFFFF; // not sure if removing sign bit is required
        this.Lx = Lx;
        this.Ly = Ly;
        this.Buttons = Buttons;

        //System.out.println("AN " + (int)(Lx & 0xFF) + " " + (int)(Ly & 0xFF) + " (" + TimeStamp + ")");

        if (isModeDigital())
        {
            // PSP_CTRL_MODE_DIGITAL
            // moving the analog stick has no effect and always returns 128,128
            this.Lx = (byte)128;
            this.Ly = (byte)128;
        }

        int changed = oldButtons ^ Buttons;
        int changed2 = oldButtons & Buttons;

        /* testing
        if ((changed2 & PSP_CTRL_CROSS) == PSP_CTRL_CROSS)
            System.out.println("PSP_CTRL_CROSS press");
        else
            System.out.println("PSP_CTRL_CROSS release");

        if ((changed & PSP_CTRL_CROSS) == PSP_CTRL_CROSS &&
            (oldButtons & PSP_CTRL_CROSS) == PSP_CTRL_CROSS)
            System.out.println("PSP_CTRL_CROSS break");

        if ((changed & PSP_CTRL_CROSS) == PSP_CTRL_CROSS &&
            (Buttons & PSP_CTRL_CROSS) == PSP_CTRL_CROSS)
            System.out.println("PSP_CTRL_CROSS make");
        /* */

        uiMake = changed & Buttons;
        uiBreak = changed & oldButtons;
        uiPress = changed2;
        uiRelease = ~changed2;
    }

    @Override
    public String getName() {
        return "sceCtrl";
    }

    @Override
    public void installModule(HLEModuleManager mm, int version) {
        if (version >= 150) {

            mm.addFunction(sceCtrlSetSamplingCycleFunction, 0x6A2774F3);
            mm.addFunction(sceCtrlGetSamplingCycleFunction, 0x02BAAD91);
            mm.addFunction(sceCtrlSetSamplingModeFunction, 0x1F4011E6);
            mm.addFunction(sceCtrlGetSamplingModeFunction, 0xDA6B76A1);
            mm.addFunction(sceCtrlPeekBufferPositiveFunction, 0x3A622550);
            mm.addFunction(sceCtrlPeekBufferNegativeFunction, 0xC152080A);
            mm.addFunction(sceCtrlReadBufferPositiveFunction, 0x1F803938);
            mm.addFunction(sceCtrlReadBufferNegativeFunction, 0x60B81F86);
            mm.addFunction(sceCtrlPeekLatchFunction, 0xB1D0E5CD);
            mm.addFunction(sceCtrlReadLatchFunction, 0x0B588501);
            mm.addFunction(sceCtrlSetIdleCancelThresholdFunction, 0xA7144800);
            mm.addFunction(sceCtrlGetIdleCancelThresholdFunction, 0x687660FA);
            mm.addFunction(sceCtrl_348D99D4Function, 0x348D99D4);
            mm.addFunction(sceCtrl_AF5960F3Function, 0xAF5960F3);
            mm.addFunction(sceCtrlClearRapidFireFunction, 0xA68FD260);
            mm.addFunction(sceCtrlSetRapidFireFunction, 0x6841BE1A);

            uiMake = 0;
            uiBreak = 0;
            uiPress = 0;
            uiRelease = ~uiPress;

            Lx = (byte)128;
            Ly = (byte)128;
            Buttons = 0;

            idlereset = -1;
            idleback = -1;

            mode = PSP_CTRL_MODE_DIGITAL; // check initial mode
            cycle = 0;

            samples = new Sample[SAMPLE_BUFFER_SIZE];
            for (int i = 0; i < samples.length; i++) {
            	samples[i] = new Sample();
            }
            currentSamplingIndex = 0;
            currentReadingIndex = 0;
            latchSamplingCount = 0;

            threadsWaitingForSampling = new LinkedList<ThreadWaitingForSampling>();

            if (sampleAction == null) {
            	sampleAction = new SamplingAction();
            	Managers.intr.addVBlankAction(sampleAction);
            }
        }
    }

    @Override
    public void uninstallModule(HLEModuleManager mm, int version) {
        if (version >= 150) {

            mm.removeFunction(sceCtrlSetSamplingCycleFunction);
            mm.removeFunction(sceCtrlGetSamplingCycleFunction);
            mm.removeFunction(sceCtrlSetSamplingModeFunction);
            mm.removeFunction(sceCtrlGetSamplingModeFunction);
            mm.removeFunction(sceCtrlPeekBufferPositiveFunction);
            mm.removeFunction(sceCtrlPeekBufferNegativeFunction);
            mm.removeFunction(sceCtrlReadBufferPositiveFunction);
            mm.removeFunction(sceCtrlReadBufferNegativeFunction);
            mm.removeFunction(sceCtrlPeekLatchFunction);
            mm.removeFunction(sceCtrlReadLatchFunction);
            mm.removeFunction(sceCtrlSetIdleCancelThresholdFunction);
            mm.removeFunction(sceCtrlGetIdleCancelThresholdFunction);
            mm.removeFunction(sceCtrl_348D99D4Function);
            mm.removeFunction(sceCtrl_AF5960F3Function);
            mm.removeFunction(sceCtrlClearRapidFireFunction);
            mm.removeFunction(sceCtrlSetRapidFireFunction);

            if (sampleAction != null) {
            	Managers.intr.removeVBlankAction(sampleAction);
            	sampleAction = null;
            }
        }
    }

    protected class SamplingAction implements IAction {
		@Override
		public void execute() {
			hleCtrlExecuteSampling();
		}
    }

    protected static class ThreadWaitingForSampling {
    	SceKernelThreadInfo thread;
    	int readAddr;
    	int readCount;
    	boolean readPositive;

    	public ThreadWaitingForSampling(SceKernelThreadInfo thread, int readAddr, int readCount, boolean readPositive) {
    		this.thread = thread;
    		this.readAddr = readAddr;
    		this.readCount = readCount;
    		this.readPositive = readPositive;
    	}
    }

    protected static class Sample {
        public int TimeStamp; // microseconds
        public byte Lx;
        public byte Ly;
        public int Buttons;

        public int write(Memory mem, int addr, boolean positive) {
            mem.write32(addr    , TimeStamp);
            mem.write32(addr + 4, positive ? Buttons : ~Buttons);
            mem.write8 (addr + 8, Lx);
            mem.write8 (addr + 9, Ly);

            return addr + 16;
        }

        @Override
        public String toString() {
        	return String.format("TimeStamp=%d,Lx=%d,Ly=%d,Buttons=%08X", TimeStamp, Lx, Ly, Buttons);
        }
    }

    protected int incrementSampleIndex(int index) {
    	index++;
    	if (index >= samples.length) {
    		index = 0;
    	}

    	return index;
    }

    protected void hleCtrlExecuteSampling() {
    	if (Modules.log.isDebugEnabled()) {
    		Modules.log.debug("hleCtrlExecuteSampling");
    	}

    	latchSamplingCount++;

    	Sample currentSampling = samples[currentSamplingIndex];
    	currentSampling.TimeStamp = TimeStamp;
    	currentSampling.Lx = Lx;
    	currentSampling.Ly = Ly;
    	currentSampling.Buttons = Buttons;

    	currentSamplingIndex = incrementSampleIndex(currentSamplingIndex);
    	if (currentSamplingIndex == currentReadingIndex) {
    		currentReadingIndex = incrementSampleIndex(currentReadingIndex);
    	}

    	if (!threadsWaitingForSampling.isEmpty()) {
    		// Only 1 sample is available and only 1 thread can read it:
    		// take the first waiting thread.
    		ThreadWaitingForSampling wait = threadsWaitingForSampling.remove(0);

    		if (Modules.log.isDebugEnabled()) {
        		Modules.log.debug("hleExecuteSampling waiting up thread " + wait.thread);
        	}

			hleCtrlReadBufferImmediately(wait.thread.cpuContext, wait.readAddr, wait.readCount, wait.readPositive);
			ThreadMan.getInstance().unblockThread(wait.thread.uid);
    	}
    }

    public void sceCtrlSetSamplingCycle(Processor processor) {
        CpuState cpu = processor.cpu;

        int newCycle = cpu.gpr[4];

        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug("sceCtrlSetSamplingCycle(cycle=" + newCycle + ") returning " + cycle);
        }

        cpu.gpr[2] = cycle;
        cycle = newCycle;
    }

    public void sceCtrlGetSamplingCycle(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int a0 = cpu.gpr[4];

        mem.write32(a0, cycle);
        cpu.gpr[2] = 0;
    }

    /** returns the previous state */
    public void sceCtrlSetSamplingMode(Processor processor) {
        CpuState cpu = processor.cpu;

        int newMode = cpu.gpr[4];

        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug("sceCtrlSetSamplingMode(mode=" + newMode + ") returning " + mode);
        }

        cpu.gpr[2] = mode;
        mode = newMode;
    }

    public void sceCtrlGetSamplingMode(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int a0 = cpu.gpr[4];

        mem.write32(a0, mode);
        cpu.gpr[2] = 0;
    }

    public void sceCtrlPeekBufferPositive(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int pad_addr = cpu.gpr[4], count = cpu.gpr[5];

        int i;
        int peekIndex = currentReadingIndex;
        for (i = 0; i < count && peekIndex != currentSamplingIndex; i++) {
        	pad_addr = samples[peekIndex].write(mem, pad_addr, true);
            peekIndex = incrementSampleIndex(peekIndex);
        }

        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug(String.format("sceCtrlPeekBufferPositive(0x%08X,%d) result %d", pad_addr, count, i));
        }
        cpu.gpr[2] = i;
    }

    public void sceCtrlPeekBufferNegative(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int pad_addr = cpu.gpr[4], count = cpu.gpr[5];

        int i;
        int peekIndex = currentReadingIndex;
        for (i = 0; i < count && peekIndex != currentSamplingIndex; i++) {
        	pad_addr = samples[peekIndex].write(mem, pad_addr, false);
            peekIndex = incrementSampleIndex(peekIndex);
        }

        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug(String.format("sceCtrlPeekBufferNegative(0x%08X,%d) result %d", pad_addr, count, i));
        }
        cpu.gpr[2] = i;
    }

    protected void hleCtrlReadBufferImmediately(CpuState cpu, int addr, int count, boolean positive) {
    	Memory mem = Memory.getInstance();
        int i;
        for (i = 0; i < count && currentReadingIndex != currentSamplingIndex; i++) {
        	addr = samples[currentReadingIndex].write(mem, addr, positive);
        	currentReadingIndex = incrementSampleIndex(currentReadingIndex);
        }

    	if (Modules.log.isDebugEnabled()) {
    		Modules.log.debug("hleCtrlReadBufferImmediately #=" + i);
    	}

        cpu.gpr[2] = i;
    }

    protected void hleCtrlReadBuffer(int addr, int count, boolean positive) {
    	// Some data available in sample buffer?
    	if (currentReadingIndex != currentSamplingIndex) {
    		// Yes, read immediately
    		hleCtrlReadBufferImmediately(Emulator.getProcessor().cpu, addr, count, positive);
    	} else {
        	if (Modules.log.isDebugEnabled()) {
        		Modules.log.debug("hleCtrlReadBuffer waiting for sample");
        	}

    		// No, wait for next sampling
    		ThreadMan threadMan = ThreadMan.getInstance();
    		SceKernelThreadInfo currentThread = threadMan.getCurrentThread();
    		ThreadWaitingForSampling threadWaitingForSampling = new ThreadWaitingForSampling(currentThread, addr, count, positive);
    		threadsWaitingForSampling.add(threadWaitingForSampling);
    		threadMan.blockCurrentThread();
    	}
    }

    public void sceCtrlReadBufferPositive(Processor processor) {
        CpuState cpu = processor.cpu;

        int pad_addr = cpu.gpr[4], count = cpu.gpr[5];
        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug(String.format("sceCtrlReadBufferPositive(0x%08X,%d)", pad_addr, count));
        }

        hleCtrlReadBuffer(pad_addr, count, true);
    }

    public void sceCtrlReadBufferNegative(Processor processor) {
        CpuState cpu = processor.cpu;

        int pad_addr = cpu.gpr[4], count = cpu.gpr[5];
        if (Modules.log.isDebugEnabled()) {
        	Modules.log.debug(String.format("sceCtrlReadBufferNegative(0x%08X,%d)", pad_addr, count));
        }

        hleCtrlReadBuffer(pad_addr, count, false);
    }

    public void sceCtrlPeekLatch(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int latch_addr = cpu.gpr[4];

        mem.write32(latch_addr, uiMake);
        mem.write32(latch_addr + 4, uiBreak);
        mem.write32(latch_addr + 8, uiPress);
        mem.write32(latch_addr + 12, uiRelease);
        cpu.gpr[2] = latchSamplingCount;
    }

    public void sceCtrlReadLatch(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int latch_addr = cpu.gpr[4];

        mem.write32(latch_addr, uiMake);
        mem.write32(latch_addr + 4, uiBreak);
        mem.write32(latch_addr + 8, uiPress);
        mem.write32(latch_addr + 12, uiRelease);
        cpu.gpr[2] = latchSamplingCount;
        latchSamplingCount = 0;
    }

    public void sceCtrlSetIdleCancelThreshold(Processor processor) {
        CpuState cpu = processor.cpu;

        idlereset = cpu.gpr[4];
        idleback = cpu.gpr[5];

        Modules.log.debug("sceCtrlSetIdleCancelThreshold(idlereset=" + idlereset + ",idleback=" + idleback + ")");

        cpu.gpr[2] = 0;
    }

    public void sceCtrlGetIdleCancelThreshold(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int idlereset_addr = cpu.gpr[4];
        int idleback_addr = cpu.gpr[5];

        Modules.log.debug("sceCtrlGetIdleCancelThreshold(idlereset=0x" + Integer.toHexString(idlereset_addr)
            + ",idleback=0x" + Integer.toHexString(idleback_addr) + ")"
            + " returning idlereset=" + idlereset + " idleback=" + idleback);

        if (mem.isAddressGood(idlereset_addr)) {
            mem.write32(idlereset_addr, idlereset);
        }

        if (mem.isAddressGood(idleback_addr)) {
            mem.write32(idleback_addr, idleback);
        }

        cpu.gpr[2] = 0;
    }

    public void sceCtrl_348D99D4(Processor processor) {
        CpuState cpu = processor.cpu;

        Modules.log.warn("Unimplemented NID function sceCtrl_348D99D4 [0x348D99D4]");

        cpu.gpr[2] = 0xDEADC0DE;
    }

    public void sceCtrl_AF5960F3(Processor processor) {
        CpuState cpu = processor.cpu;

        Modules.log.warn("Unimplemented NID function sceCtrl_AF5960F3 [0xAF5960F3]");

        cpu.gpr[2] = 0xDEADC0DE;
    }

    public void sceCtrlClearRapidFire(Processor processor) {
        CpuState cpu = processor.cpu;

        Modules.log.warn("Unimplemented NID function sceCtrlClearRapidFire [0xA68FD260]");

        cpu.gpr[2] = 0xDEADC0DE;
    }

    public void sceCtrlSetRapidFire(Processor processor) {
        CpuState cpu = processor.cpu;

        Modules.log.warn("Unimplemented NID function sceCtrlSetRapidFire [0x6841BE1A]");

        cpu.gpr[2] = 0xDEADC0DE;
    }
    public final HLEModuleFunction sceCtrlSetSamplingCycleFunction = new HLEModuleFunction("sceCtrl", "sceCtrlSetSamplingCycle") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlSetSamplingCycle(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlSetSamplingCycle(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlGetSamplingCycleFunction = new HLEModuleFunction("sceCtrl", "sceCtrlGetSamplingCycle") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlGetSamplingCycle(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlGetSamplingCycle(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlSetSamplingModeFunction = new HLEModuleFunction("sceCtrl", "sceCtrlSetSamplingMode") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlSetSamplingMode(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlSetSamplingMode(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlGetSamplingModeFunction = new HLEModuleFunction("sceCtrl", "sceCtrlGetSamplingMode") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlGetSamplingMode(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlGetSamplingMode(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlPeekBufferPositiveFunction = new HLEModuleFunction("sceCtrl", "sceCtrlPeekBufferPositive") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlPeekBufferPositive(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlPeekBufferPositive(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlPeekBufferNegativeFunction = new HLEModuleFunction("sceCtrl", "sceCtrlPeekBufferNegative") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlPeekBufferNegative(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlPeekBufferNegative(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlReadBufferPositiveFunction = new HLEModuleFunction("sceCtrl", "sceCtrlReadBufferPositive") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlReadBufferPositive(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlReadBufferPositive(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlReadBufferNegativeFunction = new HLEModuleFunction("sceCtrl", "sceCtrlReadBufferNegative") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlReadBufferNegative(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlReadBufferNegative(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlPeekLatchFunction = new HLEModuleFunction("sceCtrl", "sceCtrlPeekLatch") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlPeekLatch(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlPeekLatch(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlReadLatchFunction = new HLEModuleFunction("sceCtrl", "sceCtrlReadLatch") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlReadLatch(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlReadLatch(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlSetIdleCancelThresholdFunction = new HLEModuleFunction("sceCtrl", "sceCtrlSetIdleCancelThreshold") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlSetIdleCancelThreshold(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlSetIdleCancelThreshold(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlGetIdleCancelThresholdFunction = new HLEModuleFunction("sceCtrl", "sceCtrlGetIdleCancelThreshold") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlGetIdleCancelThreshold(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlGetIdleCancelThreshold(processor);";
        }
    };
    public final HLEModuleFunction sceCtrl_348D99D4Function = new HLEModuleFunction("sceCtrl", "sceCtrl_348D99D4") {

        @Override
        public final void execute(Processor processor) {
            sceCtrl_348D99D4(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrl_348D99D4(processor);";
        }
    };
    public final HLEModuleFunction sceCtrl_AF5960F3Function = new HLEModuleFunction("sceCtrl", "sceCtrl_AF5960F3") {

        @Override
        public final void execute(Processor processor) {
            sceCtrl_AF5960F3(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrl_AF5960F3(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlClearRapidFireFunction = new HLEModuleFunction("sceCtrl", "sceCtrlClearRapidFire") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlClearRapidFire(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlClearRapidFire(processor);";
        }
    };
    public final HLEModuleFunction sceCtrlSetRapidFireFunction = new HLEModuleFunction("sceCtrl", "sceCtrlSetRapidFire") {

        @Override
        public final void execute(Processor processor) {
            sceCtrlSetRapidFire(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.Modules.sceCtrlModule.sceCtrlSetRapidFire(processor);";
        }
    };
};
