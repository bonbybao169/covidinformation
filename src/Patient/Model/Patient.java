package Patient.Model;

import java.sql.Date;

public class Patient {

    String name, CCCD, address, state, isolationarea, related;
    Date DOB;
    float debt;

    public Patient(String name, String CCCD, String address, String state, String isolationarea, String related, Date DOB, float debt) {
        this.name = name;
        this.CCCD = CCCD;
        this.address = address;
        this.state = state;
        this.isolationarea = isolationarea;
        this.related = related;
        this.DOB = DOB;
        this.debt = debt;
    }

    public Patient(String name, String CCCD, Date DOB, String address, String state, String isolationarea, float debt) {
        this.name = name;
        this.CCCD = CCCD;
        this.address = address;
        this.state = state;
        this.isolationarea = isolationarea;

        this.DOB = DOB;
        this.debt = debt;
    }

    public String getName() {
        return name;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getIsolation() {
        return isolationarea;
    }

    public String getRelated() {
        return related;
    }

    public Date getDOB() {
        return DOB;
    }

    public float getDebt() {
        return debt;
    }

}
