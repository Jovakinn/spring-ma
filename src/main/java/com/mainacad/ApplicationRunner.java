package com.mainacad;

import com.mainacad.dao.ItemDAO;
import com.mainacad.dao.UserDAO;
import com.mainacad.entity.Item;
import com.mainacad.entity.Profile;
import com.mainacad.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class ApplicationRunner {

    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext("com.mainacad")){

            User admin = new User();
            admin.setEmail("ignatenko2207@gmail.com");
            admin.setFirstName("Alex");
            admin.setLastName("Ignatenko");
            admin.setLogin("ignatenko2207");
            admin.setPassword("12345");
            admin.setProfile(Profile.ADMIN);

            User client = new User();
            client.setEmail("ignatenko2207@gmail.com");
            client.setFirstName("Alex");
            client.setLastName("Ignatenko");
            client.setLogin("ignatenko2207-client");
            client.setPassword("12345");
            client.setProfile(Profile.CLIENT);

            UserDAO userDAO = context.getBean(UserDAO.class);

            userDAO.saveOrUpdate(admin);
            userDAO.saveOrUpdate(client);

            // ITEM

            Item item = new Item();
            item.setArticle("123445");
            item.setInitPrice(1233);
            item.setName("Perf");
            item.setPrice(1000);

            ItemDAO itemDAO = context.getBean(ItemDAO.class);
            itemDAO.saveOrUpdate(item);

            LOG.info("DB has " + userDAO.findAll().size() + " rows in \"USER\" table");
            LOG.info("DB has " + itemDAO.findAll().size() + " rows in \"ITEM\" table");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
