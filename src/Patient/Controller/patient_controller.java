package Patient.Controller;

import Patient.Database.ViewPatientInfo;
import Patient.GUI.*;
import Patient.Model.*;

public class patient_controller {

    public Patient view_basic_info() {
        ViewPatientInfo view = new ViewPatientInfo();
        Patient patient = null;

        patient = view.getPatientInfo("123456789012");
        return patient;
    }
}
