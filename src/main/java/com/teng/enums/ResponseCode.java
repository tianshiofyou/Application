package com.teng.enums;

public enum  ResponseCode {
        ILLEGAL_SUBMIT("401", "Illegal submit"), // 非法的表单提交申请
        NOTFOUND_RESOURCE("404", "not found"), // 资源不存在
        LOCKED_RESOURCE("405", "can't found resource"), // 资源被锁定
        SYS_ERROR("500", "system is busy,please wait"), // 系统出错了
        SYS_EXCEPTION("0500", "系统内部异常"), // 系统出错了
        INVOKE_ALLOW("403", "Do not have permission "), // 没有权限调用接口
        SESSION_TIMEOUT("400", "session timeout "), // 超时
        INVOKE_SUCCESS("0000", "invoke success"), // 调用成功
        DEVELOPING("9998", "the target service developing"), // 正在开发中
        OTHER_ERROR("9999", " Unknown Error"), // 未知错误
        NULL_PARAM("1001", "null param"), // 参数为空
        INVALID_PARAM("1002", "invalid param"), // 参数无效
        OUTLIMIT_PARAM("1003", "param length out of limit"), // 参数长度超过最大限制
        ERROR_PWD("1010","账号或密码输入有误"),
        RESETLOGINPWD("1007","需重置登陆密码"),
        RESETTRADEPWD("1008","需重置交易密码"),
        RESETPWD("1009","需重置登陆密码、交易密码"),
        LOGIN_ERROR_CONTINUOUS("5006", "登录密码连续输入错误"),
        NOT_LOGINED("5005", "登录超时或未登录"), //未登录
        XSS_INJURE("5005", "脚本注入攻击"); //脚本注入注入攻击

        private String retcode;

        private String retmsg;

        private ResponseCode(String retcode, String retmsg) {
                this.retcode = retcode;
                this.retmsg = retmsg;
        }

        public String getRetcode() {
                return retcode;
        }

        public void setRetcode(String retcode) {
                this.retcode = retcode;
        }

        public String getRetmsg() {
                return retmsg;
        }

        public void setRetmsg(String retmsg) {
                this.retmsg = retmsg;
        }
}
