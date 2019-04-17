package com.our.oa.service;

import com.our.oa.dto.AnnouncementDTO;
import com.our.oa.entity.Announcement;

public interface AnnouncementService {
	
	Announcement getByPrimaryKey(Integer announcementId);
	
	int insert(AnnouncementDTO dto);
	
	int update(AnnouncementDTO dto);
	
	int deleteByPrimaryKey(Integer announcementId);
}
