package com.teng.Utils;

import com.teng.entity.Customer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/***
 * redis临时替代品
 */
public class CacheUtis {

        private static Map<String, Date> lockUsers = new HashMap<>();

        private static Map<String, Customer> loginUsers = new HashMap<>();

        private static Map<String, Integer> cache = new HashMap<String, Integer>();
        public static Integer getAuthorCode(String requestNo){
                if (contains(requestNo)){
                        return cache.get(requestNo);
                } else {
                        int code = AuthorCodeUtils.getAuthorCode();
                        SetCache(requestNo, code);
                        return code;
                }

        }

        public static boolean contains(String requestNo){
                return cache.containsKey(requestNo);
        }

        public synchronized static boolean  SetCache(String requestNo, Integer authorCode){
                cache.put(requestNo, authorCode);
                return true;
        }

        public static boolean isLock(String loginName){
                if (lockUsers.containsKey(loginName)){
                        Date t = lockUsers.get(loginName);
                        long m =DateTime.getAddMinuteByCurrent(t);
                        if (m < 30L){
                                return true;
                        }
                        removeLock(loginName);
                        return false;
                }
                return false;
        }


        public synchronized static boolean setLock(String loginName){
                if (lockUsers.containsKey(loginName)){
                        return true;
                }
                lockUsers.put(loginName, new Date());
                return false;
        }

        public synchronized static void removeLock(String loginName){
                if (lockUsers.containsKey(loginName)){
                        lockUsers.remove(loginName);
                }
        }

        public static Customer getCurrent(String loginName){
                return loginUsers.get(loginName);
        }

        public synchronized static void setLoginUsers(String loginName, Customer customer){
                loginUsers.put(loginName, customer);
        }
}
