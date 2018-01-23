package com.teng.model.builder;

import com.teng.model.dao.repository.domain.SysUser;

/**
 * Created by admin on 2018/1/3.
 */
public class SysUserBuilder {

        private SysUser sysUser;

        private SysUserBuilder(){}

        public static SysUserBuilder getBuilder(){
                SysUserBuilder sysUserBuilder = new SysUserBuilder();
                sysUserBuilder.sysUser = new SysUser();
                return sysUserBuilder;
        }

        public SysUserBuilder userId(String userId){
                sysUser.setUserId(userId);
                return this;
        }
        public SysUserBuilder password(String password){
                sysUser.setPassword(password);
                return this;
        }
        public SysUserBuilder userName(String userName){
                sysUser.setUserName(userName);
                return this;
        }
        public SysUserBuilder roleCode(String roleCode){
                sysUser.setRoleCode(roleCode);
                return this;
        }
        public SysUserBuilder orgId(String orgId){
                sysUser.setOrgId(orgId);
                return this;
        }

        public SysUserBuilder email(String email) {
                sysUser.setEmail(email);
                return this;
        }
        public SysUserBuilder loginCount(String loginCount){
                sysUser.setLoginCount(loginCount);
                return this;
        }

        public SysUserBuilder lastLoginTime(String lastLoginTime) {
                sysUser.setLastLoginTime(lastLoginTime);
                return this;
        }

        public SysUserBuilder lastLoginIp(String lastLoginIp) {
                sysUser.setLastLoginIp(lastLoginIp);
                return this;
        }

        public SysUserBuilder disableFlag(String disableFlag) {
                sysUser.setDisableFlag(disableFlag);
                return this;
        }

        public SysUserBuilder descInfo(String descInfo) {
                sysUser.setDescInfo(descInfo);
                return this;
        }

        public SysUserBuilder phone(String phone) {
                sysUser.setPhone(phone);
                return this;
        }

        public SysUserBuilder createBy(String createBy) {
                sysUser.setCreateBy(createBy);
                return this;
        }

        public SysUserBuilder createTime(String createTime) {
                sysUser.setCreateTime(createTime);
                return this;
        }
        public SysUserBuilder updateBy(String updateBy){
                sysUser.setUpdateBy(updateBy);
                return this;
        }

        public SysUserBuilder updateTime(String updateTime) {
                sysUser.setUpdateTime(updateTime);
                sysUser.setUpdateTime(updateTime);
                return this;
        }

        public SysUser getSysUser(){
                return sysUser;
        }

}
