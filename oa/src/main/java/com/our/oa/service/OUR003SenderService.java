package com.our.oa.service;


import java.util.List;

import com.github.pagehelper.Page;
import com.our.oa.entity.Sender;

public interface OUR003SenderService{
	
	Page<Sender> getSenderAll(); 
	
	boolean insertSender(Sender sender);
	
	boolean deleteSender(String senderId);
	
	List<Sender> getSenderAllList();
}
