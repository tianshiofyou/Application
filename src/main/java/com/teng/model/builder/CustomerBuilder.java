package com.teng.model.builder;

import com.teng.model.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 2018/1/11.
 */
public class CustomerBuilder {

        private Customer customer;

        private CustomerBuilder(){
                customer = new Customer();
        }

        public static CustomerBuilder getBuilder(){
                CustomerBuilder builder = new CustomerBuilder();
                return builder;
        }

        public CustomerBuilder customerId(String customerId){
                customer.setCustomerId(customerId);
                return this;
        }

        public CustomerBuilder loginName(String loginName){
                customer.setLoginName(loginName);
                return this;
        }

        public CustomerBuilder loginPwd(String loginPwd){
                customer.setLoginPwd(loginPwd);
                return this;
        }

        public CustomerBuilder mobile(String mobile){
                customer.setMobile(mobile);
                return this;
        }

        public CustomerBuilder email(String email){
                customer.setEmail(email);
                return this;
        }

        public CustomerBuilder status(String status){
                customer.setStatus(status);
                return this;
        }

        public CustomerBuilder regTime(String regTime){
                customer.setRegTime(regTime);
                return this;
        }

        public CustomerBuilder lastLoginTime(String lastLoginTime){
                customer.setLastLoginTime(lastLoginTime);
                return this;
        }

        public Customer getCustomer(){
                return customer;
        }

        /**
         * 通过jdbc查询出来的resultSet转换为Customer
         * ["CusId", "LoginName", "LoginPwd"，"Mobile"，"Email"，"Status"，"RegTime"，"LastLoginTime"]
         * @param resultSet
         * @return
         * @throws Exception
         */
        public static Customer parseResultSet(ResultSet resultSet) throws SQLException {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getString("CUS_ID"));
                customer.setLoginName(resultSet.getString("LOGIN_NAME"));
                //customer.setLoginPwd(resultSet.getString("LoginPwd"));
                customer.setMobile(resultSet.getString("Mobile"));
                customer.setEmail(resultSet.getString("Email"));
                customer.setStatus(resultSet.getString("Status"));
                customer.setRegTime(resultSet.getString("REG_TIME"));
                customer.setLastLoginTime(resultSet.getString("LAST_LOGINTIME"));
                return customer;
        }
}
