package Auth.Controller;

import Auth.Database.CheckAccountAvailable;
import Auth.Database.CheckMPInfoAvailable;
import Auth.Database.CreateAccount;
import Auth.Database.CreateAdmin;
import Auth.Database.GetAccountByID;
import Auth.Model.Account;

public class auth_controller {
    
    public static Account acc = null;
    public boolean checkAdmin() {
        boolean available = false;
        CreateAdmin checkAdmin = new CreateAdmin();
        
        return checkAdmin.CheckAdmin();
    }
    public void createAdmin(String username,String password) {
        boolean available = false;
        CreateAdmin createAdmin = new CreateAdmin();
        createAdmin.CreateAdmin(username,password);
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
    
    public void createPatientAccount(String username, String password) {
        CreateAccount view = new CreateAccount();
        
        view.createPatientAccount(username, password);
    }
}
