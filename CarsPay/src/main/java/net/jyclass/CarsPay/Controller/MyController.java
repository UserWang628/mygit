package net.jyclass.CarsPay.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("Test")
    public String Test(){
        return "Hello world!!!";
    }
}
