package cn.edu.hqu.library.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryVO {

    Integer id;
    String bookName;
    String author;
    String jiaofu;
    String kind;
    LocalDateTime time;


}
