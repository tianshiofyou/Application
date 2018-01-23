package com.teng;

import com.teng.log.LogTest;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by admin on 2018/1/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
        protected final static Logger logger = LoggerFactory.getLogger(LogTest.class);
}
