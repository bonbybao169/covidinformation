package Payment.Main;

import Payment.Database.*;
import Payment.GUI.*;
import Payment.Controller.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class payment_main {

    static ServerSocket server;
    static List<ServerClientThread> clients = new ArrayList<ServerClientThread>();

    ;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Payment.GUI.CreateAdmin_UI.main(null);
            }
        });
        int portnumber = 4321;
        Socket client;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }
        try {
            server = new ServerSocket(portnumber);
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("ServerSocket is created " + server);
        while (true) {
            try {
                System.out.println("Waiting for connect request...");
                client = server.accept();
                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
                ServerClientThread ClientThread = new ServerClientThread(client);
                clients.add(ClientThread);
                new Thread(ClientThread).start();
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }
    }
}

class ServerClientThread implements Runnable {

    static Payment_Backend be = new Payment_Backend();
    static payment_controller pc = new payment_controller();
    Socket client;
    DataInputStream clientin;
    DataOutputStream clientout;
    String name;

    ServerClientThread(Socket Client) {
        client = Client;
    }

    public void run() {
        try {
            clientin = new DataInputStream(client.getInputStream());
            clientout = new DataOutputStream(client.getOutputStream());
            String msgFromClient = "";
            msgFromClient = clientin.readUTF();
            msgFromClient = pc.decodeString(msgFromClient);
            System.out.print(msgFromClient);
            String[] words = msgFromClient.split(" ");
            if (words[0] == "addpayment") {

                payment_main.clients.get(payment_main.clients.indexOf(this)).send("1");

            }
            if (words[0] == "addaccount") {
                //if(be.FindPatient(words[1]))
                be.AddPayAccount(words[1], Integer.parseInt(words[2]));
                Thread.sleep(100);

            }
            payment_main.clients.remove(this);
            client.close();
        } catch (Exception ex) {
            System.out.println(ex);
            payment_main.clients.remove(this);
        }
    }

    public void send(String msg) {
        try {
            clientout.writeUTF(msg);
        } catch (Exception ex) {
        }
    }

    public void send_to_everyone(String msg) {
        for (int i = 0; i < payment_main.clients.size(); i++) {
            if (i != payment_main.clients.indexOf(this)) {
                payment_main.clients.get(i).send(msg);
            }
        }
    }
}
