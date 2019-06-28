/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.KD2Server;
import model.Packet;
import model.Student;

/**
 *
 * @author Richs
 */
public class KD2ServerListener extends Listener{
    private ArrayList<Connection> allConnection = new ArrayList<>();


    public KD2ServerListener(){
		
    }
    //This is run when connection is recieved
    public void connected(Connection c){
        try {
            allConnection.add(c);

            System.out.println("Recieved a connection from " + c.getRemoteAddressTCP().getHostString());
            //create a message packet
            Packet packetMessage = new Packet();
            
            //assign the message text
            packetMessage.message = "Hello! You connected: "+new Date().toString();
            
            KD2Server server = new KD2Server();
            server.getAndSendStudents(c);
            
            
            //send message
            c.sendTCP(packetMessage);
        } catch (Exception ex) {
            Logger.getLogger(KD2ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //this is run when we recieve a packet.
    public void recieved(Connection c, Object o){

        if (o instanceof Packet) {
            Packet.StudentArray01 p = (Packet.StudentArray01) o;
            int studentCount = 0;
            int avGrade = 0;
            for(Student student : p.students) {
                    avGrade = avGrade + student.getGrade();
                    studentCount++;
            }
            System.out.println("Videja atzime: "+(avGrade/studentCount));

        }
    }
}
