package Patient.Model;

import java.sql.Date;

public class EssentialPackage {

    String epID, name;
    int limitPeople;
    Date limitDate;
    float price;

    public EssentialPackage(String epID, String name, int limitPeople, Date limitDate, float price) {
        this.epID = epID;
        this.name = name;
        this.limitPeople = limitPeople;
        this.limitDate = limitDate;
        this.price = price;
    }

    public String getEPID() {
        return epID;
    }

    public String getEPName() {
        return name;
    }

    public int getLimitPeople() {
        return limitPeople;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public float getPrice() {
        return price;
    }
}
