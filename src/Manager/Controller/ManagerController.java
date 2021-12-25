/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager.Controller;

import Manager.Service.CovidManagementService;
import Manager.Service.EssentialPackageManagementService;
import Manager.Service.StatisticService;
import Patient.Model.Patient;
import java.sql.Date;

import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class ManagerController {

    public ArrayList<Patient> view_patient_list() {
        ArrayList<Patient> list = new ArrayList<>();
        CovidManagementService service = new CovidManagementService();
        list = service.showList();
        return list;
    }

    public ArrayList<Patient> sort_ASC_byName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortASCByName();
    }

    public ArrayList<Patient> sort_DESC_byName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDESCByName();
    }

    public ArrayList<Patient> sort_ASC_byHopitalName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortASCByHopital();
    }

    public ArrayList<Patient> sort_DESC_byHopitalName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDESCByHopital();
    }

    public ArrayList<Patient> sort_ASC_byState() {

        CovidManagementService service = new CovidManagementService();

        return service.sortASCByState();
    }

    public ArrayList<Patient> sort_DESC_byState() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDESCByState();
    }

    public ArrayList<Patient> sort_ASC_byDebt() {

        CovidManagementService service = new CovidManagementService();

        return service.sortASCByDebt();
    }

    public ArrayList<Patient> sort_DESC_byDebt() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDESCByDebt();
    }

    public ArrayList<Patient> sort_ASC_byDOB() {

        CovidManagementService service = new CovidManagementService();

        return service.sortASCByDOB();
    }

    public ArrayList<Patient> sort_DESC_byDOB() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDESCByDOB();
    }

    public void transfer_State(String mnId, String CCCD, int oldState, int newState) {
        CovidManagementService service = new CovidManagementService();
        service.transferStatus(CCCD, newState);
        service.addTransferStatusHistoryForManager(mnId, CCCD, Integer.toString(oldState), Integer.toString(newState));
    }

    public void transfer_Hopital(String mnId, String CCCD, String oldHopital, String newHopitalID, String newHopitalName) {
        CovidManagementService service = new CovidManagementService();
        service.transferIsolationArea(CCCD, newHopitalID);
        service.addTransferIsolationAreaHistoryForManager(mnId, CCCD, oldHopital, newHopitalName);
    }

    public int add_newPatient(String mnId, Patient newMP) {
        CovidManagementService service = new CovidManagementService();
        if (service.findByCCCD(newMP.getCCCD()) != null) {
            return -1;
        }
        if (newMP.getRelated() != null && service.findByCCCD(newMP.getRelated()) == null) {
            return 0;
        }
        service.addNewMP_Info(newMP);
        service.addNewMPInforHistoryForManager(mnId, newMP.getCCCD());
        service.addNewMPAccount(newMP.getCCCD());
        service.addNewMPAccountHistoryForManager(mnId, newMP.getCCCD());
        return 1;
    }

    public ArrayList<String[]> view_Isolation_Area_List() {
        CovidManagementService service = new CovidManagementService();
        return service.findIsolationArea();
    }

    public ArrayList<String[]> view_RelatedPeople_List(String CCCD) {
        CovidManagementService service = new CovidManagementService();
        return service.findRelatedPeopleList(CCCD);
    }

    public Patient searchPatient(String MPID) {
        CovidManagementService service = new CovidManagementService();
        return service.findByCCCD(MPID);
    }

    public void add_NewEssentialPackage(String mnId, String epID, String name, int limitPeople, Date limitDate, float price) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.addNewEssentialPackage(epID, name, limitPeople, limitDate, price);
        service.addNewEPHistoryForManager(mnId, epID);

    }

    public void UpdateEssentialPackage(String mnId, String epID, String name, int limitPeople, Date limitDate, float price) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.updateEssentialPackage(epID, name, limitPeople, limitDate, price);
        service.addUpdateEPHistoryForManager(mnId, epID);

    }

    public void DelEssentialPackage(String mnId, String epID) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.deleteEssentialPackage(epID);
        service.addDelEPHistoryForManager(mnId, epID);

    }

    public ArrayList<String[]> view_Consumption_Statisitc(String mnId) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(mnId, "tiêu thụ");
        return service.showConsumption();

    }

    public ArrayList<String[]> view_State_Statisitc(String mnId) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(mnId, "số lượng người theo từng trạng thái");
        return service.showStateStatistic();
    }

    public ArrayList<String[]> view_Cured_Statisitc(String mnId) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(mnId, "F0 được chữa khỏi");
        return service.showCuredStatistic();
    }

    public ArrayList<String[]> view_Debt_Statisitc(String mnId) {
        StatisticService service = new StatisticService();
        CovidManagementService s = new CovidManagementService();
        ArrayList<String[]> list = new ArrayList<String[]>();
        ArrayList<Patient> pList = new ArrayList<Patient>();
        pList = s.showList();
        for (Patient p : pList) {
            String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), Float.toString(p.getDebt())};
            list.add(temp);
        }
        service.addStatistictHistoryForManager(mnId, "dư nợ");
        return list;
    }

    public String cal_total_Debt() {
        StatisticService service = new StatisticService();
        return Float.toString(service.calTotalDebt());
    }

    public String cal_total_Cured() {
        StatisticService service = new StatisticService();
        return Integer.toString(service.calTotalCured());
    }

    public String cal_total_Consumption() {
        StatisticService service = new StatisticService();
        return Integer.toString(service.calTotalConsumption());
    }

    public String cal_total_Patient() {
        StatisticService service = new StatisticService();
        return Integer.toString(service.calTotalPatient());
    }
}
