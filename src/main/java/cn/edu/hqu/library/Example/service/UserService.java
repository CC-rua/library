package cn.edu.hqu.library.Example.service;

import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.service.dto.users;


public interface UserService {
     boolean userExist(users user);
     User findUserByUserNameAndPwd(String name, String password);
     User findUserByUserName(String name);
     void addUser(User user);
     }
