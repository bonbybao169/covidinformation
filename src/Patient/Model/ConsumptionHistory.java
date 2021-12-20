package Patient.Model;

import java.sql.Date;

public class ConsumptionHistory {

    String account, content;
    Date time;

    public ConsumptionHistory(String accountID, String content, Date time) {
        this.account = accountID;
        this.content = content;
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
