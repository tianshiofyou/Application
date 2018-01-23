package com.teng.biz.service.imp;

import com.teng.Utils.CacheUtis;
import com.teng.Utils.CustomerUitils;
import com.teng.Utils.DateTime;
import com.teng.Utils.MD5Utils;
import com.teng.model.entity.Customer;
import com.teng.constants.enums.CusStatusEnum;
import com.teng.model.dao.mapper.CustomerMapper;
import com.teng.biz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("CustomerService")
public class CustomerSeviceImp implements CustomerService {
        @Autowired
        private CustomerMapper mapper;

        /**
         * 验证登录的用户名密码是否正确
         * 如果正确更新最后一次登录时间(用户状态也会被更新为登录中)
         * @param customer
         * @return
         */
        @Override
        public Customer/*Optional<Customer>*/ customerValidate(Customer customer) throws Exception {
                if(CacheUtis.isLock(customer.getLoginName())){
                        throw new Exception("该账户已锁定！");
                }
                Customer rcustomer = mapper.getCustomerByLoginName(customer.getLoginName());
                if (rcustomer == null) {
                        return null;//Optional.ofNullable(null);
                }
                /*if (rcustomer.getStatus().equals(CusStatusEnum.FREEZE.getCode())){
                        throw new Exception("该账户已锁定！");
                }*/
                String md5pass = MD5Utils.getMD5(customer.getLoginPwd());
                boolean isPassRight = rcustomer.getLoginPwd().equals(md5pass);
                if(isPassRight) {
                        customer.setLastLoginTime(DateTime.getCurrent());
                        mapper.updateLastLoginTime(customer);
                        CacheUtis.removeLock(customer.getLoginName());
                        return rcustomer;//Optional.ofNullable(rcustomer);
                }
                return null;
        }

        @Override
        public boolean registerCustomer(Customer customer) throws Exception{
                Customer _cus = mapper.getCustomerByLoginName(customer.getLoginName());
                Assert.notNull(_cus, "用户名已存在");
                _cus = mapper.getCustomerEmail(customer.getEmail());
                Assert.notNull(_cus, "该邮箱已注册");
                _cus = mapper.getCustomerMobile(customer.getMobile());
                Assert.notNull(_cus, "该手机号已注册");
                customer.setCustomerId(CustomerUitils.getCustomerId());
                customer.setRegTime(DateTime.getCurrent());
                customer.setStatus(CusStatusEnum.OFFLINE.getCode());
                String md5pass = MD5Utils.getMD5(customer.getLoginPwd());
                customer.setLoginPwd(md5pass);
                mapper.registerCustomer(customer);
                return true;
        }

        @Override
        public Integer getAutorCode(String reqeustNo) {
                return CacheUtis.getAuthorCode(reqeustNo);
        }

        @Override
        public void lockCustomer(String loginName) {
                mapper.lockCustomer(loginName);
                CacheUtis.setLock(loginName);
        }

        @Override
        public void loginOut(Customer customer) {
                mapper.loginOut(customer);
        }
}
