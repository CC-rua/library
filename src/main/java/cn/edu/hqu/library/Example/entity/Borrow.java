package cn.edu.hqu.library.Example.entity;

import cn.edu.hqu.library.Example.entity.UnionKey.BorrowKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
  private java.sql.Timestamp btime;
  @Column(name="Etime")
  private java.sql.Timestamp etime;
  private String jiaofu;


}
