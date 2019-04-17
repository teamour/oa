package com.our.oa.dao;

import com.our.oa.entity.Announcement;
import java.util.List;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer announcementId);

    int insert(Announcement record);

    Announcement selectByPrimaryKey(Integer announcementId);

    List<Announcement> selectAll();

    int updateByPrimaryKey(Announcement record);
}