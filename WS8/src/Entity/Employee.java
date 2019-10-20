/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Mitu
 */
public class Employee {
    String code, name;
    int salary;
    double bonus;

    public Employee(String code, String name, int salary, double bonus) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
     
    public Object toObjects(){
        return new Object[]{code, name, salary, bonus};
    }
}
