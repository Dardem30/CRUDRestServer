package by.DAO;

import by.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Роман on 30.08.2017.
 */
@Repository
public class RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public Role getRoleById(int id){
        Role role= (Role) sessionFactory.getCurrentSession().get(Role.class,id);
        return role;
    }
    public void updateRole(Role role){
       this.sessionFactory.getCurrentSession().update(role);
    }
}
