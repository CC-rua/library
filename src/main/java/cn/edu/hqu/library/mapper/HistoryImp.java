package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.controller.vo.HistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HistoryImp {
    List<HistoryVO> findAllHistoryByUserId(String userId);

    void deleteHistory(String id);

    void addHistory(@Param("userId") String userId,@Param("bookId") String bookId);
}
