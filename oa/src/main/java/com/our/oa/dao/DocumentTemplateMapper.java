package com.our.oa.dao;

import com.our.oa.entity.DocumentTemplate;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface DocumentTemplateMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insert(DocumentTemplate record);

    DocumentTemplate selectByPrimaryKey(Integer templateId);

    List<DocumentTemplate> selectAll();

    int updateByPrimaryKey(DocumentTemplate record);
}