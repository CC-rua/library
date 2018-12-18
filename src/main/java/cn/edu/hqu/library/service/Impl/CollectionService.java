package cn.edu.hqu.library.service.Impl;


import cn.edu.hqu.library.controller.zx.vo.CollectionInfo;
import cn.edu.hqu.library.entity.Collection;
import cn.edu.hqu.library.mapper.CollectionImp;
import cn.edu.hqu.library.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CollectionService {

    private final CollectionImp collectionImp;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    public CollectionService(CollectionImp collectionImp) {
        this.collectionImp = collectionImp;
    }

    public List<CollectionInfo> findCollectionInfoByUserId(String userId)
    {
        return collectionImp.findCollectionByUserId(userId);
    }

    public boolean collectionBook(String userId,String bookMsgId)
    {
        Collection collection = new Collection(userId,bookMsgId,new Timestamp(System.currentTimeMillis()));
        collectionRepository.save(collection);
        return true;
    }

}
