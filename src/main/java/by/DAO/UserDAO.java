package by.DAO;

import by.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 30.08.2017.
 */
@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void saveUser(User user){
        this.sessionFactory.getCurrentSession().persist(user);
    }
    public User getUserByUsername(String username){
        User user= (User) sessionFactory.getCurrentSession()
                .createQuery("from User where username=:name")
                .setString("name",username).uniqueResult();
        return user;
    }
    public User getUserById(int id){
        User user= (User) sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }
    public List<User> getListUser(){
        List<User> userList=sessionFactory.getCurrentSession()
                .createQuery("from User ").list();
        return userList;
    }
    public void updateUser(User user){
        sessionFactory.getCurrentSession().update(user);
    }
    public void deleteUser(User user){
        sessionFactory.getCurrentSession().delete(user);
    }

    }
