package Patient.Controller;

import Patient.Database.*;
import Patient.Model.*;
import java.util.ArrayList;
import java.sql.Date;

public class patient_controller {

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
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackage();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_by_name(String epname) {
        ViewEPByName view = new ViewEPByName();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageByName(epname);

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_id_asc() {
        ViewEPIDASC view = new ViewEPIDASC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageIDASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_id_desc() {
        ViewEPIDDESC view = new ViewEPIDDESC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageIDDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_name_asc() {
        ViewEPNameASC view = new ViewEPNameASC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageNameASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_name_desc() {
        ViewEPNameDESC view = new ViewEPNameDESC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageNameDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_people_asc() {
        ViewEPLimitPeopleASC view = new ViewEPLimitPeopleASC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageLimitPeopleASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_people_desc() {
        ViewEPLimitPeopleDESC view = new ViewEPLimitPeopleDESC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageLimitPeopleDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_time_asc() {
        ViewEPLimitTimeASC view = new ViewEPLimitTimeASC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageLimitTimeASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_limit_time_desc() {
        ViewEPLimitTimeDESC view = new ViewEPLimitTimeDESC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackageLimitTimeDESC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_price_asc() {
        ViewEPPriceASC view = new ViewEPPriceASC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackagePriceASC();

        return list;
    }

    public ArrayList<EssentialPackage> view_essential_package_price_desc() {
        ViewEPPriceDESC view = new ViewEPPriceDESC();
        ArrayList<EssentialPackage> list = null;

        list = view.getEssentialPackagePriceDESC();

        return list;
    }
}
