package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserImp {
    List<User> findUserByConditions(String UserId, String name, String department, String grade, String major, Integer sex);
}
