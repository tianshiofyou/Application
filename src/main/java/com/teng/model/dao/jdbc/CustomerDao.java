package com.teng.model.dao.jdbc;

import com.teng.model.builder.CustomerBuilder;
import com.teng.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 2018/1/11.
 */
@Repository("CustomerDao")
public class CustomerDao implements BaseDao<Customer> {

        @Autowired
        private JdbcTemplate jdbc;

        public Customer getOne(String customerName) throws Exception{
                try {
                        return jdbc.queryForObject(
                                "Select t.CUS_ID         As CusId,\n" +
                                        "       t.LOGIN_NAME     As LoginName,\n" +
                                        "       t.MOBILE         As Mobile,\n" +
                                        "       t.EMAIL          As Email,\n" +
                                        "       t.REG_TIME       As RegTime,\n" +
                                        "       t.LOGIN_PWD      As LoginPwd,\n" +
                                        "       t.STATUS         As Status,\n" +
                                        "       t.LAST_LOGINTIME As LastLoginTime\n" +
                                        "From CUSTOMERS t\n" +
                                        "where t.login_name = ?", new Object[]{ customerName },
                                new BeanPropertyRowMapper<>(Customer.class));
                } catch (EmptyResultDataAccessException e) {
                        return null;
                }
        }

        @Override
        public List<Customer> getAll() throws Exception{
                List<Customer> customers = jdbc.query("SELECT * FROM CUSTOMERS", (rs,i)->CustomerBuilder.parseResultSet(rs));
                return customers;
        }

        @Override
        public void update(Customer customer) throws Exception{
                jdbc.update("UPDATE CUSTOMERS SET STATUS = ? WHERE LOGIN_NAME=?",(ps)->{
                        ps.setString(1, customer.getStatus());
                        ps.setString(2, customer.getLoginName());
                });
        }

        @Override
        public void delete(String customerId) throws Exception{
                jdbc.update("DELETE FROM CUSTOMERS WHERE LOGIN_NAME=?",
                        ps -> {
                                ps.setString(1,customerId);
                        }
                );
        }

        @Override
        public void addOne(Customer customer) throws Exception{
                jdbc.update("INSERT INTO CUSTOMERS (CUS_ID,LOGIN_NAME,MOBILE,EMAIL,REG_TIME,LOGIN_PWD,STATUS,LAST_LOGINTIME) VALUES (?,?,?,?,?,?,?,?)",
                        (ps)->{
                                ps.setString(1, customer.getCustomerId());
                                ps.setString(2, customer.getLoginName());
                                ps.setString(3, customer.getMobile());
                                ps.setString(4, customer.getEmail());
                                ps.setString(5, customer.getRegTime());
                                ps.setString(6, customer.getLoginPwd());
                                ps.setString(7, customer.getStatus());
                                ps.setString(8, customer.getLastLoginTime());
                        }
                );
        }

        @Override
        public void addList(List<Customer> customers) throws Exception {
                jdbc.batchUpdate("INSERT INTO CUSTOMERS (CUS_ID,LOGIN_NAME,MOBILE,EMAIL,REG_TIME,LOGIN_PWD,STATUS,LAST_LOGINTIME) VALUES (?,?,?,?,?,?,?,?)",
                        new BatchPreparedStatementSetter() {
                                @Override
                                public void setValues(PreparedStatement ps, int i) throws SQLException {
                                        Customer customer = customers.get(i);
                                        System.out.println(customer);
                                        ps.setString(1, customer.getCustomerId());
                                        ps.setString(2, customer.getLoginName());
                                        ps.setString(3, customer.getMobile());
                                        ps.setString(4, customer.getEmail());
                                        ps.setString(5, customer.getRegTime());
                                        ps.setString(6, customer.getLoginPwd());
                                        ps.setString(7, customer.getStatus());
                                        ps.setString(8, customer.getLastLoginTime());
                                }

                                @Override
                                public int getBatchSize() {
                                        return customers.size();
                                }
                        }
                );
        }

        //public abstract boolean existCustomerName(String name);

        //public abstract boolean isPassMatchName(String name, String pass);

        /*protected class CustomerMapper implements RowMapper<Customer> {
                @Override
                public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                        return CustomerBuilder.parseResultSet(resultSet);
                }
        }*/
}
