package springboot_dev.day12.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_dev.day12.service.MessageService;


//@RestController
//@RequestMapping("/msgs")
public class MessageController {


    @Autowired
    private MessageService messageService;


    @GetMapping
    public String doMessage(){
        String id = messageService.doMessage();
        return id;
    }

}
