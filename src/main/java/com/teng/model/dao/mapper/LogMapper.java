package com.teng.model.dao.mapper;

import com.teng.model.CusLog;

import java.util.List;

/**
 * Created by admin on 2017/12/31.
 */
public interface LogMapper {

        /**
         * 写入用户请求日志
         * @param log
         */
        void wirteReqestLog(CusLog log);

        /**
         * 查询用户请求日志
         * @param log
         */
        List<CusLog> queryReqestLog(CusLog log);

}
