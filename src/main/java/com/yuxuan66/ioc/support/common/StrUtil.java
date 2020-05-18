package com.yuxuan66.ioc.support.common;

/**
 * @author Sir丶雨轩
 * @date 2020/5/18
 */
public class StrUtil {

    /**
     * 将字符串首字母转为小写
     * @param s 字符串
     * @return 结果
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        }else{
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }

}
