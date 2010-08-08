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

import jpcsp.Memory;
import jpcsp.Processor;
import jpcsp.Allegrex.CpuState;
import jpcsp.HLE.Modules;
import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import org.apache.log4j.Logger;

public class sceDmac implements HLEModule {
    private static Logger log = Modules.getLogger("sceDmac");

	@Override
	public String getName() { return "sceDmac"; }

	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {

			mm.addFunction(0x617F3FE6, sceDmacMemcpyFunction);
			mm.addFunction(0xD97F94D8, sceDmacTryMemcpyFunction);

		}
	}

	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {

			mm.removeFunction(sceDmacMemcpyFunction);
			mm.removeFunction(sceDmacTryMemcpyFunction);

		}
	}


    public void sceDmacMemcpy(Processor processor) {
        CpuState cpu = processor.cpu;
        Memory mem = Processor.memory;

        int dest   = cpu.gpr[4];
        int source = cpu.gpr[5];
        int size   = cpu.gpr[6];

        log.debug(String.format("sceDmacMemcpy dest=0x%08X, source=0x%08X, size=0x%08X", dest, source, size));

        mem.memcpy(dest, source, size);

        cpu.gpr[2] = 0;
    }

	public void sceDmacTryMemcpy(Processor processor) {
        CpuState cpu = processor.cpu;

		log.warn("Unimplemented NID function sceDmacTryMemcpy [0xD97F94D8]");

		cpu.gpr[2] = 0xDEADC0DE;
	}

	public final HLEModuleFunction sceDmacMemcpyFunction = new HLEModuleFunction("sceDmac", "sceDmacMemcpy") {
		@Override
		public final void execute(Processor processor) {
			sceDmacMemcpy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceDmacModule.sceDmacMemcpy(processor);";
		}
	};

	public final HLEModuleFunction sceDmacTryMemcpyFunction = new HLEModuleFunction("sceDmac", "sceDmacTryMemcpy") {
		@Override
		public final void execute(Processor processor) {
			sceDmacTryMemcpy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.sceDmacModule.sceDmacTryMemcpy(processor);";
		}
	};
}