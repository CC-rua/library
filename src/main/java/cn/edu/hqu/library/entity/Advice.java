package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="advice")
public class Advice {

  @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adviceID")
  private Integer adviceId;
  private String userId;
  private String name;
  private String adviceMsg;

  private String state;
}
