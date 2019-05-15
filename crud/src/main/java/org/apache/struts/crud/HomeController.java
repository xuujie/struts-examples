package org.apache.struts.crud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final Logger LOG = LogManager.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String home() {
        LOG.info("Home Page");
        return "index";
    }
}
