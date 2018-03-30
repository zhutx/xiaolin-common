package com.xiaolin.fish.common.utils;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtil {

	/**
	 * 获取uuid,去除横杠
	 * 
	 * @return
	 */
	public static String getUUID() {
		// UUID uuid = UUID.randomUUID();
		// String s = uuid.toString();
		// int p = 0;
		// int j = 0;
		// char[] buf = new char[32];
		// int len = s.length();
		// while (p < len) {
		// char c = s.charAt(p);
		// p += 1;
		// if (c == '-')
		// continue;
		// buf[j] = c;
		// j += 1;
		// }
		// return new String(buf);

		UUID uuid = UUID.randomUUID();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(DigitUtil.longTo16Str(uuid.getMostSignificantBits()));
		stringBuilder.append(DigitUtil.longTo16Str(uuid.getLeastSignificantBits()));
		return stringBuilder.toString();
	}

	/**
	 * 获取uuid,使用64进制字符串。
	 * 
	 * @return
	 */
	public static String getUUID22() {
		UUID uuid = UUID.randomUUID();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(DigitUtil.longTo64Str(uuid.getMostSignificantBits()));
		stringBuilder.append(DigitUtil.longTo64Str(uuid.getLeastSignificantBits()));
		return stringBuilder.toString();
	}

	/**
	 * 获取uuid,使用32进制字符串。
	 * 
	 * @return
	 */
	public static String getUUID26() {
		UUID uuid = UUID.randomUUID();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(DigitUtil.longTo32Str(uuid.getMostSignificantBits()));
		stringBuilder.append(DigitUtil.longTo32Str(uuid.getLeastSignificantBits()));
		return stringBuilder.toString();
	}

	/**
	 * 获取范围内int值
	 * 
	 * @return
	 */
	public static int getRandomRange(int max, int min) {
		// return (int)(Math.random()*(max-min)+min);
		return (int) (ThreadLocalRandom.current().nextDouble() * (max - min) + min);
	}

	/**
	 * 获取随机长度随机字符
	 * 
	 * @param length base
	 * @return
	 */
	public static String getRandomString(int length, String base) { // length表示生成字符串的长度
	// Random random = new Random();
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < length; i++) {
	// int number = random.nextInt(base.length());
	// sb.append(base.charAt(number));
	// }
	// return sb.toString();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = ThreadLocalRandom.current().nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 获取随机长度随机字符，包含大写字母和数字
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { // length表示生成字符串的长度
	// String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	// Random random = new Random();
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < length; i++) {
	// int number = random.nextInt(36);
	// sb.append(base.charAt(number));
	// }
	// return sb.toString();
		String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = threadLocalRandom.nextInt(36);
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 获取随机长度随机字符,包含大小写字母和数字
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandom62String(int length) { // length表示生成字符串的长度
	// String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	// Random random = new Random();
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < length; i++) {
	// int number = random.nextInt(62);
	// sb.append(base.charAt(number));
	// }
	// return sb.toString();
		String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = threadLocalRandom.nextInt(62);
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 获取随机长度随机字符,包含大小写字母和数字-_
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandom64String(int length) { // length表示生成字符串的长度
		int bitLength = length * 6;
		int longArrayLength;
		if (bitLength % 64 == 0) {
			longArrayLength = bitLength / 64;
		} else {
			longArrayLength = bitLength / 64 + 1;
		}
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		long[] longArray = new long[longArrayLength];
		for (int i = 0; i < longArrayLength; i++) {
			longArray[i] = threadLocalRandom.nextLong();
		}
		return DigitUtil.longArrayTo64Str(longArray, length);
	}

	/**
	 * 获取包含数字和22个字母的随机长度随机字符
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandom32String(int length) { // length表示生成字符串的长度
		int bitLength = length * 5;
		int longArrayLength;
		if (bitLength % 64 == 0) {
			longArrayLength = bitLength / 64;
		} else {
			longArrayLength = bitLength / 64 + 1;
		}
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		long[] longArray = new long[longArrayLength];
		for (int i = 0; i < longArrayLength; i++) {
			longArray[i] = threadLocalRandom.nextLong();
		}
		return DigitUtil.longArrayTo32Str(longArray, length);
	}

	/**
	 * 获取随机长度随机数字
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomNumString(int length) { // length表示生成字符串的长度
	// String base = "0123456789";
	// Random random = new Random();
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < length; i++) {
	// int number = random.nextInt(base.length());
	// sb.append(base.charAt(number));
	// }
	// return sb.toString();

		String base = "0123456789";
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = threadLocalRandom.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 返回随机数组
	 * 
	 * @param start 开始值
	 * @param end 结束值
	 * @return
	 */
	public static int[] getRangRandom(int start, int end) {
		return getRangRandom(start, end, end - start + 1);
	}

	/**
	 * 返回指定范围指定个数的不重复随机数。
	 * 
	 * @param start
	 * @param end
	 * @param num
	 * @return
	 */
	public static int[] getRangRandom(int start, int end, int num) {

		// int length = end - start + 1;
		// //参数不合法
		// if (length < 1 || num > length) {
		// return null;
		// }
		// else {
		//
		// int[] numbers = new int[length];
		// int[] result = new int[num];
		//
		// //循环赋初始值
		// for (int i = 0; i < length; i ++) {
		// numbers[i] = i + start;
		// }
		//
		// Random random = new Random();
		//
		// //取randomMax次数
		// for (int i = 0; i < num; i ++) {
		//
		// //随机获取取数的位置
		// int m = random.nextInt(length - i) + i;
		//
		// result[i] = numbers[m];
		//
		// //交换位置
		// int temp = numbers[m];
		// numbers[m] = numbers[i];
		// numbers[i] = temp;
		// }
		//
		// return result;
		// }

		int length = end - start + 1;
		// 参数不合法
		if (length < 1 || num > length) {
			return null;
		} else {

			int[] numbers = new int[length];
			int[] result = new int[num];

			// 循环赋初始值
			for (int i = 0; i < length; i++) {
				numbers[i] = i + start;
			}

			ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

			// 取randomMax次数
			for (int i = 0; i < num; i++) {

				// 随机获取取数的位置
				int m = threadLocalRandom.nextInt(length - i) + i;

				result[i] = numbers[m];

				// 交换位置
				int temp = numbers[m];
				numbers[m] = numbers[i];
				numbers[i] = temp;
			}

			return result;
		}

	}

	public static void main(String[] avgs) {
		// long start;
		// long end;
		// System.out.println(getUUID26());
		// System.out.println(getRandom64String(64));
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getUUID();
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getUUID22();
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getUUID26();
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getRandom64String(64);
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getRandom32String(64);
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);
		//
		// start = System.currentTimeMillis();
		// for (int i = 0; i < 10000000; i ++) {
		// getRandom62String(64);
		// }
		// end = System.currentTimeMillis();
		// System.out.println(end - start);

	}
}