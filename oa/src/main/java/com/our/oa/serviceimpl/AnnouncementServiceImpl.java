package com.our.oa.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.AnnouncementMapper;
import com.our.oa.dto.AnnouncementDTO;
import com.our.oa.entity.Announcement;
import com.our.oa.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementMapper announcementMapper;
	
	@Override
	public Announcement getByPrimaryKey(Integer announcementId) {
		return announcementMapper.selectByPrimaryKey(announcementId);
	}

	@Override
	public int insert(AnnouncementDTO dto) {
	    ModelMapper modelMapper = new ModelMapper();
	    Announcement record = modelMapper.map(dto, Announcement.class);
	    
		return announcementMapper.insert(record);
	}

	@Override
	public int update(AnnouncementDTO dto) {
	    ModelMapper modelMapper = new ModelMapper();
	    Announcement record = modelMapper.map(dto, Announcement.class);
	    
		return announcementMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer announcementId) {
		return announcementMapper.deleteByPrimaryKey(announcementId);
	}

}
