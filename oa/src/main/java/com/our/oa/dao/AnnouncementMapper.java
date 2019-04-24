package com.our.oa.dao;

import com.github.pagehelper.Page;
import com.our.oa.dto.list.AnnouncementListDTO;
import com.our.oa.dto.list.AnnouncementListQueryDTO;
import com.our.oa.entity.Announcement;

/**
* Created by Mybatis Generator on 2019/03/31
*/
public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer announcementId);

    int insert(Announcement record);

    Announcement selectByPrimaryKey(Integer announcementId);

    Page<AnnouncementListDTO> selectQueryList(AnnouncementListQueryDTO queryDTO);

    int updateByPrimaryKey(Announcement record);
}