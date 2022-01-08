/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment.Controller;

import Payment.Database.*;
import Payment.GUI.*;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class payment_controller {

    static Payment_Backend be = new Payment_Backend();

    public String encodeString(String password) {
        String encodingType = "utf-8";
        String encodedString = null;
        try {
            encodedString = Base64.getEncoder().encodeToString(password.getBytes(encodingType));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(payment_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encodedString;
    }

    public String decodeString(String password) {
        String encodingType = "utf-8";
        String decodedString = null;
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        try {
            decodedString = new String(decodedBytes, encodingType);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(payment_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return decodedString;
    }

    public List<String[]> info_admin() {
        List<String[]> list = null;
        list = be.InfoAdmin();
        return list;
    }

    public List<String[]> list_payment() {
        List<String[]> list = null;
        list = be.ListPayment();
        return list;
    }

    public List<String[]> find_payment(String CCCD) {
        List<String[]> list = null;
        list = be.FindPayment(CCCD);
        return list;
    }

    public List<String[]> list_patient() {
        List<String[]> list = null;
        list = be.ListPatient();
        return list;
    }

    public List<String[]> find_patient(String CCCD) {
        List<String[]> list = null;
        list = be.FindPatient(CCCD);
        return list;
    }

    public void add_payaccount(String CCCD, int balance) {
        be.AddPayAccount(CCCD, balance);
    }

    public boolean check_admin() {
        return be.CheckAdmin();
    }

    public void create_admin(String username, String password) {
        be.CreateAdmin(username, encodeString(password));
    }

    public boolean login(String username, String password) {
        List<String[]> list = be.Login();
        if (username.equals(list.get(0)[0]) == true && password.equals(decodeString(list.get(0)[1])) == true) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String args[]) {
        System.out.print(be.InfoAdmin().get(0)[0]);
    }
}
