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
package jpcsp.media;

import org.apache.log4j.Logger;

import jpcsp.HLE.VFS.IVirtualFile;

public class VirtualFileProtocolHandler implements IMediaChannel {
	private static Logger log = Logger.getLogger("VirtualFileProtocolHandler");
	private IVirtualFile vFile;
	private int readLength;

	public VirtualFileProtocolHandler(IVirtualFile vFile) {
		this.vFile = vFile;
	}

	@Override
	public int close() {
		log.debug("close");

		if (vFile != null) {
			vFile.ioClose();
			vFile = null;
		}

		return 0;
	}

	@Override
	public boolean isStreamed(String url, int flags) {
		return false;
	}

	@Override
	public int open(String url, int flags) {
		if (vFile == null) {
			// vFile is closed
			return -1;
		}

		// vFile is already open
		return 0;
	}

	@Override
	public int read(byte[] buf, int size) {
		if (vFile == null) {
			return -1;
		}

		if (log.isDebugEnabled()) {
			log.debug(String.format("read size=0x%X", size));
		}

		int result = vFile.ioRead(buf, 0, size);
		if (result < 0) {
			return -1;
		}

		readLength += result;

		return result;
	}

	@Override
	public long seek(long offset, int whence) {
		if (vFile == null) {
			return -1;
		}

		long seek;
		switch (whence) {
			case SEEK_SET:
				seek = offset;
				break;
			case SEEK_CUR:
				seek = vFile.getPosition() + offset;
				break;
			case SEEK_END:
				seek = vFile.length() + offset;
				break;
			case SEEK_SIZE:
				if (log.isDebugEnabled()) {
					log.debug(String.format("seek SEEK_SIZE returning 0x%X", vFile.length()));
				}
				return vFile.length();
			default:
				return -1;
		}

		long result = vFile.ioLseek(seek);
		if (log.isDebugEnabled()) {
			log.debug(String.format("seek offset=0x%X, whence=%d, returning 0x%X, seek position 0x%X", offset, whence, result, seek));
		}

		if (result < 0) {
			return -1;
		}

		return result;
	}

	@Override
	public int write(byte[] buf, int size) {
		if (vFile == null) {
			return -1;
		}

		if (log.isDebugEnabled()) {
			log.debug(String.format("write size=0x%X", size));
		}

		int result = vFile.ioWrite(buf, 0, size);
		if (result < 0) {
			return -1;
		}

		return result;
	}

	@Override
	public int getReadLength() {
		return readLength;
	}

	@Override
	public void setReadLength(int readLength) {
		this.readLength = readLength;
	}
}
