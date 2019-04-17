package com.our.oa.dao;

import com.our.oa.entity.Mailing;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface MailingMapper {
    int deleteByPrimaryKey(Integer mailingId);

    int insert(Mailing record);

    Mailing selectByPrimaryKey(Integer mailingId);

    List<Mailing> selectAll();

    int updateByPrimaryKey(Mailing record);
}