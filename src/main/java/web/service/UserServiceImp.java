package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   public void saveUser(User user) {
      userDao.saveUser(user);
   }

   @Override
   public User getUser(int id) {
      return userDao.getUser(id);
   }

   @Override
   public void deleteUser(int id) {
      userDao.deleteUser(id);
   }

   @Override
   public void updateUser(int id, User user) {
      userDao.updateUser(id, user);
   }
}