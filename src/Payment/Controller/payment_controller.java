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
    public static void main(String args[]) {
        
    }
}