package com.our.oa.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.oa.dao.DictionaryDetailMapper;
import com.our.oa.dao.DictionaryMapper;
import com.our.oa.entity.Dictionary;
import com.our.oa.entity.DictionaryDetail;
import com.our.oa.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper mapper;
	
	@Autowired
	private DictionaryDetailMapper detailMapper;
	
	private static Map<Integer, List<DictionaryDetail>> strMap;
	
	private void Init() {
		System.out.println("初始化字典中...");
		
		strMap = new HashMap<Integer, List<DictionaryDetail>>();
		
		if (mapper == null) {
			System.out.println("mapper is null");
		} else {
			List<Dictionary> dicList = mapper.getAll();

			if (dicList.size() ==0) {
				return;
			}
			
			List<DictionaryDetail> dlist = null;
			for (int i = 0; i < dicList.size(); i++) {
				dlist = detailMapper.getDicListByDictId(i + 1);

				if (dlist != null) {
					strMap.put(i + 1, dlist);
				}
			}
		}
		
		System.out.println("初始化完成...");
	}
	
	@Override
	public String getDetailName(Integer dictId, Integer v) {
		if (dictId == null || v == null) {
			System.out.println("参数有问题");
			return "";
		}
		
		if (strMap == null) {
			Init();
		}
		
		if (strMap == null) {
			System.out.println("创建字典失败...");
			return "";
		} else {
			return strMap.get(dictId).get(v).getDetailName();
		}
	}
	
	@Override
	public List<DictionaryDetail> getDetailNames(Integer dictId) {
		return detailMapper.getDicListByDictId(dictId);
	}
}
