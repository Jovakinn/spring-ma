package com.mainacad.dao;

import com.mainacad.dao.connection.ConnectionFactory;
import com.mainacad.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Setter
@Getter
public class ItemDAO {

    @Autowired
    private ConnectionFactory connectionFactory;

    public void saveOrUpdate(Item item){
        Session session = connectionFactory.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.saveOrUpdate(item);

        session.getTransaction().commit();
        session.close();
    }


    public Item update(Item item){
        Session session = connectionFactory.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.update(item);

        session.getTransaction().commit();
        session.close();

        return item;
    }

    public Item findOneById(Integer id){
        Session session = connectionFactory.getSessionFactory().openSession();

        session.getTransaction().begin();
        Item item = session.find(Item.class, id);

        session.getTransaction().commit();
        session.close();

        return item;
    }

    public List<Item> findAll(){
        Session session = connectionFactory.getSessionFactory().openSession();

        session.getTransaction().begin();
        String sql = "SELECT * FROM items";
        List<Item> items = session.createNativeQuery(sql, Item.class).getResultList();

        session.getTransaction().commit();
        session.close();

        return items;
    }

    public List<Item> findByItemCode(String itemCode){
        Session session = connectionFactory.getSessionFactory().openSession();

        session.getTransaction().begin();
        String sql = "SELECT * FROM items WHERE item_code=?";

        NativeQuery query = session.createNativeQuery(sql, Item.class);
        query.setParameter(1,itemCode);

        List<Item> items = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return items;
    }

    public void delete(Item item){
        Session session = connectionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(item);

        session.getTransaction().commit();
        session.close();
    }
}