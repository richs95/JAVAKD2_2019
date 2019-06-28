/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.ActionsWithDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;
import network.KD2Client;
import network.KD2Server;

/**
 *
 * @author Richs
 */
public class JavaKD2 {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Student> students;

    public static void main(String[] args) throws Exception {
        
        // TODO code application logic here
        ActionsWithDB.connect();
        
        ActionsWithDB.createDB();
        
        students = ActionsWithDB.selectAllStudentsSQL();
        
        ActionsWithDB.createAndInsertDB(students);
        
        KD2Server server = new KD2Server();
        try {
            KD2Client client = new KD2Client();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
