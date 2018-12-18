package cn.edu.hqu.library.service.Impl;


import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.mapper.UserImp;
import cn.edu.hqu.library.repository.UserRepository;
import cn.edu.hqu.library.service.UserService;
import cn.edu.hqu.library.service.dto.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserImp userImp;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserImp userImp) {
        this.userRepository = userRepository;
        this.userImp = userImp;
    }

    @Override
    public boolean userExist(users user) {
        //查找数据库中是否有同名
        return userRepository.findAllByUserIdEquals(user.getName()) != null;
    }
    @Override
    public User Authentication(String name, String password) {
        //身份认证,账号和密码对应
        return userRepository.findByUserIdEqualsAndPasswordEquals(name,password);
    }

    @Override
    public User findUserByUserId(String userId) {
        //通过name参数返回User对象
        return userRepository.findAllByUserIdEquals(userId);
    }

    @Override
    public void addUser(User user)   {
        //把User对象放入数据库
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean UserRegister(users user1) {
        //注册
        if (userRepository.findAllByUserIdEquals(user1.getName()) == null) {
            User user = new User();
            user.setUserId(user1.getName());
            user.setPassword(user1.getPwd());
            user.setType("1");
            user.setBirthday(user1.getBirthday());
            userRepository.saveAndFlush(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void DeleteByUserId(String UserId) {
        User users=new User();
        users.setUserId(UserId);
        userRepository.delete(users);
    }

    @Override
    public List<User> findUserByConditions(String UserId, String name, String department, String grade, String major,Integer sex) {
        return (List<User>) userImp.findUserByConditions(UserId,name,department,grade,major,sex);
    }
}
