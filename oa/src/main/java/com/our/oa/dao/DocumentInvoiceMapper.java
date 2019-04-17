package com.our.oa.dao;

import com.our.oa.entity.DocumentInvoice;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DocumentInvoiceMapper {
    int deleteByPrimaryKey(Integer invoiceDocumentId);

    int insert(DocumentInvoice record);

    DocumentInvoice selectByPrimaryKey(Integer invoiceDocumentId);

    List<DocumentInvoice> selectAll();

    int updateByPrimaryKey(DocumentInvoice record);
}