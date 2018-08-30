/**
 * @(#) BigDecimalUtils.java 2013年7月14日
 * Copyright (c) 厦门极网商业互联技术有限公司
 */
package utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * BigDecimal运算工具类
 *
 * <pre>
 * &#64;author zcguo
 * &#64;功能说明:
 * ...................
 * &#64;版本更新列表
 * 修改版本: 1.0.0
 * 修改日期: 2013年7月14日
 * 修  改  人: zcguo
 * 修改说明: 形成初始版本
 * 复  审  人:
 * </pre>
 */
public class BigDecimalUtils {

    /**
     * 数值对比
     * @param d1
     * @param d2
     * @return
     */
    public static int compare(BigDecimal d1, BigDecimal d2) {
        d1 = d1 == null?new BigDecimal(0):d1;
        d2 = d2 == null?new BigDecimal(0):d2;
        return d1.compareTo(d2);
    }

    /**
     * 除100 上调数值
     *
     * @param v
     * @return
     */
    public static double per100ReUp(double v) {
        v = v / 100;
        BigDecimal vbig = BigDecimal.valueOf(v);
        vbig = vbig.setScale(0, BigDecimal.ROUND_UP);
        return vbig.doubleValue() * 100;
    }

    /**
     *
     * @param v
     * @return
     */
    public static BigDecimal per100ReUp(BigDecimal v) {
        v = v.divide(new BigDecimal("100"));
        v = v.setScale(0, BigDecimal.ROUND_UP);
        v = v.multiply(new BigDecimal("100"));
        return v;
    }

    /**
     *
     * @param v
     * @return
     */
    public static double mid2(double v) {
        BigDecimal vbig = BigDecimal.valueOf(v);
        vbig = vbig.setScale(2, BigDecimal.ROUND_DOWN);
        return vbig.doubleValue();
    }

    /**
     * 除100 上调数值
     *
     * @param v
     * @return
     */
    public static double per100Up(double v) {
        v = v / 100;
        BigDecimal vbig = BigDecimal.valueOf(v);
        vbig = vbig.setScale(0, BigDecimal.ROUND_UP);
        return vbig.doubleValue();
    }

    /**
     * BigDecimal数值求和 注意：如果其中某个参数为null，则过滤该参数，不参与处理
     *
     * @param bigDecimals
     * @return
     */
    public static BigDecimal add(BigDecimal... bigDecimals) {
        BigDecimal rs = null;
        for (BigDecimal data : bigDecimals) {
            if (rs == null) {
                rs = data;
            } else {
                if (data != null) {
                    rs = rs.add(data);
                }
            }
        }
        return rs;
    }

    /**
     *
     * @param b
     * @param scale
     * @return
     */
    public static String bigDecimal_halfup_String(BigDecimal b, int scale) {
        b = b.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return b.toString();
    }

    /**
     * 校验参数非空且大于等于0
     *
     * <pre>
     * &#64;功能说明:
     * 判断参数非空且大于0
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月17日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月17日
     * @param src
     *            校验对象
     * @return true-是 false-否
     */
    public static boolean isNotNullGtZero(BigDecimal src) {
        return src != null && src.compareTo(BigDecimal.ZERO) >= 0;
    }

    /**
     * 校验参数非空且不等于0
     *
     * <pre>
     * &#64;功能说明:
     * 校验参数非空且不等于0
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年8月30日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年8月30日
     * @param src
     *            校验对象
     * @return true-是 false-否
     */
    public static boolean isNotNullNotZero(BigDecimal src) {
        return src != null && src.compareTo(BigDecimal.ZERO) != 0;
    }

    /**
     * double转换为BigDecimal
     *
     * <pre>
     * &#64;功能说明:
     * double转换为BigDecimal
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月15日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月15日
     * @param src
     *            待转换的double值
     * @param decimalCount
     *            小数位数
     * @return 转换后的BigDecimal对象
     */
    public static BigDecimal doubleToBigDecimal(double src, int decimalCount) {
        return BigDecimal.valueOf(src).setScale(decimalCount, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * double转换为BigDecimal
     *
     * <pre>
     * &#64;功能说明:
     * double转换为BigDecimal
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年9月24日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年9月24日
     * @param src
     *            待转换的double值
     * @return 转换后的BigDecimal对象
     */
    public static BigDecimal doubleToBigDecimal(double src) {
        return BigDecimal.valueOf(src).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相加
     *
     * <pre>
     * &#64;功能说明:
     * 相加
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param add
     *            加数一
     * @param add2
     *            加数二
     * @return 相加后的结果
     */
    public static BigDecimal add(String add, String add2) {
        return add(new BigDecimal(add), new BigDecimal(add2));
    }

    /**
     * 相加
     *
     * <pre>
     * &#64;功能说明:
     * 相加
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param add
     *            加数一
     * @param add2
     *            加数二
     * @return 相加后的结果
     */
    public static BigDecimal add(BigDecimal add, BigDecimal add2) {
        if (add == null) {
            add = BigDecimal.ZERO;
        }
        if (add2 == null) {
            add2 = BigDecimal.ZERO;
        }
        return add.add(add2);
    }

    /**
     * 多个数相加
     *
     * <pre>
     * &#64;功能说明:
     * 多个数相加
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月30日
     * 修  改  人: zhangwei
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月30日
     *            多个数相加
     * @return 相减后结果
     */
    public static BigDecimal addMore(BigDecimal... add) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal a : add) {
            if (a == null) {
                a = BigDecimal.ZERO;
            }
            result = result.add(a);
        }
        return result;
    }

    /**
     *
     * @param add
     * @return
     */
    public static BigDecimal addMore(String... add) {
        BigDecimal result = BigDecimal.ZERO;
        for (String a : add) {
            if (a == null) {
                a = "0";
            }
            result = result.add(new BigDecimal(a));
        }
        return result;
    }

    /**
     * 相减
     *
     * <pre>
     * &#64;功能说明:
     * 相减
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param subbed
     *            被减数
     * @param sub
     *            减数
     * @return 相加后的结果
     */
    public static BigDecimal subtract(String subbed, String sub) throws Exception {
        if (subbed == null) {
            subbed = "0";
        }
        if (sub == null) {
            sub = "0";
        }
        return subtract(parseBigDecimal(subbed), parseBigDecimal(sub));
    }

    /**
     * 解析数字
     * @param numString
     * @return
     */
    public static BigDecimal parseBigDecimal(String numString) throws Exception {
        if (StringUtils.isEmpty(numString)) {
            return BigDecimal.ZERO;
        }
        String str = numString.replaceAll(",","").replaceAll(" ","");
        BigDecimal num = null;
        try{
            num = new BigDecimal(str);
        } catch (Exception ex){
            throw new Exception(numString+"不是数字");
        }

        return num;
    }

    /**
     * 相减
     *
     * <pre>
     * &#64;功能说明:
     * 相减
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param subbed
     *            被减数
     * @param sub
     *            减数
     * @return 相减后的结果
     */
    public static BigDecimal subtract(BigDecimal subbed, BigDecimal sub) {
        if (subbed == null) {
            subbed = BigDecimal.ZERO;
        }
        if (sub == null) {
            sub = BigDecimal.ZERO;
        }
        return subbed.subtract(sub);
    }

    /**
     * 多个数相减
     *
     * <pre>
     * &#64;功能说明:
     * 第一个数减其他所有数
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月30日
     * 修  改  人: zhangwei
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月30日
     * @param sub
     *            多个数相减,第一个为被减数，后面的都为减数
     * @return 相减后结果
     */
    public static BigDecimal subtractMore(BigDecimal... sub) {
        BigDecimal result = null;
        for (BigDecimal b : sub) {
            result = result == null ? b : result.subtract(b);
        }
        return result;
    }

    /**
     * 相乘，结果小数点保留2位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相乘，结果小数点保留2位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 相乘后的结果
     */
    public static BigDecimal multiply(String mulled, String mul) {
        return multiply(new BigDecimal(mulled), new BigDecimal(mul));
    }

    /**
     * 相乘，结果小数点保留2位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相乘，结果小数点保留2位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 相乘后的结果
     */
    public static BigDecimal multiply(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘，结果小数点保留2位有效数字(小数点后>2位，就进位)
     *
     * <pre>
     * &#64;功能说明:
     * 相乘，结果小数点保留2位有效数字(小数点后>2位，就进位)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年12月4日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年12月4日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 相乘后的结果
     */
    public static BigDecimal multiplyRoundUp(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(2, BigDecimal.ROUND_UP);
    }

    /**
     * 相除，结果小数点保留2位有效数字(无论如何都不进位)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留2位有效数字(无论如何都不进位)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年12月4日
     * 修  改  人: lizhen
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年12月4日
     * @param divide
     *            被除数
     * @param divided
     *            除数
     * @return 相除以后的结果
     */
    public static BigDecimal divideRoundDown(BigDecimal divide, BigDecimal divided) {
        return divide.divide(divided, 2, BigDecimal.ROUND_UP);
    }

    /**
     * 相乘，结果小数点保留4位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相乘，结果小数点保留4位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年10月08日
     * 修  改  人: mafang
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年10月08日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 相乘后的结果
     */
    public static BigDecimal multiplyFore(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘后取整
     *
     * <pre>
     * &#64;功能说明:
     * 相乘后取整
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年8月19日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年8月19日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 整数
     */
    public static Integer multiply(BigDecimal mulled, Long mul) {
        return mulled.multiply(new BigDecimal(String.valueOf(mul)).setScale(0, BigDecimal.ROUND_DOWN)).intValue();
    }

    /**
     * 相乘后取整
     *
     * <pre>
     * &#64;功能说明:
     * 相乘后取整
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年8月19日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年8月19日
     * @return 整数
     */
    public static Integer divideToInt(BigDecimal divided, BigDecimal divide) {
        return divide(divided, divide).intValue();
    }

    /**
     * 相乘，结果小数点保留4位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相乘，结果小数点保留4位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: kmlin
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月18日
     * @param mulled
     *            被乘数
     * @param mul
     *            乘数
     * @return 相乘后的结果
     */
    public static BigDecimal multiply4(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * @param mulled
     * @param mul
     * @return
     */
    public static BigDecimal multiply3(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * @param mulled
     * @param mul
     * @return
     */
    public static BigDecimal multiply8(BigDecimal mulled, BigDecimal mul) {
        return mulled.multiply(mul).setScale(8, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除，结果小数点保留2位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留2位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static BigDecimal divide(String divided, String divide) {
        return divide(new BigDecimal(divided), new BigDecimal(divide));
    }

    /**
     * 相除，结果小数点保留4位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留4位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static BigDecimal divide4(String divided, String divide) {
        return divide4(new BigDecimal(divided), new BigDecimal(divide));
    }

    /**
     * 相除，结果小数点保留2位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留2位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static BigDecimal divide(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除，结果小数点保留4位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留4位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: mafang
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年10月08日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static BigDecimal divideFore(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除，结果小数点保留4位有效数字(四舍五入)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果小数点保留4位有效数字(四舍五入)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月14日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月14日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static BigDecimal divide4(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * @param divided
     * @param divide
     * @return
     */
    public static BigDecimal divide3(BigDecimal divided, BigDecimal divide) {
        if (divided == null) {
            return new BigDecimal("0.000");
        }
        if (divide == null) {
            return new BigDecimal("0.000");
        }
        if (divide.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal("0.000");
        }
        return divided.divide(divide, 3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * @param divided
     * @param divide
     * @return
     */
    public static BigDecimal divide2(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * @param divided
     * @param divide
     * @return
     */
    public static BigDecimal divide8(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 8, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除，结果保留整数部分(整型)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果保留整数部分
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月19日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月19日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static int divideNoRound(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 0, BigDecimal.ROUND_DOWN).intValue();
    }

    /**
     * 相除，结果保留整数部分(整型)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果保留整数部分
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年7月19日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年7月19日
     * @param divided
     *            被除数
     * @param divide
     *            除数
     * @return 相除后的结果
     */
    public static int divideROUND_UP(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 0, BigDecimal.ROUND_UP).intValue();
    }

    /**
     * 相除，结果保留整数部分(长整型)
     *
     * <pre>
     * &#64;功能说明:
     * 相除，结果保留整数部分(长整型)
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年11月18日
     * 修  改  人: zcguo
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年11月18日
     * @param divided
     * @param divide
     * @return
     */
    public static long divideNoRoundLong(BigDecimal divided, BigDecimal divide) {
        return divided.divide(divide, 0, BigDecimal.ROUND_DOWN).longValue();
    }

    /**
     * BigDecimal 转 String
     *
     * <pre>
     * &#64;功能说明:
     * ...................
     * &#64;版本更新列表
     * 修改版本: 1.0.0
     * 修改日期: 2013年10月22日
     * 修  改  人: zhangwei
     * 修改说明: 形成初始版本
     * 复  审  人:
     * </pre>
     *
     * @date 2013年10月22日
     * @param b
     * @param scale
     * @return
     */
    public static String bigDecimal2String(BigDecimal b, int scale) {
        if (b == null) {
            return "";
        }
        b = b.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return b.toString();
    }

    /**
     * BigDecimal 转 String 0.00 转为 ""
     *
     * @param b
     * @param scale
     * @return
     */
    public static String bigDecimal2StringTemp(BigDecimal b, int scale) {
        if (b == null) {
            return "";
        }
        b = b.setScale(scale, BigDecimal.ROUND_HALF_UP);
        String bstr = b.toString();
        if ("0".equals(bstr)) {
            return "";
        } else if ("0.00".equals(bstr)) {
            return "";
        } else {
            return bstr;
        }
    }
}
