package cn.edu.hqu.library.Example.entity.UnionKey;

import javax.persistence.Embeddable;
import java.io.Serializable;

/* 联合主键 */
@Embeddable
public class BorrowKey implements Serializable {
    private String userId;
    private String code;
    private String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public BorrowKey(){ }

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
