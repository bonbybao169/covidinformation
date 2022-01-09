package Auth.Controller;

import Auth.Database.CheckAccountAvailable;
import Auth.Database.CheckMPInfoAvailable;
import Auth.Database.UpdatePassword;
import Auth.Database.CreateAdmin;
import Auth.Database.GetAccountByID;
import Auth.Model.Account;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class auth_controller {

    public static Account acc = null;

    public String encodeString(String password) {
        String encodingType = "utf-8";
        String encodedString = null;
        try {
            encodedString = Base64.getEncoder().encodeToString(password.getBytes(encodingType));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(auth_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encodedString;
    }

    public String decodeString(String password) {
        String encodingType = "utf-8";
        String decodedString = null;
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        try {
            decodedString = new String(decodedBytes, encodingType);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(auth_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return decodedString;
    }

    public boolean checkAdmin() {
        boolean available = false;
        CreateAdmin checkAdmin = new CreateAdmin();

        return checkAdmin.CheckAdmin();
    }

    public void createAdmin(String username, String password) {
        boolean available = false;
        CreateAdmin createAdmin = new CreateAdmin();
        createAdmin.CreateAdmin(username, encodeString(password));
    }

    public boolean checkAccountAvailable(String username) {
        boolean available = false;
        CheckAccountAvailable checkAccount = new CheckAccountAvailable();

        if (checkAccount.checkAccountAvailable(username)) {
            available = true;
        } else {
            available = false;
        }

        return available;
    }

    public boolean checkMPAvailable(String username) {
        boolean available = false;
        CheckMPInfoAvailable checkMP = new CheckMPInfoAvailable();

        if (checkMP.checkMPInfoAvailable(username)) {
            available = true;
        } else {
            available = false;
        }

        return available;
    }

    public void getAccountByID(String username) {
        GetAccountByID view = new GetAccountByID();
        acc = view.getAccountByID(username);
    }

    public void updatePasswordAccount(String username, String password) {
        UpdatePassword view = new UpdatePassword();

        view.updatePasswordAccount(username, encodeString(password));
    }
}
