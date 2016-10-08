package com.devil.effective.timespace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * spcaeToTime实现数组排序，不计空间成本，以数组索引下标来表示数据大小。避免数字的相互比较
 *
 */
public class SpaceSort {
	public static int arrayLen = 1000000;

	public static void main(String[] args) {
		int[] a = new int[arrayLen];
		int[] old = new int[arrayLen];
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int count = 0;
		while (count < a.length) {// 初始化数组
			int value = (int) ((Math.random() * arrayLen * 10) + 1);
			if (map.get(value) == null) {
				map.put(value, value);
				a[count] = value;
				count++;
			}
		}

		System.arraycopy(a, 0, old, 0, a.length); // 为了保存原有数据
		long start = System.currentTimeMillis();
		Arrays.sort(a);
		System.out.println("Arrays sort spend:" + (System.currentTimeMillis() - start) + "ms");
		System.arraycopy(old, 0, a, 0, old.length); // 恢复原有数据
		start = System.currentTimeMillis();
		spaceToTime(a);
		System.out.println("spaceToTime spend:" + (System.currentTimeMillis() - start) + "ms");
	}

	public static void spaceToTime(int[] array) {
		int i = 0;
		int max = array[0];
		int len = array.length;
		for (i = 1; i < len; i++) {
			if (array[i] > max) // 找出最大值
				max = array[i];

		}
		int[] temp = new int[max + len]; // 分配临时空间
		for (i = 0; i < len; i++) {
			temp[array[i]] = array[i]; // 以下标来标识数字大小
		}
		int j = 0;
		int maxl = max + len;
		for (i = 0; i < maxl; i++) { // 线性复杂度
			if (temp[i] > 0) {
				array[j++] = temp[i];
			}
		}
	}
}
