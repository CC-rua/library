package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {

  private String noticeId;
  private java.sql.Timestamp btime;
  private java.sql.Timestamp etime;
  private String msg;

}
