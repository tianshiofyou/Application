package com.teng.biz.service;

import com.teng.model.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

        /**
         * 验证登录用户信息
         * @return
         */
        Customer customerValidate(Customer customer) throws Exception;

        /**
         * 注册用户
         * @param customer
         * @return
         */
        boolean registerCustomer(Customer customer) throws Exception;

        /**
         * 获取验证码
         * @return
         */
        Integer getAutorCode(String reqeustNo);

        /**
         * 锁定当前账户
         * @param loginName
         */
        void lockCustomer(String loginName);

        /**
         * 退出登录
         */
        void loginOut(Customer customer);

}
