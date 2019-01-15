package yongs.temp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class EhCacheInitialListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(EhCacheInitialListener.class);
	
	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent sc) {
		ServletContext ctx = sc.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
		EhCacheCacheManager cacheManager = (EhCacheCacheManager) springContext.getBean("cacheManager");

		Cache cache = cacheManager.getCache("tempCache");
		
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		cache.put("key4", "value4");
		cache.put("key5", "value5");
	}
}