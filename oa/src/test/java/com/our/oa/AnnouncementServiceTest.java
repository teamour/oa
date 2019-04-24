package com.our.oa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.our.oa.entity.Announcement;
import com.our.oa.service.AnnouncementService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class AnnouncementServiceTest {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Test
	public void getAnnouncementById() {
		Announcement announcement = announcementService.getByPrimaryKey(1);
		assertNotNull(announcement);
		System.out.println(announcement);
	}
	
}
