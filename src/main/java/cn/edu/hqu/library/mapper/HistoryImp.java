package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.controller.vo.HistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HistoryImp {

    void deleteHistory(Integer id);

    void addHistory(@Param("userId") String userId,@Param("bookId") String bookId);

    List<HistoryVO> findAllHistoryByUserId(String userId);
}
