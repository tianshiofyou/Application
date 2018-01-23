package com.teng.web;

import com.teng.Utils.RequestUtils;
import com.teng.model.entity.Customer;
import com.teng.event.CusOprateLogEvent;
import com.teng.model.CusLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by admin on 2017/12/27.
 */
public class BaseController {

        @Autowired
        ApplicationContext applicationContext;

        /**
         * 本想做controller通用的日志记录
         * 后面又用AOP替代了
         * @param request
         * @param interfaceName
         * @param action
         */
        protected void saveLog(String interfaceName, String action){
                String ipAddr = RequestUtils.getIpAddr();
                CusLog logModel = new CusLog();
                logModel.setIpAddress(ipAddr);
                logModel.setInterfaceName(interfaceName);
                //logModel.setAction(action);
                //logModel.setOperatingTime(String.valueOf(Instant.now().toEpochMilli()));
                Customer customer = (Customer) RequestUtils.getRequest().getSession().getAttribute("Customer");
                //logModel.setOperator(customer.getLoginName());
                applicationContext.publishEvent(new CusOprateLogEvent(logModel));
        }


}
