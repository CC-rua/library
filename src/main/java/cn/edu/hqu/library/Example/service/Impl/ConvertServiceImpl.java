package cn.edu.hqu.library.Example.service.Impl;


import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.service.dto.users;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ConvertServiceImpl implements Converter<users, User> {
    @Override
    public User convert(users value) {
        User user=new User();
        user.setUsername(value.getName());
        user.setPassword(value.getPwd());
        user.setBirthday(value.getBirthday());
        return user;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
