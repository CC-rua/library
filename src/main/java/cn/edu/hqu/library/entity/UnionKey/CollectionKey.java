package cn.edu.hqu.library.entity.UnionKey;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/* 联合主键 */
@Embeddable
@Data
@NoArgsConstructor
public class CollectionKey implements Serializable {

    private String userId;

    private String bookmsgId;

    @Override
    public boolean equals(Object o) {
        if(o instanceof CollectionKey){
            CollectionKey key = (CollectionKey)o ;
            return this.userId.equals(key.getUserId()) && this.bookmsgId.equals(key.getBookmsgId());
        }
        return false ;
    }

    @Override
    public int hashCode() {
        return this.userId.hashCode();
    }

}
