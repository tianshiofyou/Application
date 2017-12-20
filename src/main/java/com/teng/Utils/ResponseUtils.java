package com.teng.Utils;

import com.teng.enums.ResponseCode;
import com.teng.msg.ResponseMsg;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ResponseUtils {

        public static ResponseMsg success(){
                return success(ResponseCode.INVOKE_SUCCESS);
        }

        public static ResponseMsg success(ResponseCode responseCode){
                ResponseMsg rspMsg = new ResponseMsg();
                rspMsg.setCode(responseCode.getRetcode());
                rspMsg.setMsg(responseCode.getRetmsg());
                return rspMsg;
        }

        public static ResponseMsg success(Object data){
                ResponseMsg rspMsg = success();
                rspMsg.setData(data);
                return rspMsg;
        }

        public static ResponseMsg error(Exception e){
                ResponseMsg rspMsg = new ResponseMsg();
                rspMsg.setCode(ResponseCode.SYS_EXCEPTION.getRetcode());
                rspMsg.setMsg(ResponseCode.SYS_EXCEPTION.getRetmsg());
                rspMsg.setData(e);
                return rspMsg;
        }

        public static ResponseMsg error(ResponseCode responseCode){
                ResponseMsg rspMsg = new ResponseMsg();
                rspMsg.setCode(responseCode.getRetcode());
                rspMsg.setMsg(responseCode.getRetmsg());
                return rspMsg;
        }

        public static ResponseMsg parmsError(BindingResult result){
                ResponseMsg rspMsg = error(ResponseCode.INVALID_PARAM);
                Map<String, String> map = new HashMap<>();
                result.getAllErrors().forEach(
                        (n)->{
                                map.put(n.getObjectName(), n.getDefaultMessage());
                        }
                );
                rspMsg.setData(map);
                return rspMsg;
        }
}
