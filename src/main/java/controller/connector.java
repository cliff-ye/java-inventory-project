/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Clifford
 */
public class connector {
    
    public static void main(String[] args)
    {
        String url="jdbc:mysql://localhost:3306/stockdatabase";
        String user="root";
        String pass="Cliff123";
        
        try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,pass);
       
       String sql = "INSERT INTO `stockdatabase`.category`(`categoryName`) VALUES (?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,"Jen");
       
       
 
            System.out.println("Added SUCCESSFULLY!");
       
       
       
       
      
    
      }
    catch(Exception e){
         System.out.println("An error occured"+e.getMessage());
      }
    }
    }
    

