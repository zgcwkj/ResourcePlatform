package com.zgcwkj.utils;

import java.util.Random;

/**
 * 生成随机码
 * 
 * @author zgcwkj
 * @since 2018-11-10
 */
public class RandomCode {
	private static String strType = "";

	/**
	 * 生成随机码
	 * 
	 * @param digital   数字
	 * @param character 字符
	 * @param symbol    符号
	 */
	public RandomCode(boolean digital, boolean character, boolean symbol) {
		// 数字
		if (digital) {
			strType = "1|2|3|4|5|6|7|8|9|0";
		}
		// 字符
		if (character) {
			if (strType != "")
				strType += "|";// 避免前面不选
			strType += "q|w|e|r|t|y|u|i|o|p|a|s|d|f|g|h|j|k|l|z|x|c|v|b|n|m";
		}
		// 符号
		if (symbol) {
			if (strType != "")
				strType += "|";// 避免前面不选
			strType += ",|.|/|;|'|[|]|{|}|;|<|>|?|!|@|#|$|%|^|&|*|(|)|_|-|+|=|~";
		}
		// 防止空字符
		if (strType.equals("")) {
			strType = "null";
		}
	}

	/**
	 * 获取随机码
	 * 
	 * @param length 长度
	 * @return
	 */
	public String getRandom(int length) {
		String strRandom = "";
		String[] zf = strType.split("\\|");
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int sjs = random.nextInt(zf.length);
			strRandom += zf[sjs];
		}
		return strRandom;
	}
}