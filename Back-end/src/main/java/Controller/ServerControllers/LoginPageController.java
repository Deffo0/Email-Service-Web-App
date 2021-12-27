package Controller.ServerControllers;

import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Database;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginPageController {
    @PostMapping("/createProfile")
    String createProfile(@RequestParam(value="encryption") String encryption){
        String ret;
        try{
            Database database =  Database.getInstance();
            database.addProfile(encryption);
            database.printDatabase();
            ret = "CREATED PROFILE SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e);
            ret = e.getMessage();
        }
        return ret;
    }
    @PostMapping("/getProfile")
    ProfileI getProfile(@RequestParam(value="encyrption") String encryption){
        try{
            Database database = Database.getInstance();
            return Database.getProfilebyEncryption(encryption);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
