package yongs.temp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service("cacheService")
public class CacheService {

	@Autowired 
	private CacheManager cacheManager;

	public Map<String, String> getCacheMap()  {
		Map<String, String> cacheMap = new HashMap<String, String>();
		Cache cache = cacheManager.getCache("tempCache");
		
		// cache --> hashmap
		cacheMap.put("key1", (String) cache.get("key1").get());
		cacheMap.put("key2", (String) cache.get("key2").get());
		cacheMap.put("key3", (String) cache.get("key3").get());
		cacheMap.put("key4", (String) cache.get("key4").get());
		cacheMap.put("key5", (String) cache.get("key5").get());
		
		return cacheMap;
	}
}
