package by.service;

import by.DAO.RoleDAO;
import by.DAO.UserDAO;
import by.model.Role;
import by.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 30.08.2017.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    public void saveUser(User user){
        Set<Role> roleSet=new HashSet<>();
        roleSet.add(roleDAO.getRoleById(2));
        user.setRoleSet(roleSet);
        userDAO.saveUser(user);
    }
    public User getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }
    public User getUserById(int id){
        return userDAO.getUserById(id);
    }
    public List<User> getListUser(){
        return userDAO.getListUser();
    }
    public void updateUser(User user){
        userDAO.updateUser(user);
    }
    public void deleteUser(User user){
        userDAO.deleteUser(user);
    }
    }
