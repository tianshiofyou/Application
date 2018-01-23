package com.teng.event.listener;

import com.teng.event.CusOprateLogEvent;
import com.teng.model.dao.mapper.LogMapper;
import com.teng.model.CusLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

/**
 * Created by admin on 2017/12/26.
 */
public class CusOprateLogListener implements ApplicationListener<CusOprateLogEvent> {


        private static final Logger logger = LoggerFactory.getLogger(CusOprateLogListener.class);

        @Autowired
        private LogMapper mapper;

        @Override
        public void onApplicationEvent(CusOprateLogEvent cusOprateLogEvent) {
                try {
                        CusLog cusLog = (CusLog) cusOprateLogEvent.getSource();
                        mapper.wirteReqestLog(cusLog);
                        logger.info("写入日志成功");
                } catch (Exception e) {
                        logger.error("写入日志出错", e);
                }
        }
}
