package cn.edu.hqu.library.service;


import cn.edu.hqu.library.entity.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> borrowInfo(String name);
}
