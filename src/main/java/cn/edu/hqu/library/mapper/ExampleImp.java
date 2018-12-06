package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.entity.Example;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ExampleImp {
    public List<Example> find();


}
