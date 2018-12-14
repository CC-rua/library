package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {

  @Id
  private String noticeId;
  private java.sql.Timestamp btime;
  private java.sql.Timestamp etime;
  private String msg;

}
