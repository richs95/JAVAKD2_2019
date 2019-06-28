/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Richs
 */
public class Packet {
    
    //this is packet class. Everything in this object can be sent over the network
    public String message;

    ArrayList<Student> students = null;
	
    public static class StudentArray01{
	public static ArrayList<Student> students;
    }

}
