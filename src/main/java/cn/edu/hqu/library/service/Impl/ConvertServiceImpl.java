package cn.edu.hqu.library.service.Impl;


import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.dto.users;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

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
