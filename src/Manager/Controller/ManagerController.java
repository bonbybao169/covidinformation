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

    public ArrayList<Patient> sort_ACS_byName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortACSByName();
    }

    public ArrayList<Patient> sort_DECS_byName() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDECSByName();
    }

    public ArrayList<Patient> sort_ACS_byState() {

        CovidManagementService service = new CovidManagementService();

        return service.sortACSByState();
    }

    public ArrayList<Patient> sort_DECS_byState() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDECSByState();
    }

    public ArrayList<Patient> sort_ACS_byDebt() {

        CovidManagementService service = new CovidManagementService();

        return service.sortACSByDebt();
    }

    public ArrayList<Patient> sort_DECS_byDebt() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDECSByDebt();
    }

    public ArrayList<Patient> sort_ACS_byDOB() {

        CovidManagementService service = new CovidManagementService();

        return service.sortACSByDOB();
    }

    public ArrayList<Patient> sort_DECS_byDOB() {

        CovidManagementService service = new CovidManagementService();

        return service.sortDECSByDOB();
    }

    public void transfer_State(String MNID, String CCCD, int oldState, int newState) {
        CovidManagementService service = new CovidManagementService();
        service.transferStatus(CCCD, newState);
        service.addTransferStatusHistoryForManager(MNID, CCCD, Integer.toString(oldState), Integer.toString(newState));
    }

    public void transfer_Hopital(String MNID, String CCCD, String oldHopital, String newHopital) {
        CovidManagementService service = new CovidManagementService();
        service.transferIsolationArea(CCCD, oldHopital);
        service.addTransferIsolationAreaHistoryForManager(MNID, CCCD, oldHopital, newHopital);
    }

    public void add_newPatient(String MNID, Patient newMP) {
        CovidManagementService service = new CovidManagementService();
        service.addNewMP_Info(newMP);
        service.addNewMPInforHistoryForManager(MNID, newMP.getCCCD());
        service.addNewMPAccount(newMP.getCCCD());
        service.addNewMPAccountHistoryForManager(MNID, newMP.getCCCD());

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

    public void add_NewEssentialPackage(String MNID, String epID, String name, int limitPeople, Date limitDate, float price) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.addNewEssentialPackage(epID, name, limitPeople, limitDate, price);
        service.addNewEPHistoryForManager(MNID, epID);

    }

    public void UpdateEssentialPackage(String MNID, String epID, String name, int limitPeople, Date limitDate, float price) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.updateEssentialPackage(epID, name, limitPeople, limitDate, price);
        service.addUpdateEPHistoryForManager(MNID, epID);

    }

    public void DelEssentialPackage(String MNID, String epID) {
        EssentialPackageManagementService service = new EssentialPackageManagementService();
        service.deleteEssentialPackage(epID);
        service.addDelEPHistoryForManager(MNID, epID);

    }

    public ArrayList<String[]> view_Consumption_Statisitc(String MNID) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(MNID, "tiêu thụ");
        return service.showConsumption();

    }

    public ArrayList<String[]> view_State_Statisitc(String MNID) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(MNID, "số lượng người theo từng trạng thái");
        return service.showStateStatistic();
    }

    public ArrayList<String[]> view_Cured_Statisitc(String MNID) {
        StatisticService service = new StatisticService();
        service.addStatistictHistoryForManager(MNID, "F0 được chữa khỏi");
        return service.showCuredStatistic();
    }

    public ArrayList<String[]> view_Debt_Statisitc(String MNID) {
        StatisticService service = new StatisticService();
        CovidManagementService s = new CovidManagementService();
        ArrayList<String[]> list = new ArrayList<String[]>();
        ArrayList<Patient> pList = new ArrayList<Patient>();
        pList = s.showList();
        for (Patient p : pList) {
            String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), Float.toString(p.getDebt())};
            list.add(temp);
        }
        service.addStatistictHistoryForManager(MNID, "dư nợ");
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
