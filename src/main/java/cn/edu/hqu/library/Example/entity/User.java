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
@Table(name="user")
public class User {

  @Id
  @Column(name = "UserID")
  private String userId;
  private String passwd;
  private String type;
}
