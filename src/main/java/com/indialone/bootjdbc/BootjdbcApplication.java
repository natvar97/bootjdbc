package com.indialone.bootjdbc;

import com.indialone.bootjdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class BootjdbcApplication implements CommandLineRunner {

    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(BootjdbcApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        userDao.createNewTable();

      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter user Id:");
        int id = Integer.parseInt(br.readLine());

        System.out.println("Enter username:");
        String name = br.readLine();

        System.out.println("Enter user age:");
        String age = br.readLine();

        System.out.println("Enter city that user lives:");
        String city = br.readLine();


        System.out.println("inserted user -> " + userDao.insertUser(id, name, age, city));*/

//        System.out.println(userDao.updateUser(111, "GoduBachu","21", "Ahmedabad-Deesa"));
        System.out.println("inserted user -> " + userDao.insertUser(113, "hey there", "26", "Ahmedabad"));
        System.out.println(userDao.deleteUser(112));


    }
}
