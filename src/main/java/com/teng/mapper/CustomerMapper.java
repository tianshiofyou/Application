package com.teng.mapper;

import com.teng.entity.Customer;

public interface CustomerMapper {

        /**
         * 通过用户名获取用户
         * @param loginName
         * @return
         */
        Customer getCustomerByLoginName(String loginName);

        /**
         * 通过手机号码获取用户
         * @param mobile
         * @return
         */
        Customer getCustomerMobile(String mobile);

        /**
         * 通过邮件获取用户
         * @param email
         * @return
         */
        Customer getCustomerEmail(String email);

        /**
         * 注册插入用户
         * @param customer
         */
        void registerCustomer(Customer customer);

        /**
         * 每一次登录更新上次登录时间
         * @param customer
         */
        void updateLastLoginTime(Customer customer);

        /**
         * 退出登录
         * @param customer
         */
        void loginOut(Customer customer);

        void lockCustomer(String loginName);

}