package com.teng.log;

import com.alibaba.fastjson.JSON;
import com.teng.model.builder.CusLogBuilder;
import com.teng.model.dao.mapper.LogMapper;
import com.teng.model.CusLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/1/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

        private final static Logger logger = LoggerFactory.getLogger(LogTest.class);

        @Autowired
        private LogMapper mapper;

        @Test
        public void writeLog(){
                try {
                        CusLog log = CusLogBuilder.parse(new CusLog())
                                .interfaceName("/login")
                                .loginName("")
                                .ipAddress("127.0.0.1")
                                .invokeTimes(new Date())
                                .expendTimes(1)
                                .invokeResult("调用成功")
                                .requestData("")
                                .responseData("")
                                .remark("测试")
                                .getLog();
                        mapper.wirteReqestLog(log);
                        logger.info("日志写入成功");
                } catch (Exception e) {
                        logger.error("日志写入失败", e);
                }
        }

        @Test
        public void queryLog(){
                try {
                        List<CusLog> cusLogs = mapper.queryReqestLog(CusLog.Empty);
                        logger.info("查询成功");
                        logger.info(JSON.toJSONString(cusLogs));
                } catch (Exception e) {
                        logger.error("查询失败", e);
                }
        }
}
