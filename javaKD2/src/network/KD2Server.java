/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import database.ActionsWithDB;
import java.sql.SQLException;
import java.util.ArrayList;
import javasem04.activity.Person;
import javasem04.activity.PersonList;
import model.Packet;
import model.Student;
import static network.KD2Server.server;

/**
 *
 * @author Richs
 */
public class KD2Server {
    //server object
    static Server server;
    //ports to listen to
    static int udpPort  = 27960, tcpPort = 27960;
    //student array
    static ArrayList<Student> students;

    public KD2Server() throws Exception{
        //create server
        server = new Server();

        //register a packet class
        server.getKryo().register(Packet.class);
        //we can only send object as packets if they are registered

        //bind to server
        server.bind(tcpPort, udpPort);

        //start the server
        server.start();

        //add server listener
        KD2ServerListener serverListener;

        System.out.println("Server is working!");
    }
    
    public void configureAndStartServer() throws Exception {
            new KD2Server();
    }
    
    public void insertStudents(){

//        students.add(new Student("Jon","Sur",19));
//        students.add(new Student("Logan","Surny",20));
//        students.add(new Student("First","Name",22));

        students = new ArrayList<Student>();

        ActionsWithDB database = new ActionsWithDB();

        PersonList list = new PersonList("ITB", 30);	
            for(Person person : list) {
                
                students.add(new Student(person.getName(), person.getComment(), person.getAge()));
          
            }
            
            database.createAndInsertDB(students);
    }
    
    public static void getAndSendStudents(Connection c) {
        ActionsWithDB database = new ActionsWithDB();
        Packet.StudentArray01.students = database.selectAllStudentsSQL();

        c.sendTCP(Packet.StudentArray01.students);
    }

}
