package com.teng.event;

import com.teng.model.CusLog;
import org.springframework.context.ApplicationEvent;

/**
 * Created by admin on 2017/12/26.
 */
public class CusOprateLogEvent extends ApplicationEvent {

        public CusOprateLogEvent(CusLog source) {
                super(source);
        }

}
