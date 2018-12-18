package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserImp {
    List<User> findUserByConditions(@Param("UserId") String UserId,@Param("name") String name, @Param("department") String department, @Param("grade") String grade, @Param("major") String major, @Param("sex") Integer sex);
}
