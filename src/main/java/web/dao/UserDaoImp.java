package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   @Override
   public List<User> getAllUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }

   @Transactional
   @Override
   public void saveUser(User user) { entityManager.merge(user); }

   @Transactional
   @Override
   public User getUser(int id) {
      return entityManager.find(User.class, id);
   }

   @Transactional
   @Override
   public void updateUser(int id, User user) {
      User updateUser = entityManager.find(User.class, id);
      updateUser.setFirstName(user.getFirstName());
      updateUser.setLastName(user.getLastName());
      updateUser.setEmail(user.getEmail());
      entityManager.merge(updateUser);
   }

   @Transactional
   @Override
   public void deleteUser(int id) {
      User deleteUser = entityManager.find(User.class, id);
      entityManager.remove(deleteUser);
   }
}