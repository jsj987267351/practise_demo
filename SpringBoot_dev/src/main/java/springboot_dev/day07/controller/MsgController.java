package springboot_dev.day07.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_dev.day07.pojo.Book;
import springboot_dev.day07.service.IBookService;
import springboot_dev.day07.service.MsgService;

import java.util.List;

//
//@RestController
//@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;


    @GetMapping("{tel}")
    public String get(@PathVariable String tel){
        return msgService.get(tel);
    }

    @PostMapping
    public boolean check(String tel , String code){
          return msgService.check(tel,code);
    }



}
