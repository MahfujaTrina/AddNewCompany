/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author rttit
 */
public class HeadOfSupplyChainOptimizeInventoryTable {
    private String spare_Paerts;
    private String eqquipment;
    private String supplies;

    public HeadOfSupplyChainOptimizeInventoryTable(String spare_Paerts, String eqquipment, String supplies) {
        this.spare_Paerts = spare_Paerts;
        this.eqquipment = eqquipment;
        this.supplies = supplies;
    }

    public String getSpare_Paerts() {
        return spare_Paerts;
    }

    public void setSpare_Paerts(String spare_Paerts) {
        this.spare_Paerts = spare_Paerts;
    }

    public String getEqquipment() {
        return eqquipment;
    }

    public void setEqquipment(String eqquipment) {
        this.eqquipment = eqquipment;
    }

    public String getSupplies() {
        return supplies;
    }

    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }

    @Override
    public String toString() {
        return "HeadOfSupplyChainOptimizeInventoryTable{" + "spare_Paerts=" + spare_Paerts + ", eqquipment=" + eqquipment + ", supplies=" + supplies + '}';
    }
    
    
    
    
}
