package cn.edu.hqu.library.service.Impl;


import cn.edu.hqu.library.controller.zx.vo.CollectionInfo;
import cn.edu.hqu.library.mapper.CollectionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionImp collectionImp;

    @Autowired
    public CollectionService(CollectionImp collectionImp) {
        this.collectionImp = collectionImp;
    }

    public List<CollectionInfo> findCollectionInfoByUserId(String userId)
    {
        return collectionImp.findCollectionByUserId(userId);
    }

}
