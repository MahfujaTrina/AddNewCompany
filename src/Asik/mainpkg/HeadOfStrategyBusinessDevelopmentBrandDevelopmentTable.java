
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author rttit
 */
public class HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable implements Serializable {
    private String helicopterName;
    private String helicopterBrand;
    private String price;
    private LocalDate date;

    public HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable(String helicopterName, String helicopterBrand, String price, LocalDate date) {
        this.helicopterName = helicopterName;
        this.helicopterBrand = helicopterBrand;
        this.price = price;
        this.date = date;
    }

    public String getHelicopterName() {
        return helicopterName;
    }

    public void setHelicopterName(String helicopterName) {
        this.helicopterName = helicopterName;
    }

    public String getHelicopterBrand() {
        return helicopterBrand;
    }

    public void setHelicopterBrand(String helicopterBrand) {
        this.helicopterBrand = helicopterBrand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable{" + "helicopterName=" + helicopterName + ", helicopterBrand=" + helicopterBrand + ", price=" + price + ", date=" + date + '}';
    }
    
    
    
}
