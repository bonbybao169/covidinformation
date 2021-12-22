package Patient.Controller;

import Patient.Database.*;
import Patient.Model.*;
import java.util.ArrayList;
import Auth.Controller.auth_controller;

public class patient_controller {

    static ArrayList<EssentialPackage> list = new ArrayList<>();
    auth_controller auth_control = new auth_controller();

    public Patient view_basic_info() {
        ViewPatientInfo view = new ViewPatientInfo();
        Patient patient = null;

        patient = view.getPatientInfo(auth_control.acc.getUsername());
        return patient;
    }

    public ArrayList<ManagementHistory> view_management_history() {
        ViewManagementHistory view = new ViewManagementHistory();
        ArrayList<ManagementHistory> list = null;

        list = view.getManagementHistory(auth_control.acc.getUsername());
        return list;
    }

    public ArrayList<ConsumptionHistory> view_consumption_history() {
        ViewConsumptionHistory view = new ViewConsumptionHistory();
        ArrayList<ConsumptionHistory> list = null;

        list = view.getConsumptionHistory(auth_control.acc.getUsername());

        return list;
    }

    public ArrayList<PaymentHistory> view_payment_history() {
        ViewPaymentHistory view = new ViewPaymentHistory();
        ArrayList<PaymentHistory> list = null;

        list = view.getPaymentHistory(auth_control.acc.getUsername());

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

        int total = view.viewTotalUse(auth_control.acc.getUsername(), epID);
        return total;
    }

    public void addConsumptionHistory(String epID, int quantity) {
        UpdateConsumptionHistory view = new UpdateConsumptionHistory();

        view.updateConsumptionHistory(auth_control.acc.getUsername(), epID, quantity);
    }

    public void buyEssentialPackage(float newDebt) {
        BuyEssentialPackage view = new BuyEssentialPackage();

        view.buyEssentialPackagesByID(newDebt, auth_control.acc.getUsername());
    }
}
