package com.mainacad.dao;

import com.mainacad.config.SpringConfig;
import com.mainacad.entity.Profile;
import com.mainacad.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(SpringConfig.class)
@ActiveProfiles("test")
class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    void testGetAllUsers() {
        User admin = new User();
        admin.setEmail("ignatenko2207@gmail.com");
        admin.setFirstName("Alex");
        admin.setLastName("Ignatenko");
        admin.setLogin("ignatenko2207");
        admin.setPassword("12345");
        admin.setProfile(Profile.ADMIN);

        List<User> users = userDAO.findAll();
        assertTrue(!users.isEmpty());
    }
}