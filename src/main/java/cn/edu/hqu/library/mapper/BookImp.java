package cn.edu.hqu.library.mapper;

import cn.edu.hqu.library.service.dto.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface BookImp {
    public List<BookInfo> FindBorrowInfoByName(String name);
    public List<BookInfo> FindBookInfoByName(String name);
}
