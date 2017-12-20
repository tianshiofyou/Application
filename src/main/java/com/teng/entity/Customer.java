package com.teng.entity;

import com.alibaba.fastjson.JSON;
import com.teng.Utils.DateTime;
import com.teng.Utils.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Customer {
        /**
         * 用户ID
         */
        private String CustomerId = StringUtils.Empty;
        /**
         * 登录名
         */
        @Length(min = 4, max = 20, message = "登录名长度在4~20个字符")
        private String LoginName = StringUtils.Empty;
        /**
         * 手机号码
         */
        @Pattern(regexp = "^1[3|4|5|8][0-9]\\d{4,8}$", message = "手机号码不正确")
        private String Mobile = StringUtils.Empty;
        /**
         * email地址
         */
        @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "邮箱不正确")
        private String Email = StringUtils.Empty;
        /**
         * 登录密码
         */
        @NotEmpty
        private String LoginPwd = StringUtils.Empty;
        /**
         * 注册时间 yyyy-MM-dd HH:mm:ss.SSS
         */
        //@NotEmpty
        private String RegTime = StringUtils.Empty;
        /**
         * 用户状态标识
         */
        //@Pattern(regexp = "/d{2}", message = "状态为两位数字")
        private String Status = StringUtils.Empty;

        /**
         * 上次登录成功时间
         */
        private String LastLoginTime = StringUtils.Empty;

        public String getCustomerId() {
                return CustomerId;
        }

        public void setCustomerId(String customerId) {
                CustomerId = customerId;
        }

        public String getLoginName() {
                return LoginName;
        }

        public void setLoginName(String loginName) {
                LoginName = loginName;
        }

        public String getMobile() {
                return Mobile;
        }

        public void setMobile(String mobile) {
                Mobile = mobile;
        }

        public String getEmail() {
                return Email;
        }

        public void setEmail(String email) {
                Email = email;
        }

        public String getLoginPwd() {
                return LoginPwd;
        }

        public void setLoginPwd(String loginPwd) {
                LoginPwd = loginPwd;
        }

        public String getRegTime() {
                return RegTime;
        }

        public void setRegTime(String regTime) {
                RegTime = regTime;
        }

        public String getStatus() {
                return Status;
        }

        public void setStatus(String status) {
                Status = status;
        }

        public String getLastLoginTime() {
                return LastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
                LastLoginTime = lastLoginTime;
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
