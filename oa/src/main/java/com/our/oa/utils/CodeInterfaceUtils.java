package com.our.oa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeInterfaceUtils {
	private static class SingletonClassInstance{
        private static final CodeInterfaceUtils instance = new CodeInterfaceUtils();
	}
		       
	private CodeInterfaceUtils(){}
		     
	public static CodeInterfaceUtils getInstance(){
		return SingletonClassInstance.instance;
	}
	
	@SuppressWarnings("unused")
	public List<Integer> getListid(String ids) {
		String[] cuStrings = ids.split(",");
		List<Integer> idList = new ArrayList<>();
		Pattern pattern = Pattern.compile("[0-9]*");
		for (String string : cuStrings) {
			Matcher isNum = pattern.matcher(string);
			
			if (!string.isEmpty() && isNum.matches()) {
				idList.add(Integer.valueOf(string));
			}
		}
		return idList;
	}
}
