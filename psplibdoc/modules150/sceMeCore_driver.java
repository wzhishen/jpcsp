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

public class sceMeCore_driver implements HLEModule {
	@Override
	public String getName() { return "sceMeCore_driver"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.addFunction(sceMeCore_driver_D1EA3DFDFunction, 0xD1EA3DFD);
			
			mm.addFunction(sceMeCore_driver_3D5F109CFunction, 0x3D5F109C);
			
			mm.addFunction(sceMeRpcLockFunction, 0x04AFF68E);
			
			mm.addFunction(sceMeRpcUnlockFunction, 0xB97B15D7);
			
			mm.addFunction(sceMeEnableFunctionsFunction, 0x4794C05C);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.removeFunction(sceMeCore_driver_D1EA3DFDFunction);
			
			mm.removeFunction(sceMeCore_driver_3D5F109CFunction);
			
			mm.removeFunction(sceMeRpcLockFunction);
			
			mm.removeFunction(sceMeRpcUnlockFunction);
			
			mm.removeFunction(sceMeEnableFunctionsFunction);
			
		}
	}
	
	
	public void sceMeCore_driver_D1EA3DFD(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceMeCore_driver_D1EA3DFD [0xD1EA3DFD]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceMeCore_driver_3D5F109C(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceMeCore_driver_3D5F109C [0x3D5F109C]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceMeRpcLock(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceMeRpcLock [0x04AFF68E]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceMeRpcUnlock(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceMeRpcUnlock [0xB97B15D7]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceMeEnableFunctions(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceMeEnableFunctions [0x4794C05C]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public final HLEModuleFunction sceMeCore_driver_D1EA3DFDFunction = new HLEModuleFunction("sceMeCore_driver", "sceMeCore_driver_D1EA3DFD") {
		@Override
		public final void execute(Processor processor) {
			sceMeCore_driver_D1EA3DFD(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceMeCore_driver.sceMeCore_driver_D1EA3DFDFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceMeCore_driver_3D5F109CFunction = new HLEModuleFunction("sceMeCore_driver", "sceMeCore_driver_3D5F109C") {
		@Override
		public final void execute(Processor processor) {
			sceMeCore_driver_3D5F109C(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceMeCore_driver.sceMeCore_driver_3D5F109CFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceMeRpcLockFunction = new HLEModuleFunction("sceMeCore_driver", "sceMeRpcLock") {
		@Override
		public final void execute(Processor processor) {
			sceMeRpcLock(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceMeCore_driver.sceMeRpcLockFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceMeRpcUnlockFunction = new HLEModuleFunction("sceMeCore_driver", "sceMeRpcUnlock") {
		@Override
		public final void execute(Processor processor) {
			sceMeRpcUnlock(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceMeCore_driver.sceMeRpcUnlockFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceMeEnableFunctionsFunction = new HLEModuleFunction("sceMeCore_driver", "sceMeEnableFunctions") {
		@Override
		public final void execute(Processor processor) {
			sceMeEnableFunctions(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.sceMeCore_driver.sceMeEnableFunctionsFunction.execute(processor);";
		}
	};
    
};
