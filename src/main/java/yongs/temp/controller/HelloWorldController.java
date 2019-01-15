package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    // @Autowired
    // HelloWS helloClient;
       
    @RequestMapping("/hello")
    public String hello(Model model) {
    	logger.info("HelloWorldController.");
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "helloworld";
    }
    
/*    @RequestMapping("/helloClient")
    public String helloClient(Model model) {
    	logger.info("HelloWorldController.");
        model.addAttribute("greeting", helloClient.sayHello("Tomcat Community Version"));
        
        return "helloworld";
    }*/
}