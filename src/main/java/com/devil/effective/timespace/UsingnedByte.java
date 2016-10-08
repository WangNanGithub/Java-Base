package com.devil.effective.timespace;

/**
 * 使用更多CPU运算来减少对内存空间的需求
 *
 */
public class UsingnedByte {
	public short getValue(byte i) { // 将byte转为无符号的数字
		short li = (short) (i & 0xff);
		return li;
	}

	public byte toUnsingedByte(short i) {// 将short转为无符号的byte
		return (byte) (i & 0xff);
	}

	public static void main(String[] args) {
		UsingnedByte ins = new UsingnedByte();
		short[] shorts = new short[256];
		for (int i = 0; i < shorts.length; i++) {
			shorts[i] = (short) i;
		}
		byte[] bytes = new byte[256];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = ins.toUnsingedByte(shorts[i]);
		}

		for (int i = 0; i < bytes.length; i++) {
			System.out.println(ins.getValue(bytes[i]) + " ");
		}
	}
}
