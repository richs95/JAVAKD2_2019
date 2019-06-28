/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.util.ArrayList;
import model.Packet;
import model.Student;

/**
 *
 * @author Richs
 */
public class KD2ClientListener extends Listener{

    KD2ClientListener() {
        
    }
    
    @Override
    public void connected(Connection connection){
        System.out.println("ClientListener->Someone has connected!");
    }

    @Override
    public void disconnected(Connection connection){
        System.out.println("ClientListener->Someone disconnected!");
    }

    @Override
    public void received(Connection c, Object o){
        if(o instanceof Packet.StudentArray01){
            System.out.println("ClientListener->Packet received");
        }
    }
    public ArrayList<Student> fillGrades(ArrayList<Student> students){ 
      ArrayList<Student> studentGrades = new ArrayList<>();
      return studentGrades;
    }

}
