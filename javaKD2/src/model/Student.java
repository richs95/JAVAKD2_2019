/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Richs
 */
public class Student {
    int id;
    String firstname;
    String lastname;
    int age;
    int grade;
    
    public Student() {
		
    }

    public Student(String firstname, String lastname, int age) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
	this.id = 0;
	this.grade = 0;
    }

    public Student(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.grade = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>=0) {
            this.id = id;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0) {
            this.age = age;
        }
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade>=0) {
            this.grade = grade;
        }
    }
    
    
}
