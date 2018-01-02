package com.teng.builder;

import com.teng.model.CusLog;

import java.util.Date;

/**
 * Created by admin on 2018/1/1.
 */
public class CusLogBuilder {
        private CusLog log = null;
        public static CusLogBuilder parse(CusLog cusLog){
                return new CusLogBuilder(cusLog);
        }

        private CusLogBuilder(CusLog cusLog){
                this.log = cusLog;
        }

        public CusLogBuilder interfaceName(String interfaceName){
                log.setInterfaceName(interfaceName);
                return this;
        }
        public CusLogBuilder loginName(String loginName){
                log.setLoginName(loginName);
                return this;
        }
        public CusLogBuilder ipAddress(String ipAddress){
                log.setIpAddress(ipAddress);
                return this;
        }
        public CusLogBuilder invokeTimes(Date invokeTimes){
                log.setInvokeTimes(invokeTimes);
                return this;
        }
        public CusLogBuilder expendTimes(long expendTimes){
                log.setExpendTimes(expendTimes);
                return this;
        }
        public CusLogBuilder invokeResult(String invokeResult){
                log.setInvokeResult(invokeResult);
                return this;
        }
        public CusLogBuilder requestData(String requestData){
                log.setRequestData(requestData);
                return this;
        }
        public CusLogBuilder responseData(String responseData){
                log.setResponseData(responseData);
                return this;
        }
        public CusLogBuilder remark(String remark){
                log.setRemark(remark);
                return this;
        }

        public CusLog getLog(){
                return log;
        }
}
