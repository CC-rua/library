package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.entity.Advice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AdviceImp {
    List<Advice> findAdviceByConditions(@Param("adviceId") Integer adviceId,@Param("name") String name, @Param("message") String message,@Param("state") String state);

}
