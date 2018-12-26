package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class History {
    String userId;
    String bookId;
    Timestamp time;
}
