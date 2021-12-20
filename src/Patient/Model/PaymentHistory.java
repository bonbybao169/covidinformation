package Patient.Model;

import java.sql.Date;

public class PaymentHistory {

    String content;
    int cash;
    Date time;
    float debt;

    public PaymentHistory(String content, int cash, Date time, float debt) {
        this.content = content;
        this.cash = cash;
        this.time = time;
        this.debt = debt;
    }

    public String getContent() {
        return content;
    }

    public int getCash() {
        return cash;
    }

    public Date getTime() {
        return time;
    }

    public float getDebt() {
        return debt;
    }
}
