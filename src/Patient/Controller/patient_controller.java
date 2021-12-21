package Patient.Controller;

import Patient.Database.*;
import Patient.Model.*;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class patient_controller {

    static ArrayList<EssentialPackage> list = new ArrayList<>();

    public Patient view_basic_info() {
        ViewPatientInfo view = new ViewPatientInfo();
        Patient patient = null;

        patient = view.getPatientInfo("222222222222");
        return patient;
    }

    public ArrayList<ManagementHistory> view_management_history() {
        ViewManagementHistory view = new ViewManagementHistory();
        ArrayList<ManagementHistory> list = null;

        list = view.getManagementHistory("222222222222");
        return list;
    }

    public ArrayList<ConsumptionHistory> view_consumption_history() {
        ViewConsumptionHistory view = new ViewConsumptionHistory();
        ArrayList<ConsumptionHistory> list = null;

        list = view.getConsumptionHistory("111111111111");

        return list;
    }

    public ArrayList<PaymentHistory> view_payment_history() {
        ViewPaymentHistory view = new ViewPaymentHistory();
        ArrayList<PaymentHistory> list = null;

        list = view.getPaymentHistory("111111111111");

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package() {
        ViewEssentialPackage view = new ViewEssentialPackage();

        list = view.getEssentialPackage();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_by_name(String epname) {
        ViewEPByName view = new ViewEPByName();

        list = view.getEssentialPackageByName(epname);

        return list;
    }

    public EssentialPackage view_essential_package_by_id(String epID) {
        EssentialPackage ep = null;
        ViewEPByID view = new ViewEPByID();

        ep = view.getEssentialPackageByID(epID);

        return ep;
    }

    public ArrayList<EssentialPackage> view_essential_package_id_asc() {
        ViewEPIDASC view = new ViewEPIDASC();

        list = view.getEssentialPackageIDASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_id_desc() {
        ViewEPIDDESC view = new ViewEPIDDESC();

        list = view.getEssentialPackageIDDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_name_asc() {
        ViewEPNameASC view = new ViewEPNameASC();

        list = view.getEssentialPackageNameASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_name_desc() {
        ViewEPNameDESC view = new ViewEPNameDESC();

        list = view.getEssentialPackageNameDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_people_asc() {
        ViewEPLimitPeopleASC view = new ViewEPLimitPeopleASC();

        list = view.getEssentialPackageLimitPeopleASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_people_desc() {
        ViewEPLimitPeopleDESC view = new ViewEPLimitPeopleDESC();

        list = view.getEssentialPackageLimitPeopleDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_time_asc() {
        ViewEPLimitTimeASC view = new ViewEPLimitTimeASC();

        list = view.getEssentialPackageLimitTimeASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_time_desc() {
        ViewEPLimitTimeDESC view = new ViewEPLimitTimeDESC();

        list = view.getEssentialPackageLimitTimeDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_price_asc() {
        ViewEPPriceASC view = new ViewEPPriceASC();

        list = view.getEssentialPackagePriceASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_price_desc() {
        ViewEPPriceDESC view = new ViewEPPriceDESC();

        list = view.getEssentialPackagePriceDESC();

        return list;
    }

    public void filter_essential_package(String limitPeopleFrom, String limitPeopleTo, String limitTimeFrom, String limitTimeTo, String priceFrom, String priceTo) {
        FilterEssentialPackage view = new FilterEssentialPackage();

        int limitPF;
        int limitPT;
        float priceF;
        float priceT;
        String temp;

        temp = limitPeopleFrom.trim();
        if (temp.equals("")) {
            limitPF = 0;
        } else {
            limitPF = Integer.parseInt(limitPeopleFrom);
        }

        temp = limitPeopleTo.trim();
        if (temp.equals("")) {
            limitPT = 2147483647;
        } else {
            limitPT = Integer.parseInt(limitPeopleTo);
        }

        temp = priceFrom.trim();
        if (temp.equals("")) {
            priceF = 0;
        } else {
            priceF = Float.parseFloat(priceFrom);
        }

        temp = priceTo.trim();
        if (temp.equals("")) {
            priceT = 2147483647;
        } else {
            priceT = Float.parseFloat(priceTo);
        }

        temp = limitTimeFrom.trim();
        if (temp.equals("")) {
            limitTimeFrom = "2001-01-01";
        }

        temp = limitTimeTo.trim();
        if (temp.equals("")) {
            limitTimeTo = "2030-01-01";
        }

        System.out.println("timeF: " + limitTimeFrom);
        System.out.println("timeT: " + limitTimeTo);
        System.out.println("priceF: " + priceF);
        System.out.println("priceT: " + priceT);
        System.out.println("peopleF: " + limitPF);
        System.out.println("peopleT: " + limitPT);

        this.list = view.filterEP(limitPF, limitPT, java.sql.Date.valueOf(limitTimeFrom), java.sql.Date.valueOf(limitTimeTo), priceF, priceT);
    }

    public ArrayList<EssentialPackage> view_filtered_EP() {

        for (EssentialPackage e : this.list) {
            System.out.println("ID: " + e.getEPID());
        }

        return this.list;
    }

    public int getTotalUse(String epID) {
        ViewTotalUseByMpIDAndEpID view = new ViewTotalUseByMpIDAndEpID();
        System.out.println("I'm in control.");

        int total = view.viewTotalUse("111111111111", epID);
        return total;
    }
}
