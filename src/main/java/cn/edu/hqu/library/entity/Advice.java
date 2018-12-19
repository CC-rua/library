package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="advice")
public class Advice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adviceID")
  private Integer adviceId;

  @Column(name = "userID")
  private String userId;

  private String name;

  @Column(name = "message")
  private String message;

  private String state;
}
