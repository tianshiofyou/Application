package com.teng.web;

import com.alibaba.fastjson.JSON;
import com.teng.Utils.CacheUtis;
import com.teng.Utils.DateTime;
import com.teng.Utils.RequestUtils;
import com.teng.Utils.ResponseUtils;
import com.teng.model.entity.Customer;
import com.teng.constants.enums.ResponseCode;
import com.teng.model.ResponseMsg;
import com.teng.biz.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@CrossOrigin
public class CustomerController extends BaseController {

        private Logger logger = LoggerFactory.getLogger(CustomerController.class);
        @Resource(name = "CustomerService")
        private CustomerService service;

        @RequestMapping("/")
        public String index(){
                return "welcome to teng's home ";
        }

        @RequestMapping("/login")
        public ResponseMsg Login(@RequestBody Customer customer){
                ResponseMsg msg = null;
                try {
                        customer = service.customerValidate(customer);
                        if (customer != null){
                                customer.setLastLoginTime(DateTime.getWelcomeLastLoginTime(customer.getLastLoginTime()));
                                msg = ResponseUtils.success(customer);
                                CacheUtis.setLoginUsers(customer.getLoginName(), customer);
                                RequestUtils.setCurrentUser(customer);
                        }
                        else {
                                msg = ResponseUtils.error(ResponseCode.ERROR_PWD);
                        }
                        saveLog("CustomerController", "Login");
                } catch (Exception e){
                        msg = ResponseUtils.error(e);
                        logger.error("登录异常",e);

                }
                return msg;
        }

        @RequestMapping("/registed")
        public ResponseMsg registed(@RequestBody @Valid Customer customer, BindingResult result){
                ResponseMsg msg = null;
                if (result.hasErrors()){
                        logger.info(JSON.toJSONString(result.getAllErrors()));
                        msg = ResponseUtils.parmsError(result);
                } else {
                        try{
                                boolean success = service.registerCustomer(customer);
                                if (success){
                                        msg = ResponseUtils.success();
                                 } else {
                                        msg = ResponseUtils.success(ResponseCode.INVALID_PARAM);
                                }
                        } catch (Exception e){
                                logger.error("注册异常", e);
                                msg = ResponseUtils.error(e);
                        }
                }
                return msg;
        }

        @RequestMapping("/getCode")
        public ResponseMsg getAuthorCode(@RequestBody String reqeustNo){
                int code = service.getAutorCode(reqeustNo);
                logger.info(String.format("本次获取的验证码是%d", code));
                ResponseMsg msg = ResponseUtils.success(String.valueOf(code));
                return msg;
        }

        @RequestMapping("/lockCus")
        public ResponseMsg lockCustomer(@RequestBody String loginName){
                ResponseMsg msg = null;
                try {
                        service.lockCustomer(loginName);
                        msg = ResponseUtils.success();
                        logger.info(String.format("用户%s被锁定!", loginName));
                } catch (Exception e) {
                        msg = ResponseUtils.error(e);
                        logger.error("锁定用户异常",e);
                }
                return msg;
        }

        @RequestMapping("/forget")
        public ResponseMsg forgetPass(String loginName){
                ResponseMsg msg = new ResponseMsg();
                return msg;
        }

}
