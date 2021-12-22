package Auth.Model;

public class Account {

    String username, password, state;
    int type;

    public Account(String user, String pass, String state, int type) {
        this.username = user;
        this.password = pass;
        this.state = state;
        this.type = type;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }
}
