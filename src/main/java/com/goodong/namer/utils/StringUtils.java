package com.goodong.namer.utils;

public class StringUtils {

    public static final String CONST_REGEX= "^(?!_)(?!.*_{2})(?!.*_$)[A-Z][A-Z_]*$";
    public static boolean isFirstUpperCase(String name){
        char firstCharacter = name.charAt(0);
        return !Character.isLowerCase(firstCharacter);
    }

    public static String toFirstUpperCase(String name){
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
    public static String toFirstLowerCase(String name){
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
}
