package com.teng.login;

import com.teng.Utils.CustomerUitils;
import com.teng.Utils.DateTime;
import com.teng.entity.Customer;
import com.teng.enums.CusStatusEnum;
import com.teng.mapper.CustomerMapper;
import com.teng.web.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

        private Logger logger = LoggerFactory.getLogger(CustomerController.class);
        @Autowired
        private CustomerMapper mapper;

        @Test
        public void testRegister() throws Exception {
                Customer customer = new Customer();
                customer.setCustomerId(CustomerUitils.getCustomerId());
                customer.setStatus(CusStatusEnum.OFFLINE.getCode());
                customer.setRegTime(DateTime.getCurrent());
                customer.setLoginName("teng002");
                customer.setLoginPwd("123456");
                customer.setMobile("18779461234");
                customer.setEmail("123456951@qq.com");
                customer.setLastLoginTime(DateTime.getCurrent());
                mapper.registerCustomer(customer);
                String log = String.format("用户注册成功，注册信息为：\r\n%s", customer);
                logger.info(log);

        }

        @Test
        public void testLogin() throws Exception {
                Customer customer = new Customer();
                customer.setLoginName("teng");
                customer.setLoginPwd("123456");
                Customer rcustomer = mapper.getCustomerByLoginName(customer.getLoginName());
                if (rcustomer == null) {
                        logger.info("账号不存在");
                        return;
                }
                boolean isPassRight = rcustomer.getLoginPwd().equals(customer.getLoginPwd());
                if(isPassRight) {
                        customer.setLastLoginTime(DateTime.getCurrent());
                        mapper.updateLastLoginTime(customer);
                        logger.info("登录成功");
                        String log = String.format("当前用户信息:\r\n%s", customer.toString());
                        logger.info(log);
                } else {
                        logger.info("密码错误");
                }
        }

        /**
         * 对字符串md5加密
         *
         * @return
         */
        @Test
        public void getMD5() {
                try {
                        // 生成一个MD5加密计算摘要
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        // 计算md5函数
                        md.update("123456".getBytes());
                        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
                        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                        String pass =  new BigInteger(1, md.digest()).toString(16);
                        logger.info("加密结果：" + pass);
                } catch (Exception e) {
                        logger.info("MD5加密出现错误");
                }
        }

        @Test
        public void validateParms(){

                try {
                        Customer customer = new Customer();
                        customer.setCustomerId(CustomerUitils.getCustomerId());
                        customer.setStatus(CusStatusEnum.OFFLINE.getCode());
                        customer.setRegTime(DateTime.getCurrent());
                        customer.setLoginName("teng002");
                        customer.setLoginPwd("123456");
                        customer.setMobile("18779461234");
                        customer.setEmail("123456456@qq.com");
                        customer.setLastLoginTime(DateTime.getCurrent());
                        Customer _cus = mapper.getCustomerByLoginName(customer.getLoginName());
                        Assert.isNull(_cus, "用户名已存在");
                        _cus = mapper.getCustomerEmail(customer.getEmail());
                        Assert.isNull(_cus, "该邮箱已注册");
                        _cus = mapper.getCustomerMobile(customer.getMobile());
                        Assert.isNull(_cus, "该手机号已注册");
                } catch (Exception e) {
                        logger.info(e.getMessage());
                }
        }


}
