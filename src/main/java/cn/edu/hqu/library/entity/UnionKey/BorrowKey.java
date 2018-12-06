package cn.edu.hqu.library.entity.UnionKey;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/* 联合主键 */
@Embeddable
@Data
@NoArgsConstructor
public class BorrowKey implements Serializable {

    private String userId;

    private String code;

    @Override
    public boolean equals(Object o) {
        if(o instanceof BorrowKey){
            BorrowKey key = (BorrowKey)o ;
            return this.userId.equals(key.getUserId()) && this.code.equals(key.getCode());
        }
        return false ;
    }

    @Override
    public int hashCode() {
        return this.userId.hashCode();
    }

}
