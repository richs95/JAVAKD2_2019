/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.*;
import model.Packet;
import network.KD2ClientListener;

/**
 *
 * @author Richs
 */
public class KD2Client {
    
    //Our client object.
    static Client client;
    //add client Listener
    private KD2ClientListener kd2ClientListener;
    //IP to connect to.
    static String ip = "localhost";
    //Ports to connect on.
    static int tcpPort = 27960, udpPort = 27960;
        
    public KD2Client() throws Exception {

        System.out.println("Client-> Connecting to the server...");
        //Create the client.
        client = new Client();
        
        //Add a listener
        kd2ClientListener = new KD2ClientListener();
        client.addListener(kd2ClientListener);
        
        //Register the packet object.
        client.getKryo().register(Packet.class);

        //Start the client
        client.start();
        //The client MUST be started before connecting can take place.

        //Connect to the server - wait 5000ms before failing.
        client.connect(5000, ip, tcpPort, udpPort);
        

        
        System.out.println("Client-> Connected! The client program is now waiting for a packet...\n");
    }
    
    public void configureAndStartClient() throws Exception {
            new KD2Client();
    }
}
