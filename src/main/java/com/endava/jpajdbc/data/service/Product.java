package com.endava.jpajdbc.data.service;

import java.sql.*;

public class Product {


    public void FindProductsByName(String product_name){
        try {

            long startTime=System.nanoTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin*");

            Statement statement = conn.createStatement();

            String SQL = "SELECT * FROM PRODUCTS WHERE product_name = '"+product_name+"'";
            ResultSet rs = statement.executeQuery(SQL);

            long stopTime=System.nanoTime();

            while (rs.next()) {
                System.out.println(rs.getString("product_name")+" " + rs.getString("product_line"));
            }

            System.out.println(stopTime-startTime);

            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }
    public void updateProductName(String retailer_country){
        try {

            long startTime=System.nanoTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin*");

            Statement statement = conn.createStatement();

            String SQL = "UPDATE PRODUCTS SET retailer_country='United States of America' WHERE retailer_country = '"+retailer_country+"'";
            statement.executeUpdate(SQL);

            long stopTime=System.nanoTime();

            System.out.println(stopTime-startTime);
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }


    public void deleteProductByName(String product_name){
        try {

            long starTime=System.nanoTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin*");

            Statement statement = conn.createStatement();

            String SQL = "DELETE FROM PRODUCTS WHERE product_name = '"+product_name+"'";
            statement.executeUpdate(SQL);

            long stopTime=System.nanoTime();

            System.out.println(stopTime-starTime);
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }



    }

    public void deleteProductById(int id)
    {
        try {
            long startTime=System.nanoTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin*");

            // Statement statement = conn.createStatement();

            PreparedStatement preparedStatement=conn.prepareStatement("DELETE FROM PRODUCTS WHERE ID=?"+id);
            preparedStatement.setInt(1,4);
            preparedStatement.execute();

            long stopTime=System.nanoTime();
            System.out.println(stopTime-startTime);
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public void listAllProducts() {
        try {
            long startTime=System.nanoTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin*");

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM PRODUCTS");

            long stopTime=System.nanoTime();


            while (rs.next()) {
                System.out.println(rs.getString("product_name"));
            }

            System.out.println(stopTime-startTime);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Product product=new Product();
        //  product.listAllProducts();
        //  product.deleteProductById(4);
        //  product.deleteProductByName("Star Gazer 2");
        //  product.updateProductName("USA");
        product.FindProductsByName("Star Dome");
    }
}
