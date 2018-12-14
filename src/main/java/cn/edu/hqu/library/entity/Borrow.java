package cn.edu.hqu.library.entity;

import cn.edu.hqu.library.entity.UnionKey.BorrowKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="borrow")
@IdClass(BorrowKey.class)
public class Borrow implements Serializable {

  @Id
  @Column(name = "UserID")
  private String userId;
  @Id
  @Column
  private String code;
  @Column(name = "Btime")
  private Date btime;
  @Column(name="Etime")
  private Date etime;
  private String jiaofu;
  private String quality;
  private String ReturnStatus;
}
