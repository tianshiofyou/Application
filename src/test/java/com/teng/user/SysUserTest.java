package com.teng.user;

import com.teng.model.builder.SysUserBuilder;
import com.teng.log.LogTest;
import com.teng.model.dao.repository.SysUserRepository;
import com.teng.model.dao.repository.domain.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by admin on 2018/1/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {

        private final static Logger logger = LoggerFactory.getLogger(LogTest.class);
        @Autowired
        SysUserRepository sysUserRepository;

        @Test
        public void test() throws Exception {
                SysUser sysUser = SysUserBuilder.getBuilder()
                        .createBy("admin")
                        .createTime("2018年1月7日14:34:20")
                        .descInfo("Spring-data test")
                        .disableFlag("1")
                        .email("46556@qq.com")
                        .lastLoginIp("127.0.0.1")
                        .lastLoginTime("2018年1月7日14:35:56")
                        .loginCount("1")
                        .orgId("001")
                        .password("123456")
                        .phone("1878923233")
                        .roleCode("01")
                        .updateBy("001")
                        .updateTime("2018年1月7日14:38:08")
                        .userId("001")
                        .userName("root")
                        .getSysUser();

                sysUserRepository.save(sysUser);
                sysUser.setUserId("002");
                sysUser.setUserName("root01");
                sysUserRepository.save(sysUser);
                sysUser.setUserId("003");
                sysUser.setUserName("root02");
                sysUserRepository.save(sysUser);
                sysUser.setUserId("004");
                sysUser.setUserName("root03");
                sysUserRepository.save(sysUser);
                List<SysUser> all = sysUserRepository.findAll();
                //logger.info(JSON.toJSONString(all));
                // 测试findAll, 查询所有记录
                Assert.assertEquals(4, all.size());
        }

        @Test
        public void testQueryByUserName(){
                SysUser root02 = sysUserRepository.findByUserName("root02");
                logger.info(root02.toString());
                // 测试findByName, 查询姓名为FFF的User
                //Assert.assertEquals("UserId  不相等","004", root02.getUserId());
        }
}
