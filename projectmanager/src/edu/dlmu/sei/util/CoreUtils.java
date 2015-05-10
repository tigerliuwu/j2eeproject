package edu.dlmu.sei.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.validator.GenericTypeValidator;

import edu.dlmu.sei.struts.validator.BaseValidator;

public class CoreUtils {

	public static BigDecimal ZERO = new BigDecimal(0);

	private static String ISO_DATE_FORMAT = "yyyy-MM-dd";

	private static SimpleDateFormat defaultDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static Date parseDate(String str) {

		if (StringUtils.isBlank(str))

			return null;

		try {

			return DateUtils.parseDate(str, new String[] { ISO_DATE_FORMAT });

		} catch (ParseException e) {

			return null;

		}

	}

	/**
	 * 把一个"yyyy-MM"的字符串转换成合法的日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDate1(String str) {

		if (StringUtils.isBlank(str))

			return null;

		try {

			return DateUtils.parseDate(str, new String[] { "yyyy-MM" });

		} catch (ParseException e) {
			return null;

		}

	}

	public static String date2String(Date date) {
		if (date == null)
			return "";
		else
			return defaultDateFormat.format(date);
	}

	public static boolean isValidateString(String str) {

		return !(str == null || str.trim().equals(""));

	}

	public static boolean isDate(String val) {

		boolean ret = true;

		Date dval = parseDate(val);

		if (dval == null) {

			return false;

		}

		String[] inputDatePart = val.split("/");

		String[] outputDatePart = CoreUtils.date2String(dval).split("/");

		if (Integer.parseInt(inputDatePart[0]) != Integer
				.parseInt(outputDatePart[0])
				|| Integer.parseInt(inputDatePart[1]) != Integer
						.parseInt(outputDatePart[1])
				|| Integer.parseInt(inputDatePart[2]) != Integer
						.parseInt(outputDatePart[2])) {

			ret = false;

		}

		return ret;

	}

	public static boolean isDouble(String val) {

		boolean ret = true;

		Double dval = GenericTypeValidator.formatDouble(val);

		if (dval == null) {

			ret = false;

		}

		return ret;

	}

	public static Date nextDate(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, 1);

		return calendar.getTime();

	}

	public static Date nextMonth(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.MONTH, 1);

		return calendar.getTime();

	}

	public static Date PreviousMonth(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.MONTH, -1);

		return calendar.getTime();

	}

	public static Date PreviousDate(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, -1);

		return calendar.getTime();

	}

	public static final String ZIP_CHARSET = "ISO-8859-1";

	public static String encode64(Object obj) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStream zos = new GZIPOutputStream(baos);
			ObjectOutputStream oos = new ObjectOutputStream(zos);
			oos.writeObject(obj);
			oos.close();
			zos.close();
			baos.close();
			Base64 base64Codec = new Base64();
			return new String(base64Codec.encode(baos.toByteArray()),
					ZIP_CHARSET);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static Object decode64(String s) {
		try {
			Base64 base64Codec = new Base64();
			ByteArrayInputStream decodedStream = new ByteArrayInputStream(
					base64Codec.decode(s.getBytes(ZIP_CHARSET)));
			InputStream unzippedStream = new GZIPInputStream(decodedStream);
			ObjectInputStream ois = new ObjectInputStream(unzippedStream);
			Object obj = ois.readObject();
			ois.close();
			unzippedStream.close();
			decodedStream.close();
			return obj;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static String[] splitStringToArray(String str, String key) {
		if (str != null && key != null) {
			return StringUtils.split(str, key);
		}
		return null;
	}

	public static String getDateToString(java.util.Date date) {
		return dateToString(date, "MM/dd/yyyy");
	}

	public static String dateToString(Date d, String format) {
		if (d == null) {
			return "";
		}
		Hashtable h = new Hashtable();
		String javaFormat = new String();
		String s = format.toLowerCase();
		if (s.indexOf("yyyy") != -1) {
			h.put(new Integer(s.indexOf("yyyy")), "yyyy");
		} else if (s.indexOf("yy") != -1) {
			h.put(new Integer(s.indexOf("yy")), "yy");
		}
		if (s.indexOf("mm") != -1) {
			h.put(new Integer(s.indexOf("mm")), "MM");
		}
		if (s.indexOf("dd") != -1) {
			h.put(new Integer(s.indexOf("dd")), "dd");
		}
		if (s.indexOf("hh24") != -1) {
			h.put(new Integer(s.indexOf("hh24")), "HH");
		}
		if (s.indexOf("mi") != -1) {
			h.put(new Integer(s.indexOf("mi")), "mm");
		}
		if (s.indexOf("ss") != -1) {
			h.put(new Integer(s.indexOf("ss")), "ss");
		}
		int intStart = 0;
		while (s.indexOf("-", intStart) != -1) {
			intStart = s.indexOf("-", intStart);
			h.put(new Integer(intStart), "-");
			intStart++;
		}
		intStart = 0;
		while (s.indexOf("/", intStart) != -1) {
			intStart = s.indexOf("/", intStart);
			h.put(new Integer(intStart), "/");
			intStart++;
		}
		intStart = 0;
		while (s.indexOf(" ", intStart) != -1) {
			intStart = s.indexOf(" ", intStart);
			h.put(new Integer(intStart), " ");
			intStart++;
		}
		intStart = 0;
		while (s.indexOf(":", intStart) != -1) {
			intStart = s.indexOf(":", intStart);
			h.put(new Integer(intStart), ":");
			intStart++;
		}
		if (s.indexOf("年") != -1) {
			h.put(new Integer(s.indexOf("年")), "年");
		}
		if (s.indexOf("月") != -1) {
			h.put(new Integer(s.indexOf("月")), "月");
		}
		if (s.indexOf("日") != -1) {
			h.put(new Integer(s.indexOf("日")), "日");
		}
		if (s.indexOf("时") != -1) {
			h.put(new Integer(s.indexOf("时")), "时");
		}
		if (s.indexOf("分") != -1) {
			h.put(new Integer(s.indexOf("分")), "分");
		}
		if (s.indexOf("秒") != -1) {
			h.put(new Integer(s.indexOf("秒")), "秒");
		}
		int i = 0;
		while (h.size() != 0) {
			Enumeration e = h.keys();
			int n = 0;
			while (e.hasMoreElements()) {
				i = ((Integer) e.nextElement()).intValue();
				if (i >= n) {
					n = i;
				}
			}
			String temp = (String) h.get(new Integer(n));
			h.remove(new Integer(n));
			javaFormat = temp + javaFormat;
		}
		SimpleDateFormat df = new SimpleDateFormat(javaFormat,
				new DateFormatSymbols());
		return df.format(d);
	}

	public static void main(String[] args) {
		Date d1 = CoreUtils.parseDate("2005-12-1");
		System.out.println(CoreUtils.nextMonth(d1));
	}

	public static String numberToEnglish(String number) {
		String strNum = "";

		String[] number2parts;
		number2parts = number.split("\\.");

		String intStr = number2parts[0];
		String fraStr = number2parts[1];

		int intStrLen = intStr.length();
		int fraStrLen = fraStr.length();

		if (intStrLen > 13) {
			return "The Number is Too Large.....";
		}
		if (fraStrLen > 6) {
			return "The Fraction Part is Too Long.....";
		}
		char[] intChar = intStr.toCharArray();
		char[] fraChar = fraStr.toCharArray();

		for (int j = intStrLen, i = 0; j >= 1; j = j - 3, i++) {
			String tmbt = "";
			if (i == 1) {
				tmbt = "thousand";
			} else if (i == 2) {
				tmbt = "million";
			} else if (i == 3) {
				tmbt = "billion";
			} else if (i == 4) {
				tmbt = "trillion";
			}
			if (j == 1) {
				String num3toeng = num3ToEng("00"
						+ String.valueOf(intChar[j - 1]));
				if (!num3toeng.equals("")) {
					strNum = num3toeng + tmbt + " " + strNum;
				}

			} else if (j == 2) {
				String num3toeng = num3ToEng("0"
						+ String.valueOf(intChar[j - 2])
						+ String.valueOf(intChar[j - 1]));
				if (!num3toeng.equals("")) {
					strNum = num3toeng + tmbt + " " + strNum;
				}

			} else if (j >= 3) {
				String num3toeng = num3ToEng(String.valueOf(intChar[j - 3])
						+ String.valueOf(intChar[j - 2])
						+ String.valueOf(intChar[j - 1]));
				if (!num3toeng.equals("")) {
					strNum = num3toeng + tmbt + " " + strNum;
				}
			}
		}
		String fraction = "";
		if (fraStrLen > 0) {
			fraction += "and cents ";
			for (int i = 0; i < fraStrLen; i++) {
				fraction += numToEng(String.valueOf(fraChar[i])) + " ";
			}
		}
		return (strNum + fraction).toLowerCase() + "only";
	}

	public static String num3ToEng(String str) {
		StringBuffer eng = new StringBuffer("");
		char[] chars = str.toCharArray();
		boolean bl = false;
		String and = "";// the "and" behind the hundred
		if (chars[0] != '0') {
			bl = true;
			eng.append(numToEng(String.valueOf(chars[0])) + " "
					+ numToEng("100") + " ");
		}
		if (chars[1] == '1') {
			if (bl) {
				and = "and ";
			}
			eng.append(and
					+ numToEng(String.valueOf(chars[1])
							+ String.valueOf(chars[2])) + " ");
		} else if (chars[1] == '0') {
			if (bl) {
				and = "and ";
			}
			if (chars[2] != '0') {
				eng.append(and + numToEng(String.valueOf(chars[2])) + " ");
			}
		} else {
			if (bl) {
				and = "and ";
			}
			if (chars[2] == '0') {
				eng
						.append(and + numToEng(String.valueOf(chars[1]) + "0")
								+ " ");
			} else {
				eng.append(and + numToEng(String.valueOf(chars[1]) + "0") + "-"
						+ numToEng(String.valueOf(chars[2])) + " ");
			}
		}

		return eng.toString();
	}

	public static String numToEng(String num) {
		String eng = "";
		Map map = new HashMap();

		map.put("0", "zero");
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");
		map.put("7", "seven");
		map.put("8", "eight");
		map.put("9", "nine");
		map.put("10", "ten");
		map.put("11", "eleven");
		map.put("12", "twelve");
		map.put("13", "thirteen");
		map.put("14", "fourteen");
		map.put("15", "fifteen");
		map.put("16", "sixteen");
		map.put("17", "seventeen");
		map.put("18", "eighteen");
		map.put("19", "nineteen");
		map.put("20", "twenty");
		map.put("30", "thirty");
		map.put("40", "forty");
		map.put("50", "fifty");
		map.put("60", "sixty");
		map.put("70", "seventy");
		map.put("80", "eighty");
		map.put("90", "ninety");
		map.put("100", "hundred");
		map.put("130", "thousand");
		map.put("160", "million");
		map.put("190", "billion");
		map.put("1120", "trillion");

		return eng = (String) map.get(num);
	}

	public static boolean isInteger(String val) {

		boolean ret = true;

		Integer ival = GenericTypeValidator.formatInt(val);

		if (ival == null) {

			ret = false;

		}

		return ret;

	}

	public static boolean isNotNegative(String value) {

		if (!BaseValidator.isValidateString(value))
			return false;
		if (!BaseValidator.isDouble(value)) {
			return false;
		}

		double dval = BaseValidator.toDouble(value);

		if (dval < 0) {
			return false;
		}

		return true;
	}

	// below added by feng.li for number to chinese

	private final static String[] a_strNumber = { "零", "壹", "贰", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖" };

	private final static String[] a_strModify = { "", "拾", "佰", "仟", "万", "拾",
			"佰", "仟", "亿", "拾", "佰", "仟" };

	private final static String strSign = "负";// 实际上”+“号永远都不可能出现.

	private final static String strDot = "点";

	/**
	 * 功能： 提取符号位. 说明： 如果输入参数是 "-13.3",调用该函数的返回值是 "负"; 如果输入参数是 "13.3", 调用该函数的返回值是
	 * ""(空值).
	 * 
	 * @param pValue
	 * 
	 */
	static private String getSign(String pValue) {
		return pValue.indexOf("-") == 0 ? "负" : "";
	}

	/**
	 * 功能：返回小数部分的汉字 说明：如果输入数据是 12.35,调用该函数返回值是 叁伍
	 * 
	 * @param pValue
	 * @return
	 */
	static private String getFraction(String pValue) {
		String strFraction = null;// 用来保存小数部分的数字串
		int intDotPos = pValue.indexOf(".");
		if (intDotPos == -1)// 没有小数部分.
			return "";
		strFraction = pValue.substring(intDotPos + 1);
		StringBuffer sbResult = new StringBuffer(strFraction.length());
		// 开始翻译.
		for (int i = 0; i < strFraction.length(); i++)
			sbResult.append(a_strNumber[strFraction.charAt(i) - 48]);
		return sbResult.toString();
	}

	/*
	 * 功能： 返回整数部分的汉字. 如果输入参数是: 234.3,调用该函数的返回值是 贰佰叁拾肆. @param pValue @return
	 */
	static private String getInteger(String pValue) {
		String strInteger = null;// 用来保存整数部分数字串
		int intDotPos = pValue.indexOf(".");// 记录"."所在位置
		int intSignPos = pValue.indexOf("-");
		if (intDotPos == -1)
			intDotPos = pValue.length();

		strInteger = pValue.substring(intSignPos + 1, intDotPos);

		// 反转整数部分数据
		strInteger = new StringBuffer(strInteger).reverse().toString();
		// -----------------------------------------------------------
		// 开始翻译：
		StringBuffer sbResult = new StringBuffer();
		for (int i = 0; i < strInteger.length(); i++) {
			sbResult.append(a_strModify[i]);
			sbResult.append(a_strNumber[strInteger.charAt(i) - 48]);
		}

		sbResult = sbResult.reverse();
		// 这个时候得到的结果不标准，需要调整.
		// 203返回值是 贰佰零拾三个 正确答案是 贰佰零三

		// --------------------------------------------------------------------------
		// 串调整.
		replace(sbResult, "零拾", "零");
		replace(sbResult, "零佰", "零");
		replace(sbResult, "零仟", "零");
		replace(sbResult, "零万", "万");
		replace(sbResult, "零亿", "亿");
		// 多个”零“调整处理
		replace(sbResult, "零零", "零");
		replace(sbResult, "零零零", "零");
		replace(sbResult, "零零零零万", "");// 这两句不能颠倒顺序
		replace(sbResult, "零零零零", "");

		replace(sbResult, "壹拾亿", "拾亿");// 这样读起来更习惯.
		replace(sbResult, "壹拾万", "拾万");

		// --------------------------------------------------------------------------

		if (sbResult.charAt(sbResult.length() - 1) == '零'
				&& sbResult.length() != 1)// 删除个位上的零
			sbResult.deleteCharAt(sbResult.length() - 1);

		if (strInteger.length() == 2) {
			replace(sbResult, "壹拾", "拾");
		}

		return sbResult.toString();// 将结果反转回来.
	}

	/**
	 * 功能： 返回分割符号 如果参数是"12.3" 调用该函数的返回值是"点" 如果参数是"12" 调用该函数的返回值是""(空值)
	 * 
	 * @param pValue
	 * @return
	 */
	static private String getDot(String pValue) {
		return pValue.indexOf(".") != -1 ? "点" : "";
	}

	// 数字到汉字
	static public String NumberToChinese(double pValue) {
		// 注意：不能用string.valueOf(pValue)处理,你自己试试就知道了.
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.#########");
		String pTemp = String.valueOf(df.format(pValue));
		StringBuffer sbResult = new StringBuffer(getSign(pTemp)
				+ getInteger(pTemp) + getDot(pTemp) + getFraction(pTemp));
		return sbResult.toString();

	}

	/**
	 * 功能：用给定字符串pDest替换字符串pValue中的pSource
	 * 
	 * @param pValue
	 * @param pSource
	 * @param pDest
	 * @return 经过替换处理的字符串 例：pValue= xy ,pSource =x ,pDest = 测试 调用改函数后pValue =测试y
	 * 
	 * 说明一下： 如果 pvalue= xxx pSource = xx 处理结果是 x ，这个结果可能与您平时看到的替换函数有点不一样，通常应该是
	 * pSource =xx.
	 * 
	 */
	static private void replace(StringBuffer pValue, String pSource,
			String pDest) {
		if (pValue == null || pSource == null || pDest == null)
			return;

		int intPos = 0;// 记录pSource在pValue中的位置
		do {
			// ---------------------------------------------------
			// intPos = pValue.toString().indexOf(pSource,intPos);
			// ---------------------------------------------------

			// ============================================
			intPos = pValue.toString().indexOf(pSource);
			// ============================================
			if (intPos == -1)// 没有找到pSource.
				break;
			pValue.delete(intPos, intPos + pSource.length());
			pValue.insert(intPos, pDest);

			// ---------------------------------
			//intPos += pSource.length();
			//---------------------------------
		} while (true);
	}

}
