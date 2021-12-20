package Patient.Controller;

import Patient.Database.*;
import Patient.GUI.*;
import Patient.Model.*;
import java.util.ArrayList;

public class patient_controller {

    public Patient view_basic_info() {
        ViewPatientInfo view = new ViewPatientInfo();
        Patient patient = null;

        patient = view.getPatientInfo("222222222222");
        return patient;
    }

    public ArrayList<ConsumptionHistory> view_management_history() {
        ViewManagementHistory view = new ViewManagementHistory();
        ArrayList<ConsumptionHistory> list = null;

        list = view.getManagementHistory("222222222222");
        return list;
    }
}
