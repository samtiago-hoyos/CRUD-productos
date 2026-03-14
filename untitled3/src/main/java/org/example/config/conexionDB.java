package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDB {

    private static final String URL="jdbc:mysql://localhost:3306/crud_productos";
    private static final String USER="root";
    private static final String PASSWORD="";

    public static Connection conectar(){

        try{

            return DriverManager.getConnection(URL,USER,PASSWORD);

        }catch(Exception e){

            e.printStackTrace();
            return null;

        }

    }

}