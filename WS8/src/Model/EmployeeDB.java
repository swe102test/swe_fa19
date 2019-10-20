/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Entity.Employee;
import model.DBContext;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mitu
 */
public class EmployeeDB {
    DBContext db;
    Connection con;
    
    public EmployeeDB(){
        db = new DBContext();
        try{
            con = db.getConnection();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Employee> getAllEmp(){
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "select * from Draft";
        try{
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Employee(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public boolean existedEmp(String code){
        String sql = "select * from Draft where Code=?";
        try{
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public ArrayList<Employee> sort (){
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "select * from Draft order by Salary asc";
        try{
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               list.add(new Employee(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public void add(Employee em){
        
        String sql = "insert into Draft(Code, Name, Salary, Bonus) values(?, ?, ?, ?)";
        try{
            PreparedStatement st  = con.prepareStatement(sql);
            st.setString(1, em.getCode());
            st.setString(2, em.getName());
            st.setInt(3, em.getSalary());
            st.setDouble(4, em.getBonus());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Employee> getEmpbyCode(String Code){
        ArrayList<Employee> list = new ArrayList<>();
        String sql = null;
        PreparedStatement st = null;
        try{
            sql = "select * from Draft where Code like '%'+?+'%'";
            st = con.prepareStatement(sql);
            st.setString(1, Code);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Employee(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
    
}