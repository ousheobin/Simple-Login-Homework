package cn.oushaobin.crm.constant;

import java.util.HashMap;
import java.util.Map;

public class AdminConfig {
	
	public static Map<String,String> getAdminMap(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("admin", "123456");
		return map;
	}

}
