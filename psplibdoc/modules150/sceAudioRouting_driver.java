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

public class sceAudioRouting_driver implements HLEModule {
	@Override
	public String getName() { return "sceAudioRouting_driver"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.addFunction(sceAudioRoutingSetModeFunction, 0x36FD8AA9);
			
			mm.addFunction(sceAudioRoutingGetModeFunction, 0x39240E7D);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.removeFunction(sceAudioRoutingSetModeFunction);
			
			mm.removeFunction(sceAudioRoutingGetModeFunction);
			
		}
	}
	
	
	public void sceAudioRoutingSetMode(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceAudioRoutingSetMode [0x36FD8AA9]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceAudioRoutingGetMode(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceAudioRoutingGetMode [0x39240E7D]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public final HLEModuleFunction sceAudioRoutingSetModeFunction = new HLEModuleFunction("sceAudioRouting_driver", "sceAudioRoutingSetMode") {
		@Override
		public final void execute(Processor processor) {
			sceAudioRoutingSetMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceAudioRouting_driver.sceAudioRoutingSetModeFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceAudioRoutingGetModeFunction = new HLEModuleFunction("sceAudioRouting_driver", "sceAudioRoutingGetMode") {
		@Override
		public final void execute(Processor processor) {
			sceAudioRoutingGetMode(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceAudioRouting_driver.sceAudioRoutingGetModeFunction.execute(processor);";
		}
	};
    
};
