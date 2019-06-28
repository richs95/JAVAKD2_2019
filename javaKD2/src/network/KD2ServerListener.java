/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.util.Date;
import model.Packet;

/**
 *
 * @author Richs
 */
public class KD2ServerListener extends Listener{
    
    //This is run when connection is recieved
    @Override
    public void connected(Connection c){
        System.out.println("Recieved a connection from " + c.getRemoteAddressTCP().getHostString());
        //create a message packet
        Packet packetMessage = new Packet();
        
        //assign the message text
        packetMessage.message = "Hello! You connected: "+new Date().toString();

        //KD2Server kd2Server = new KD2Server();
	//kd2server.getAndSendStudents(c);

        
        //send message
        c.sendTCP(packetMessage);
        
    }
    
    //this is run when we recieve a packet.
    public void recieved(Connection c, Object p){
        //for now, we do not expect to recieve any packets
    }
}
