package com.teng.Utils;

public class Strings {
        public static String Empty = "";

        public static boolean isNull(String str){
                return str == null;
        }

        public static boolean isNotNull(String str){
                return !isNull(str);
        }

        public static boolean isNullOrEmpty(String str){
                return isNull(str) || str.isEmpty();
        }

        public static boolean isBlank(String str){
                return str.trim().isEmpty();
        }

        public static boolean isNotBlank(String str){
                return !isBlank(str);
        }

        public static boolean isNullOrBlank(String str){
                return isNull(str) || isBlank(str);
        }

        public static boolean isEmptyOrBlank(String str){
                return str.isEmpty() || isBlank(str);
        }

        public static boolean isNullString(String str){
                return str.equals("null");
        }

        public static boolean isOfNull(String str){
                return isNull(str) || isNullString(str);
        }

        public static boolean isNotEffective(String str){
                return isOfNull(str) || isEmptyOrBlank(str);
        }

        public static boolean isEffective(String str){
                return !isNotEffective(str);
        }


}
