package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="notice")
public class Notice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "NoticeID")
  private Integer noticeId;
  private java.sql.Timestamp btime;
  private java.sql.Timestamp etime;
  private String msg;

}
