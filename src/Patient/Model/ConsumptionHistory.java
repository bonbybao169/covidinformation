package Patient.Model;

import java.sql.Date;

public class ConsumptionHistory {

    String account, epid, epname, epquantity;
    Date time;

    public ConsumptionHistory(String accountID, String epid, String epname, String epquantity, Date time) {
        this.account = accountID;
        this.epid = epid;
        this.epname = epname;
        this.epquantity = epquantity;
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public String getEPName() {
        return epname;
    }

    public String getQuantity() {
        return epquantity;
    }

    public Date getTime() {
        return time;
    }
}
