package com.bugreporting.constants;

import java.util.HashMap;
import java.util.Map;

public enum Platform {

	JAVA("1"), ANDROID("2"), IOS("3"), PHP("4"), DOTNET("5");

	private String statusValue;
	/*private static Map<String,String> mapVals=new HashMap<>(5);*/
	
	private Platform(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getStatusValue() {
		return statusValue;
	}
	
	/*public static String getEnumVals(String key){
		
		if(mapVals.isEmpty()){
		
			for(Platform platform:Platform.values()){
			
				mapVals.put(platform.toString(), platform.getStatusValue());
			}
		}
		return mapVals.get(key);
	}*/
	
	
	
	
}
