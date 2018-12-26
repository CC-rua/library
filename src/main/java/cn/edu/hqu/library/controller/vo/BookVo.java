package cn.edu.hqu.library.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVo {
    String bookId;
    String bookName;
    String jiaofu;
    String kind;
    String publisher;
    String author;
    String quality;
    String status;
    String code;
}
