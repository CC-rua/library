package cn.edu.hqu.library.service;


import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;

import java.util.List;

public interface BookService {

    List<Borrow> borrowInfo(String name);
    //借阅记录 给出用户名 返回 "Code","name","Btime","Etime","JiaoFu","status"
    List<BookInfo> FindBorrowInfoByName(String name);
    //归还记录 给出用户名 返回 "Code","name","Btime","Etime","JiaoFu"
    List<BookInfo> FindReturnBorrowByName(String name);
    List<BookInfo> FindBookInfoByName(String name);
    List<Rank>FindRankList(String kind);
    List<NewBookInfo> findNewBookInfo();
    List<RecommendBookInfo> findRecommendBook();
}
