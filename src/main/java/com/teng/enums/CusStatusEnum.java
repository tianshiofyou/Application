package com.teng.enums;

public enum CusStatusEnum {
        //登录中
        LOGINING("01", "登录中"),
        //被禁止
        FORBIDDEN("03", "被禁止"),
        //黑名单
        BLACK("04", "黑名单"),
        //冻结
        FREEZE("05", "已冻结"),
        //离线
        OFFLINE("00", "已离线"),
        //注销
        DISABLE("06", "已注销"),
        //逻辑删除
        DELETE("07", "已删除");

        private String Code; //代码

        private String Value; //中文

        private CusStatusEnum(String code, String value){
                Code = code;
                Value = value;
        }

        public String getCode() {
                return Code;
        }

        public void setCode(String code) {
                Code = code;
        }

        public String getValue() {
                return Value;
        }

        public void setValue(String value) {
                Value = value;
        }

        @Override
        public String toString() {
                return Value;
        }
}
