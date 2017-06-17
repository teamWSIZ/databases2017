package app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String help() {
        return "OK";
    }


}
