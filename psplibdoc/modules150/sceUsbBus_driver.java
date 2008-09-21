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

import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import jpcsp.Memory;
import jpcsp.Processor;

import jpcsp.Allegrex.CpuState; // New-Style Processor

public class sceUsbBus_driver implements HLEModule {
	@Override
	public String getName() { return "sceUsbBus_driver"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.addFunction(sceUsbGetStateFunction, 0xC21645A4);
			
			mm.addFunction(sceUsbbdRegisterFunction, 0xB1644BE7);
			
			mm.addFunction(sceUsbbdUnregisterFunction, 0xC1E2A540);
			
			mm.addFunction(sceUsbbdClearFIFOFunction, 0x951A24CC);
			
			mm.addFunction(sceUsbbdStallFunction, 0xE65441C1);
			
			mm.addFunction(sceUsbbdReqSendFunction, 0x23E51D8F);
			
			mm.addFunction(sceUsbbdReqRecvFunction, 0x913EC15D);
			
			mm.addFunction(sceUsbbdReqCancelFunction, 0xCC57EC9D);
			
			mm.addFunction(sceUsbbdReqCancelAllFunction, 0xC5E53685);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.removeFunction(sceUsbGetStateFunction);
			
			mm.removeFunction(sceUsbbdRegisterFunction);
			
			mm.removeFunction(sceUsbbdUnregisterFunction);
			
			mm.removeFunction(sceUsbbdClearFIFOFunction);
			
			mm.removeFunction(sceUsbbdStallFunction);
			
			mm.removeFunction(sceUsbbdReqSendFunction);
			
			mm.removeFunction(sceUsbbdReqRecvFunction);
			
			mm.removeFunction(sceUsbbdReqCancelFunction);
			
			mm.removeFunction(sceUsbbdReqCancelAllFunction);
			
		}
	}
	
	
	public void sceUsbGetState(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbGetState [0xC21645A4]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdRegister(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdRegister [0xB1644BE7]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdUnregister(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdUnregister [0xC1E2A540]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdClearFIFO(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdClearFIFO [0x951A24CC]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdStall(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdStall [0xE65441C1]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdReqSend(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdReqSend [0x23E51D8F]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdReqRecv(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdReqRecv [0x913EC15D]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdReqCancel(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdReqCancel [0xCC57EC9D]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceUsbbdReqCancelAll(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceUsbbdReqCancelAll [0xC5E53685]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public final HLEModuleFunction sceUsbGetStateFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbGetState") {
		@Override
		public final void execute(Processor processor) {
			sceUsbGetState(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbGetStateFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdRegisterFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdRegister") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdRegister(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdRegisterFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdUnregisterFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdUnregister") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdUnregister(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdUnregisterFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdClearFIFOFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdClearFIFO") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdClearFIFO(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdClearFIFOFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdStallFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdStall") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdStall(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdStallFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdReqSendFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdReqSend") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdReqSend(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdReqSendFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdReqRecvFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdReqRecv") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdReqRecv(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdReqRecvFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdReqCancelFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdReqCancel") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdReqCancel(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdReqCancelFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceUsbbdReqCancelAllFunction = new HLEModuleFunction("sceUsbBus_driver", "sceUsbbdReqCancelAll") {
		@Override
		public final void execute(Processor processor) {
			sceUsbbdReqCancelAll(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceUsbBus_driver.sceUsbbdReqCancelAllFunction.execute(processor);";
		}
	};
    
};
