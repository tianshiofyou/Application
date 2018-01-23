package com.teng.model;

public class ResponseMsg {
        /**
         * 状态码
         */
        private String code;
        /**
         * 错误信息
         */
        private String msg;
        /**
         * 数据
         */
        private Object data;

        public ResponseMsg(){}


        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getMsg() {
                return msg;
        }

        public void setMsg(String msg) {
                this.msg = msg;
        }

        public Object getData() {
                return data;
        }

        public void setData(Object data) {
                this.data = data;
        }
}
