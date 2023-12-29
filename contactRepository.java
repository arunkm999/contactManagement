package com.arun;
import java.util.*;
import java.sql.*;

public class contactRepository {

     List<contactInformation>  allContacts = new ArrayList<contactInformation>();
    Connection con = null;

    contactRepository(){


    }

    public void openDbConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arun", "root", "Arunzoho@123");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void closeDbConnection(){

        try {
            con.close();
        }
    catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



    public List<contactInformation> getAllContacts(){

        try {
            openDbConnection();

            PreparedStatement stmt = con.prepareStatement("select * from contactInfo");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                contactInformation cont1 = new contactInformation();
                cont1.setContactName(rs.getString(1));
                cont1.setContactNumber(rs.getString(2));
                cont1.setContactAddress(rs.getString(3));
                cont1.setAlternateContact(rs.getString(4));

                allContacts.add(cont1);

            }

            closeDbConnection();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return allContacts;
    }

    public contactInformation getContact(String contactName){

        try {
            openDbConnection();

            PreparedStatement stmt = con.prepareStatement("select * from contactInfo where contactname=?");
            stmt.setString(1,contactName);
            ResultSet rs = stmt.executeQuery();
            contactInformation cont1 = new contactInformation();
            while (rs.next()) {


                cont1.setContactName(rs.getString(1));
                cont1.setContactNumber(rs.getString(2));
                cont1.setContactAddress(rs.getString(3));
                cont1.setAlternateContact(rs.getString(4));


            }

            closeDbConnection();
            return cont1;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new contactInformation();

    }


    public String addContact(contactInformation info){

        try {
            openDbConnection();

            PreparedStatement stmt = con.prepareStatement("insert into contactInfo values (?,?,?,?)");
            stmt.setString(1,info.getContactName());
            stmt.setString(2,info.getContactNumber());
            stmt.setString(3,info.getContactAddress());
            stmt.setString(4,info.getAlternateContact());

            stmt.execute();

            closeDbConnection();


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //allContacts.add(info);
        return "Success";
    }

    public String updateContact(contactInformation info){

        try {
            openDbConnection();

            PreparedStatement stmt = con.prepareStatement("update contactInfo set contactNumber=?,contactAddress=?,alternateContact=? where contactName=?");

            stmt.setString(1,info.getContactNumber());
            stmt.setString(2,info.getContactAddress());
            stmt.setString(3,info.getAlternateContact());
            stmt.setString(4,info.getContactName());

            stmt.execute();

            closeDbConnection();


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //allContacts.add(info);
        return "Update Success";
    }

    public String deleteContact(String contactName){

        try {
            openDbConnection();

            PreparedStatement stmt = con.prepareStatement("delete from contactInfo where contactname=?");
            stmt.setString(1,contactName);
            stmt.execute();

            closeDbConnection();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Deleted";

    }


}
