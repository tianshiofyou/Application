package com.teng.user;

import com.alibaba.fastjson.JSON;
import com.teng.BaseTest;
import com.teng.model.builder.CustomerBuilder;
import com.teng.model.entity.Customer;
import com.teng.model.dao.jdbc.CustomerDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by admin on 2018/1/16.
 */

public class JdbcTest extends BaseTest {

        @Autowired
        CustomerDao customerDao;
        //BaseDao<Customer> dao;
        @Test
        public void queryListTest() {
                try {
                        List<Customer> all = customerDao.getAll();
                        logger.info("查询List成功");
                        logger.info("result:\r\n" + JSON.toJSONString(all));
                } catch (Exception e) {
                        logger.error("查询用户列表失败", e);
                }
        }

        @Test
        public void queryOneTest() {
                Customer customer = null;
                try {
                        customer = customerDao.getOne("admin");
                        logger.info("查询One成功");
                        logger.info("result:\r\n" + customer);
                } catch (Exception e) {
                        logger.error("查询单条记录失败",e);
                }

        }

        @Test
        public void addOneTest(){
                try {
                        Customer customer = CustomerBuilder.getBuilder()
                                .customerId(UUID.randomUUID().toString())
                                .loginName("admin")
                                .loginPwd("123456")
                                .email("1234@qq.com")
                                .lastLoginTime("2018年1月17日22:47:39")
                                .mobile("12374728281")
                                .regTime("2018年1月17日22:48:09")
                                .status("01")
                                .getCustomer();
                        logger.info(customer.toString());
                        customerDao.addOne(customer);
                } catch (Exception e) {
                        logger.info("添加Customer失败,失败原因：" + e.getMessage());
                }
        }
        @Test
        public void batch(){

                try {
                        Set set = new HashSet();
                        List<Customer> customers = new ArrayList<>(10);
                        for (int i = 0; i < 10; i++) {
                                customers.add(CustomerBuilder.getBuilder()
                                        .customerId(UUID.randomUUID().toString())
                                        .loginName("admin" + i)
                                        .loginPwd("123456")
                                        .email("1234@qq.com")
                                        .lastLoginTime("2018年1月17日22:47:39")
                                        .mobile("12374728281")
                                        .regTime("2018年1月17日22:48:09")
                                        .status("01")
                                        .getCustomer());
                        }
                        customerDao.addList(customers);
                        logger.info("批量插入成功");
                } catch (Exception e) {
                        logger.error("批量插入出错", e);
                }
        }
}
