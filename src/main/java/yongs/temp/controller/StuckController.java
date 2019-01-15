package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class StuckController {
    private static final Logger logger = LoggerFactory.getLogger(StuckController.class);
    
    @RequestMapping("/admin/stuck")
    public String stuck() {
    	logger.info("Start infinite loop  ... ...");
    	while(true);
    }
}