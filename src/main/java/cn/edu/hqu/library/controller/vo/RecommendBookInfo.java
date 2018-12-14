package cn.edu.hqu.library.controller.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendBookInfo {
    String name;
    String author;
    String publisher;
    String reason;

}
