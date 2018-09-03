package controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorAPIController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String showError() {
        return "errpr";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
