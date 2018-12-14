package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="notice")
public class Notice {
  @Id
  @Column(name = "NoticeID")
  private String noticeId;
  private java.sql.Timestamp btime;
  private java.sql.Timestamp etime;
  private String msg;

}
