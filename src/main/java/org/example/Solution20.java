package org.example;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * <p>
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class Solution20 {
    public boolean isNumber(String s) {
        /*
         * 官方题解都是状态机一堆乱七八糟的，实际上搞明白哪些情况合法就可以了
         */
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        boolean numFlag = false, // 记录数字是否出现
                dotFlag = false, // 记录.是否出现
                eFlag = false; // 记录e是否出现
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                //判定为数字，则标记numFlag
                numFlag = true;
            } else if (c == '.' && !dotFlag && !eFlag) {
                //判定为. 需要没出现过.并且没出现过e
                dotFlag = true;
            } else if ((c == 'e' || c == 'E') && !eFlag && numFlag) {
                //判定为e，需要没出现过e，并且数字出现过了
                eFlag = true;
                numFlag = false; //为了避免123e这种请求，出现e之后就标志为false
            } else if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //+-符号只能出现在第一位或者紧接e后面
            } else {
                //其他情况，都是非法的
                return false;
            }
        }
        return numFlag;
    }

//    private static final Pattern pattern = Pattern.compile("^[+\\-]?(\\d+(\\.\\d*)?|\\.\\d+)([Ee][+\\-]?\\d+)?$");
//
//    public boolean isNumber(String s) {
//        if (s == null) return false;
//        s = s.trim();
//        if (s.length() == 0) return false;
//        // 直接正则摆烂 :p
//        return pattern.matcher(s).matches();
//    }
}
