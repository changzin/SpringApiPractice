package Changzin.SpringApiPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/memberCRUD")
    public String member(){
        return "memberCRUD";
    }

    @GetMapping("/memberCRUD/new")
    public void create(){

    }
}
