package cn.edu.hqu.library.service;


import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.service.dto.BookInfo;

import java.util.List;

public interface BookService {
    List<Borrow> borrowInfo(String name);
    List<BookInfo> FindBorrowInfoByName(String name);
    List<BookInfo> FindBookInfoByName(String name);
}
