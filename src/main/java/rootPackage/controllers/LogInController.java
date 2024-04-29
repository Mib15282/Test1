package rootPackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rootPackage.services.LogInService;

@RestController
public class LogInController {
    LogInService logInService;

    @Autowired
    public LogInController (LogInService logInService){
        this.logInService = logInService;
    }

    //@Requestbody asteapta parametri din exteriorul aplicaiei
    @PutMapping(path = "/logIn")
    public ResponseEntity <Boolean> logIn(@RequestBody String email,@RequestBody String password){
        return new ResponseEntity<Boolean>(logInService.logIn(email,password), HttpStatus.OK);
    }
}
