package cn.edu.hqu.library.service;


import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.controller.vo.BookVo;
import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;

import java.sql.Timestamp;
import java.util.List;

public interface BookService {

    List<Borrow> borrowInfo(String name);
    //借阅记录 给出用户名 返回 "Code","name","Btime","Etime","JiaoFu","status"
    List<BookInfo> FindBorrowInfoByName(String name);
    //归还记录 给出用户名 返回 "Code","name","Btime","Etime","JiaoFu"
    List<BookInfo> FindReturnBorrowByName(String name);
    List<BookInfo> FindBookInfoByName(String name);
    List<Rank>FindRankList(String kind);
    List<Rank>FindRankListByJiaoFu(String JiaoFu);
    List<NewBookInfo> findNewBookInfo();
    List<RecommendBookInfo> findRecommendBook();

    BookMsgVo findBookMsgByBookId(String bookId);

    //新增
    void addBook(Book book);

    void addBookList(List<Book> list);

    void updateBook(Book book);

    void borrowBook(String bookId, String code, String userId);//需要定位到某一本书 然后将其出借给某个人

    Book findBookByCode(String code);

    BookVo findBookVoByBookCodeAndBookId(String bookId, String code);

    void deleteBook(String bookId, String code);

    //还书  需要精确到书 需要归还时的状态
    void giveBack( String userId,String code, String status);


    List<BookVo> findBookInfo(String bookId, String code, String state, String quality, Timestamp startTime, Timestamp endTime);

    List<BookVo> findBookInfo(String code, String name, String kind, String jiaofu, String type, String status, String quality, String author);

    List<BookMsgVo> findBookMsgInfo(String bookId,String bookName,String jiaofu,String type,String publisher,String author);

    BookInfo FindBookInfoByCode(String code);

    List<BookMsgVo> findAllBookMsgInfo();

    String findBookCodeByBookId(String bookId);
}
