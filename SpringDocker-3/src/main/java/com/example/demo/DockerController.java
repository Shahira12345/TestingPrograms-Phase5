package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DockerController {
	@ResponseBody
    @RequestMapping("user")
    public String init() {
   	 return "Hi users";
    }
}
