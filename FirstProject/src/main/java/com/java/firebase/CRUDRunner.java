package com.java.firebase;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.sun.deploy.si.SingleInstanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SingleInstanceImpl.SingleInstanceServer SpringApplication;
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a new User
        User user = new User();
        user.setId("1");
        user.setName("John Doe");

        Map<String, Integer> subjectMarks = new HashMap();
        subjectMarks.put("Math", 95);
        subjectMarks.put("Science", 90);
        user.setSubjectMarks(subjectMarks);

        String createTime = userService.createUser(user);
        System.out.println("User created at: " + createTime);

        // Read the created User
        User fetchedUser = userService.getUser("1");
        System.out.println("Fetched User: " + fetchedUser.getName() + ", Subject Marks: " + fetchedUser.getSubjectMarks());

        // Update the User
        fetchedUser.setName("John Doe Updated");
        subjectMarks.put("Science", 98);
        fetchedUser.setSubjectMarks(subjectMarks);

        String updateTime = userService.updateUser(fetchedUser);
        System.out.println("User updated at: " + updateTime);

        // Read the updated User
        User updatedUser = userService.getUser("1");
        System.out.println("Updated User: " + updatedUser.getName() + ", Subject Marks: " + updatedUser.getSubjectMarks());

        // Delete the User
        String deleteTime = userService.deleteUser("1");
        System.out.println("User deleted at: " + deleteTime);
    }
}
