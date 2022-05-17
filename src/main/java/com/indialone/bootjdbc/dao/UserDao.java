package com.indialone.bootjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserDao() {

    }

    public void createNewTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS User(id int primary key, name varchar(200), age int , city varchar(100))";
        if (jdbcTemplate != null) {
            int update = jdbcTemplate.update(createTableQuery);
            System.out.println("Table created -> " + update);
        }
    }

    public int insertUser(int id, String name, String age, String city) {
        String insertQuery = "INSERT INTO user(id,name,age,city) VALUES(?,?,?,?)";
        return jdbcTemplate.update(insertQuery, id, name, age, city);
    }

    public int updateUser(int id, String name, String age, String city) {
        String updateQuery = "UPDATE user SET name=?, age=?, city=? WHERE id=?";
        return jdbcTemplate.update(updateQuery, name, age, city, id);
    }

    public int deleteUser(int id) {
        String deleteQuery = "DELETE FROM user WHERE id=?";
        return jdbcTemplate.update(deleteQuery, id);
    }

}
