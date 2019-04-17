package com.our.oa.dao;

import com.our.oa.entity.DocumentPurchase;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DocumentPurchaseMapper {
    int deleteByPrimaryKey(Integer purchaseDocumentId);

    int insert(DocumentPurchase record);

    DocumentPurchase selectByPrimaryKey(Integer purchaseDocumentId);

    List<DocumentPurchase> selectAll();

    int updateByPrimaryKey(DocumentPurchase record);
}