package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.controller.vo.BookVo;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface BookImp {
    List<BookInfo> FindBorrowInfoByName(String name);
    List<BookInfo> FindBookInfoByName(String name);
    List<Rank> FindRankList(String kind);
    List<Rank> FindRankListByJiaoFu(String JiaoFu);
    List<BookInfo> FindReturnBorrowByName(String name);
    List<NewBookInfo> FindBookByTimeDesc();

    List<RecommendBookInfo> findRecommendBook();


    List<BookVo> findBookInfo(@Param("code") String code,@Param("bookName") String bookName,@Param("kind") String kind,@Param("jiaofu") String jiaofu,@Param("type") String type,@Param("status") String status,@Param("quality") String quality,@Param("author") String author);

    List<BookMsgVo> findBookMsgInfo(@Param("bookId") String bookId,@Param("bookName") String bookName,@Param("jiaofu") String jiaofu,@Param("type") String type,@Param("publisher") String publisher,@Param("author") String author);

    BookInfo findBookInfoByCode(@Param("code") String code);

    String findBookCodeByBookId(String bookId);
}
