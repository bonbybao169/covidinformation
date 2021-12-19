package Manager.Model;

import java.sql.*;

public class Manager {

    String name, state;

    public Manager(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
