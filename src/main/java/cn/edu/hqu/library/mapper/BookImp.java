package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.zx.vo.BookVo;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
@Mapper
@Component
public interface BookImp {
    List<BookInfo> FindBorrowInfoByName(String name);
    List<BookInfo> FindBookInfoByName(String name);
    List<Rank> FindRankList(String kind);
    List<BookInfo> FindReturnBorrowByName(String name);
    List<NewBookInfo> FindBookByTimeDesc();

    List<RecommendBookInfo> findRecommendBook();


    List<BookVo> findBookInfo(String code, String name, String kind, String jiaofu, String type, String status, String quality, String author);
}
