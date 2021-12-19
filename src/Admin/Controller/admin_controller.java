/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;

import Admin.Database.*;
import Admin.GUI.*;

public class admin_controller {
    static Admin_Backend be = new Admin_Backend();

    public void create_manager(String username,String password) {
        be.CreateManager(username,password);
    }
    public static void main(String args[]) {
    }
}
