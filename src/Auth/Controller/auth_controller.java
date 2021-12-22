package Auth.Controller;

import Auth.Database.CheckAccountAvailable;
import Auth.Database.CheckMPInfoAvailable;
import Auth.Database.GetAccountByID;
import Auth.Model.Account;

public class auth_controller {

    public static Account acc = null;

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
}
