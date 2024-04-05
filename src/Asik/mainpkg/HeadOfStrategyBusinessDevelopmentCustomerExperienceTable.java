/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author rttit
 */
public class HeadOfStrategyBusinessDevelopmentCustomerExperienceTable {
    
    private String customerName;
    private String age;
    private String gender;
    private String expriences;

    public HeadOfStrategyBusinessDevelopmentCustomerExperienceTable(String customerName, String age, String gender, String expriences) {
        this.customerName = customerName;
        this.age = age;
        this.gender = gender;
        this.expriences = expriences;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExpriences() {
        return expriences;
    }

    public void setExpriences(String expriences) {
        this.expriences = expriences;
    }

    @Override
    public String toString() {
        return "HeadOfStrategyBusinessDevelopmentCustomerExperienceTable{" + "customerName=" + customerName + ", age=" + age + ", gender=" + gender + ", expriences=" + expriences + '}';
    }
   
    
}
