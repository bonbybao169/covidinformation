/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;

import Admin.Database.*;
import Admin.GUI.*;
import java.util.*;
import Auth.Controller.auth_controller;

public class admin_controller {

    static Admin_Backend be = new Admin_Backend();
    static auth_controller ac = new auth_controller();

    public void create_manager(String username, String password) {
        be.CreateManager(username, ac.encodeString(password));
    }

    public List<String[]> list_manager() {
        List<String[]> list = null;
        list = be.ListManager();
        return list;
    }

    public void lock_open_manager(String username, String state) {
        if (username != null) {
            if (state.equals("OPEN") || state == null) {
                be.LockOrOpen(username, "LOCK");
            } else if (state.equals("LOCK")) {
                be.LockOrOpen(username, "OPEN");
            }
        }
    }

    public List<String[]> history_manager(String username) {
        List<String[]> list = null;
        list = be.HistoryManager(username);
        return list;
    }

    public List<String[]> find_manager(String username) {
        List<String[]> list = null;
        list = be.FindManager(username);
        return list;
    }

    public List<String[]> list_hospital() {
        List<String[]> list = null;
        list = be.ListHospital();
        return list;
    }

    public void add_hospital(String ID, String Name, int MaxCapicity, int PresentCapicity) {
        be.AddHospital(ID, Name, MaxCapicity, PresentCapicity);
    }

    public void delete_hospital(String ID) {
        be.DeleteHospital(ID);
    }

    public void update_hospital(String ID, String Name, int MaxCapicity, int PresentCapicity) {
        be.UpdateHospital(ID, Name, MaxCapicity, PresentCapicity);
    }

    public List<String[]> find_hospital(String ID) {
        List<String[]> list = null;
        list = be.FindHospital(ID);
        return list;

    }

    public static void main(String args[]) {
        be.DeleteHospital("HP100");
    }
}
