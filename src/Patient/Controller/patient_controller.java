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
        String s;

        list = view.getConsumptionHistory("111111111111");

        return list;
    }
}
