package cn.edu.hqu.library.Example.service;


import cn.edu.hqu.library.Example.entity.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> borrowInfo(String name);
}
