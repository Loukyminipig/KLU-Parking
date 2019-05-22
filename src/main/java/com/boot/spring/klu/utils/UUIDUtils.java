package com.boot.spring.klu.utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

/**
 * @auth liweipeng
 * @version 2019年5月22日上午12:32:22
 **/
public class UUIDUtils {
	private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	public static String getOrderIdByUUId() {
		int first = new Random(10).nextInt(8) + 1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0)
			hashCodeV = -hashCodeV;
		return first + String.format("%015d", hashCodeV);
	}
	
	public static long getUUIDSimple() {
		BigInteger bigInteger = new BigInteger(getOrderIdByUUId());
		return bigInteger.longValue();
	}

	// 得到8位的UUID-(码)
	public static String getUUID_8() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			int x = Integer.parseInt(uuid.substring(i * 4, i * 4 + 4), 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

	// 得到16位的UUID-(数字)
	public static String getUUID_16() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0)
			hashCodeV = -hashCodeV;
		return machineId + String.format("%015d", hashCodeV);
	}

	// 得到32位的UUID-(数字)
	public static String getUUID_32() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}
