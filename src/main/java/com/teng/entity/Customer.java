package com.teng.entity;

import com.alibaba.fastjson.JSON;
import com.teng.Utils.DateTime;
import com.teng.Utils.Strings;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class Customer {
        /**
         * 用户ID
         */
        private String customerId = Strings.Empty;
        /**
         * 登录名
         */
        @Length(min = 4, max = 20, message = "登录名长度在4~20个字符")
        private String loginName = Strings.Empty;
        /**
         * 手机号码
         */
        @Pattern(regexp = "^1[3|4|5|8][0-9]\\d{4,8}$", message = "手机号码不正确")
        private String mobile = Strings.Empty;
        /**
         * email地址
         */
        @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "邮箱不正确")
        private String email = Strings.Empty;
        /**
         * 登录密码
         */
        @NotEmpty
        private String loginPwd = Strings.Empty;
        /**
         * 注册时间 yyyy-MM-dd HH:mm:ss.SSS
         */
        //@NotEmpty
        private String regTime = Strings.Empty;
        /**
         * 用户状态标识
         */
        //@Pattern(regexp = "/d{2}", message = "状态为两位数字")
        private String status = Strings.Empty;

        /**
         * 上次登录成功时间
         */
        private String lastLoginTime = Strings.Empty;

        public String getCustomerId() {
                return customerId;
        }

        public void setCustomerId(String customerId) {
                this.customerId = customerId;
        }

        public String getLoginName() {
                return loginName;
        }

        public void setLoginName(String loginName) {
                this.loginName = loginName;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getLoginPwd() {
                return loginPwd;
        }

        public void setLoginPwd(String loginPwd) {
                this.loginPwd = loginPwd;
        }

        public String getRegTime() {
                return regTime;
        }

        public void setRegTime(String regTime) {
                this.regTime = regTime;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getLastLoginTime() {
                return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
        }

        public String toString(){
                return "Customer：\t{\"lastLoginTime\":\"2017-12-13 12:29:28.159\",\"regTime\":\"213\",\"loginPwd\":\"11111\",\"loginName\":\"teng\",\"customerId\":\"0001\",\"mobile\":\"123564545646\",\"email\":\"123@163.com\",\"status\":\"0\"}";
        }

        public static void main(String[] args) {
                Customer customer = new Customer();
                customer.setCustomerId("0001");
                customer.setLastLoginTime(DateTime.getCurrent());
                customer.setEmail("123@163.com");
                customer.setLoginPwd("11111");
                customer.setLoginName("teng");
                customer.setMobile("123564545646");
                customer.setRegTime("213");
                customer.setStatus("0");
                System.out.println(JSON.toJSON(customer));
        }
}
