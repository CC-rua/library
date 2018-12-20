package cn.edu.hqu.library.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionInfo {

    String bookName;
    String author;
    String jiaofu;
    String kind;
    String publisher;
    int freeNum; // 可借出数量

}
