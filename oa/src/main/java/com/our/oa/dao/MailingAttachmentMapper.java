package com.our.oa.dao;

import com.our.oa.entity.MailingAttachment;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface MailingAttachmentMapper {
    int deleteByPrimaryKey(Integer mailingAttachmentId);

    int insert(MailingAttachment record);

    MailingAttachment selectByPrimaryKey(Integer mailingAttachmentId);

    List<MailingAttachment> selectAll();

    int updateByPrimaryKey(MailingAttachment record);
}