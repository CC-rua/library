package cn.edu.hqu.library.Example.service.Impl;


import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.repository.UserRepository;
import cn.edu.hqu.library.Example.service.UserService;
import cn.edu.hqu.library.Example.service.dto.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean userExist(users user) {


        return false;
    }


    @Override
    public User findUserByUserNameAndPwd(String name, String password) {
        return userRepository.findByUsernameEqualsAndPasswordEquals(name,password);
    }

    @Override
    public User findUserByUserName(String name) {
        return userRepository.findAllByUsernameEquals(name);
    }


    public void addUser(User user)
    {
        userRepository.saveAndFlush(user);
    }

}
