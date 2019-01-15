package yongs.temp.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.service.CacheService;
 
@Controller
public class CacheTestController {
   @Autowired
   private CacheService cacheService;

    @RequestMapping("/cache")
    public String cache(HttpServletRequest req, Model model) throws Exception {
    	StringBuffer strb = new StringBuffer();
    	Map<String, String> cacheMap = cacheService.getCacheMap();
    	Iterator iterator = cacheMap.entrySet().iterator();    	
    	while (iterator.hasNext()) {
    		Entry entry = (Entry)iterator.next();
    		strb.append(entry.getKey() + " ::: " + entry.getValue());
    		strb.append("<br>");
    	}
    	model.addAttribute("out", strb.toString());
    	
        return "result";
    }
}