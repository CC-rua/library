package cn.edu.hqu.library.Example.entity;

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
@Table(name="borrow")
public class Borrow {

  @Id
  @Column(name = "UserID")
  private String userId;

  @Column
  private String code;
  @Column(name = "Btime")
  private java.sql.Timestamp btime;
  @Column(name="Etime")
  private java.sql.Timestamp etime;
  private String jiaofu;


}
