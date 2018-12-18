package cn.edu.hqu.library.entity;

import cn.edu.hqu.library.entity.UnionKey.CollectionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="collection")
@IdClass(CollectionKey.class)
public class Collection {

  @Id
  @Column
  private String userId;
  @Id
  private String bookmsgId;
  private java.sql.Timestamp time;


}
