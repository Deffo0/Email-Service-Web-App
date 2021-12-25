package Controller.ServerControllers;

import Controller.Email.Email;
import Controller.SingletonClasses.Handlers.SendEmailHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/sent")
public class SentPageController {
    @PostMapping("/movetoTrashSent")
    String movetoTrash(@RequestBody Email email){
        try{
            SendEmailHandler.getInstance().handle("MovetoTrash",email);
            return "MOVED TO TRASH SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
