package com.teng.model.dao.repository;

import com.teng.model.dao.repository.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by admin on 2018/1/3.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

        @Query("select u from SysUser u where userName = ?1")
        SysUser findByUserName(String userName);

}
