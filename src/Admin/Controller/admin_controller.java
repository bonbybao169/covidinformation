/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;

import Admin.Database.*;
import Admin.GUI.*;
import Manager.Model.*;
import java.util.*;
public class admin_controller {
    static Admin_Backend be = new Admin_Backend();

    public void create_manager(String username,String password) {
        be.CreateManager(username,password);
    }
    public List<Manager> list_manager(){
        List<Manager> list = null;
        list = be.ListManager();
        return list;
    }
    public void lock_open_manager(String username,String state){
        System.out.println(username+" "+state);
        if(username!=null){
            if(state.equals("OPEN")||state==null)
                be.LockOrOpen(username,"LOCK");
            else if(state.equals("LOCK"))
                be.LockOrOpen(username,"OPEN");
        }
    }
    public static void main(String args[]) {
        //be.LockOrOpen("MN56789", "LOCK");
    }
}
