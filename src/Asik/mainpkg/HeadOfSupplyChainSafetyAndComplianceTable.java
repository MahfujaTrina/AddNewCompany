/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author rttit
 */
public class HeadOfSupplyChainSafetyAndComplianceTable implements Serializable {
    private String name;
    private int number;
    private String email;
    private String safety;

    public HeadOfSupplyChainSafetyAndComplianceTable(String name, int number, String email, String safety) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.safety = safety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    @Override
    public String toString() {
        return "HeadOfSupplyChainSafetyAndComplianceTable{" + "name=" + name + ", number=" + number + ", email=" + email + ", safety=" + safety + '}';
    }
    
    
    
}
