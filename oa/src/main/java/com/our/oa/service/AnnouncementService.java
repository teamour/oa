package com.our.oa.service;

import com.our.oa.dto.form.AnnouncementDTO;
import com.our.oa.dto.list.AnnouncementListDTO;
import com.our.oa.dto.list.AnnouncementListQueryDTO;
import com.our.oa.entity.Announcement;

public interface AnnouncementService extends ListQueryService<AnnouncementListDTO,AnnouncementListQueryDTO> {
	
	Announcement getByPrimaryKey(Integer announcementId);
	
	int insert(AnnouncementDTO dto);
	
	int update(AnnouncementDTO dto);
	
	int deleteByPrimaryKey(Integer announcementId);
}
