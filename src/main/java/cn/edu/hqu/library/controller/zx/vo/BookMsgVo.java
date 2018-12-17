package cn.edu.hqu.library.controller.zx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMsgVo {
    String bookId;
    String bookName;
    String kind;
    String author;
    String publisher;
    String introduction;
    int freeNum;
}
