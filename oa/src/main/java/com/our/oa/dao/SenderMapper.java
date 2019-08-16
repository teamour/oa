package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.entity.Sender;

public interface SenderMapper {
    int insert(Sender sender);
    
    int deleteBySenderId(Integer senderId);
    
    Page<Sender> selectAll();
    
    Sender seleteBySenderId(Integer senderId);
}