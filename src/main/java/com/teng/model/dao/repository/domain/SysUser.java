package com.teng.model.dao.repository.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by admin on 2018/1/3.
 */
@Entity
public class SysUser {

        @Id
        @GeneratedValue(generator="system_uuid",strategy= GenerationType.SEQUENCE)
        @GenericGenerator(name="system_uuid",strategy="uuid")
        private String userId;
        @Column
        private String password;
        @Column
        private String userName;
        @Column
        private String roleCode;
        @Column
        private String orgId;
        @Column
        private String email;
        @Column
        private String loginCount;
        @Column
        private String lastLoginTime;
        @Column
        private String lastLoginIp;
        @Column
        private String disableFlag;
        @Column
        private String descInfo;
        @Column
        private String phone;
        @Column
        private String createBy;
        @Column
        private String createTime;
        @Column
        private String updateBy;
        @Column
        private String updateTime;

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getRoleCode() {
                return roleCode;
        }

        public void setRoleCode(String roleCode) {
                this.roleCode = roleCode;
        }

        public String getOrgId() {
                return orgId;
        }

        public void setOrgId(String orgId) {
                this.orgId = orgId;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getLoginCount() {
                return loginCount;
        }

        public void setLoginCount(String loginCount) {
                this.loginCount = loginCount;
        }

        public String getLastLoginTime() {
                return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
        }

        public String getLastLoginIp() {
                return lastLoginIp;
        }

        public void setLastLoginIp(String lastLoginIp) {
                this.lastLoginIp = lastLoginIp;
        }

        public String getDisableFlag() {
                return disableFlag;
        }

        public void setDisableFlag(String disableFlag) {
                this.disableFlag = disableFlag;
        }

        public String getDescInfo() {
                return descInfo;
        }

        public void setDescInfo(String descInfo) {
                this.descInfo = descInfo;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getCreateBy() {
                return createBy;
        }

        public void setCreateBy(String createBy) {
                this.createBy = createBy;
        }

        public String getCreateTime() {
                return createTime;
        }

        public void setCreateTime(String createTime) {
                this.createTime = createTime;
        }

        public String getUpdateBy() {
                return updateBy;
        }

        public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
        }

        public String getUpdateTime() {
                return updateTime;
        }

        public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("SysUser:{");
                sb.append("\"userId\":\"")
                        .append(userId).append('\"');
                sb.append(",\"password\":\"")
                        .append(password).append('\"');
                sb.append(",\"userName\":\"")
                        .append(userName).append('\"');
                sb.append(",\"roleCode\":\"")
                        .append(roleCode).append('\"');
                sb.append(",\"orgId\":\"")
                        .append(orgId).append('\"');
                sb.append(",\"email\":\"")
                        .append(email).append('\"');
                sb.append(",\"loginCount\":\"")
                        .append(loginCount).append('\"');
                sb.append(",\"lastLoginTime\":\"")
                        .append(lastLoginTime).append('\"');
                sb.append(",\"lastLoginIp\":\"")
                        .append(lastLoginIp).append('\"');
                sb.append(",\"disableFlag\":\"")
                        .append(disableFlag).append('\"');
                sb.append(",\"descInfo\":\"")
                        .append(descInfo).append('\"');
                sb.append(",\"phone\":\"")
                        .append(phone).append('\"');
                sb.append(",\"createBy\":\"")
                        .append(createBy).append('\"');
                sb.append(",\"createTime\":\"")
                        .append(createTime).append('\"');
                sb.append(",\"updateBy\":\"")
                        .append(updateBy).append('\"');
                sb.append(",\"updateTime\":\"")
                        .append(updateTime).append('\"');
                sb.append('}');
                return sb.toString();
        }
}
