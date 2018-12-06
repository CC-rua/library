package cn.edu.hqu.library.Example.service.Impl;

import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.repository.UserRepository;
import cn.edu.hqu.library.Example.service.RegisterService;
import cn.edu.hqu.library.Example.service.dto.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;

    @Autowired
    public RegisterServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public boolean UserRegister(users user1) {
        if (userRepository.findAllByUsernameEquals(user1.getName()) == null) {
            User user = new User();
            user.setUsername(user1.getName());
            user.setPassword(user1.getPwd());
            user.setType("1");
            user.setBirthday(user1.getBirthday());
            userRepository.saveAndFlush(user);
            return true;
        } else {
            return false;
        }
    }
}
