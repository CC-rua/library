package cn.edu.hqu.library.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBookVo {
    String bookId;
    String bookName;
    String jiaofu;
    String type;
    String publisher;
    String author;
    String quality;
    int count;

}
