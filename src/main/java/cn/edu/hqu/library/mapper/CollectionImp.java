package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.controller.vo.CollectionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CollectionImp {
    List<CollectionInfo> findCollectionByUserId(String userId);
    void deleteCollection(@Param("userId") String userId,@Param("bookId") String bookId);
}
