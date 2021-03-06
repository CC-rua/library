package cn.edu.hqu.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

  @Id
  @Column(name = "UserID")
  private String userId;
  @Column(name = "passwd")
  private String password;
  private String type;
  private LocalDate birthday;
  private String name;
  private String department;
  private String grade;
  private String major;
  private Integer sex;//1 男 2 女 3 未知
}
