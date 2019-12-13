package cjl.springboot.com.lessionOne.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @RequestMapping("/{username}")
    @ResponseBody
    public String home(@PathVariable String username){
        return "hello world ++-1234-"+username;
    }
}