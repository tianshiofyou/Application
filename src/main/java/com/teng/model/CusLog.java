package com.teng.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.teng.Utils.Strings;

import java.util.Date;

/**
 * Created by admin on 2017/12/26.
 * 用户操作日志记录模型
 */
public class CusLog {

        public static CusLog Empty = new CusLog();

        public CusLog(){}

        /**
         * 用户 调用接口
         */
        private String interfaceName = Strings.Empty;
        /**
         * 用户名
         */
        private String loginName = Strings.Empty;
        /**
         * 用户IP地址
         */
        private String ipAddress = Strings.Empty;
        /**
         * 调用时间
         */
        private Date invokeTimes;
        /**
         * 调用耗时
         */
        private Long expendTimes;
        /**
         * 调用结果
         */
        private String invokeResult = Strings.Empty;
        /**
         * 请求数据
         */
        private String requestData = Strings.Empty;
        /**
         * 返回数据
         */
        private String responseData = Strings.Empty;
        /**
         * 备注
         */
        private String remark = Strings.Empty;

        public String getInterfaceName() {
                return interfaceName;
        }

        public void setInterfaceName(String interfaceName) {
                this.interfaceName = interfaceName;
        }

        public String getLoginName() {
                return loginName;
        }

        public void setLoginName(String loginName) {
                this.loginName = loginName;
        }

        public String getIpAddress() {
                return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
                this.ipAddress = ipAddress;
        }

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        public Date getInvokeTimes() {
                return invokeTimes;
        }

        public void setInvokeTimes(Date invokeTimes) {
                this.invokeTimes = invokeTimes;
        }

        public Long getExpendTimes() {
                return expendTimes;
        }

        public void setExpendTimes(Long expendTimes) {
                this.expendTimes = expendTimes;
        }

        public String getInvokeResult() {
                return invokeResult;
        }

        public void setInvokeResult(String invokeResult) {
                this.invokeResult = invokeResult;
        }

        public String getRequestData() {
                return requestData;
        }

        public void setRequestData(String requestData) {
                this.requestData = requestData;
        }

        public String getResponseData() {
                return responseData;
        }

        public void setResponseData(String responseData) {
                this.responseData = responseData;
        }

        public String getRemark() {
                return remark;
        }

        public void setRemark(String remark) {
                this.remark = remark;
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("CusLog:{");
                sb.append("\"interfaceName\":\"")
                        .append(interfaceName).append('\"');
                sb.append(",\"loginName\":\"")
                        .append(loginName).append('\"');
                sb.append(",\"ipAddress\":\"")
                        .append(ipAddress).append('\"');
                sb.append(",\"invokeTimes\":\"")
                        .append(invokeTimes).append('\"');
                sb.append(",\"expendTimes\":\"")
                        .append(expendTimes).append('\"');
                sb.append(",\"invokeResult\":\"")
                        .append(invokeResult).append('\"');
                sb.append(",\"requestData\":\"")
                        .append(requestData).append('\"');
                sb.append(",\"responseData\":\"")
                        .append(responseData).append('\"');
                sb.append(",\"remark\":\"")
                        .append(remark).append('\"');
                sb.append('}');
                return sb.toString();
        }


        public CusLog Clone(){
                CusLog cusLog = new CusLog();
                return cusLog;
        }
}
