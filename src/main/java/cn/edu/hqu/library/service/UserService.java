package cn.edu.hqu.library.service;

import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.dto.users;

import java.util.List;


public interface UserService {
     boolean userExist(users user);
     User Authentication(String name, String password);
     User findUserByUserName(String name);
     void addUser(User user);
     boolean UserRegister(users user1);
     List<User> findAll();
     void DeleteByuserName(String userName);
}
