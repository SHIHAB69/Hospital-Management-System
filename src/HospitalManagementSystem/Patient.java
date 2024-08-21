package HospitalManagementSystem;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
   private Scanner scanner;

   public  Patient(Connection connection, Scanner scanner) {
    this.connection = connection;
    this.scanner = scanner;
   }

   public void addPatient(){
       System.out.print("Enter Patient Name: ");
       String name  = scanner.next();
       System.out.print("Enter Patient Age: ");
       int age = scanner.nextInt();
       System.out.print("Enter Patient Gender: ");
       String gender = scanner.next();

       try{

           String queery = "INSERT INTO patients(name,age,gender) VALUES(?, ? ,?)";
           PreparedStatement preparedStatement = connection.prepareStatement(queery);
           preparedStatement.setString(1, name);
           preparedStatement.setInt(2, age);
           preparedStatement.setString(3, gender);

           int affectedRows = preparedStatement.executeUpdate();
           if (affectedRows>0){
               System.out.println("Patient added successfully.");
           }else{
               System.out.println("Failed to add patient");
           }


       }catch (SQLException e ){
           e.printStackTrace();
       }

   }

   public void viewPatient(){
       String query = "select * from patients";

       try{
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("+--------+--------------+--------+---------+");
           System.out.println("| ID     | Name         | Age    | Gender   |");
           System.out.println("+--------+--------------+--------+---------+");
           while (resultSet.next()){
               int id  = resultSet.getInt("id");
               String name = resultSet.getString("name");
               String age = resultSet.getString("age");
               String gender  = resultSet.getString("gender");
               System.out.printf("|%-12s|%-14s|%-8s|%-10s");
           System.out.println("+--------+--------------+--------+---------+");
           }

       }catch (SQLException e){
           e.printStackTrace();
       }
   }

}
