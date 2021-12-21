/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment.Controller;

import Payment.Database.*;
import Payment.GUI.*;
import java.util.*;
public class payment_controller {
    static Payment_Backend be = new Payment_Backend();
    
    public List<String[]> info_admin(){
        List<String[]> list = null;
        list = be.InfoAdmin();
        return list;
    }
    public List<String[]> list_payment(){
        List<String[]> list = null;
        list = be.ListPayment();
        return list;
    }
    public List<String[]> find_payment(String CCCD){
        List<String[]> list = null;
        list = be.FindPayment(CCCD);
        return list;
    }
    public List<String[]> list_patient(){
        List<String[]> list = null;
        list = be.ListPatient();
        return list;
    }
    public List<String[]> find_patient(String CCCD){
        List<String[]> list = null;
        list = be.FindPatient(CCCD);
        return list;
    }
    public void add_payaccount(String CCCD,int balance){
        be.AddPayAccount(CCCD,balance);
    }
    public static void main(String args[]) {
        
    }
}
