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
@Table(name="book")
public class Book {

  @Id
  @Column(name = "Code")
  private String code;
  @Column(name = "BookID")
  private String bookId;
  private String state;
  private long isDelete;
  private String quality;

}
