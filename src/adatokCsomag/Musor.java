/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatokCsomag;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axmart
 */
public class Musor {
   
   private int id;
   private String elnevezes;
   private int musorido;
   private String kozszolgalati;
   private String elofizeteses ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public int getMusorido() {
        return musorido;
    }

    public void setMusorido(int musorido) {
        this.musorido = musorido;
    }

    public String getKozszolgalati() {
        return kozszolgalati;
    }

    public void setKozszolgalati(String kozszolgalati) {
        this.kozszolgalati = kozszolgalati;
    }

    public String getElofizeteses() {
        return elofizeteses;
    }

    public void setElofizeteses(String elofizeteses) {
        this.elofizeteses = elofizeteses;
    }

    public Musor(int id, String elnevezes, int musorido, String kozszolgalati, String elofizeteses) {
        this.id = id;
        this.elnevezes = elnevezes;
        this.musorido = musorido;
        this.kozszolgalati = kozszolgalati;
        this.elofizeteses = elofizeteses;
    }
    
    
    public static ArrayList<Musor> Beolvasas(){
        String host = "jdbc:mysql://localhost:3306/tvdolgozat";
        String username = "root";
        String password = "";
        ArrayList<Musor> output = new ArrayList<>(); 
        try {
            Connection con = DriverManager.getConnection(host,username,password);
            java.sql.Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("select * from medium");
            //ResultSet rs = con.createStatement().executeQuery("select * from medium");
            while (rs.next()) {
                //Logger.getLogger(ADATOK.class.getName()).log(Level.SEVERE," talaltam valamit ", " talaltam valamit ");
                output.add(new Musor(rs.getInt("id"),rs.getString("elnevezes"),rs.getInt("musorido"),rs.getString("kozszolgalati"),rs.getString("elofizeteses")));
                
            }
            sta.close();
            con.close();
            
            
            
        } catch (Exception e) {
            
            Logger.getLogger(ADATOK.class.getName()).log(Level.SEVERE, e+" nem sikerult a betoltes", e+" nem sikerult a betoltes");
            
        }
        
        return output;
        
        
    }
    
    public static void Modositas(Musor musor){
        String host = "jdbc:mysql://localhost:3306/tvdolgozat";
        String username = "root";
        String password = "";
        String sql = "";
        try {
            Connection con = DriverManager.getConnection(host,username,password);
            java.sql.Statement sta = con.createStatement();
            sql = "update medium set elnevezes = '"+musor.getElnevezes()+ "', musorido = "+ musor.getMusorido()+", kozszolgalati = '"+musor.getKozszolgalati()+"', elofizeteses = '"+musor.getElofizeteses()+ "' where id = "+ musor.getId();
            sta.executeUpdate(sql);
            sta.close();
            con.close();
            
            
            
        } catch (Exception e) {
            
            Logger.getLogger(ADATOK.class.getName()).log(Level.SEVERE, e+" nem sikerult modositas "+ sql , e+" nem sikerult a modositas");
            
        }
        
        
        
    }
    
    public static void HozzaAdas(Musor musor){
        String host = "jdbc:mysql://localhost:3306/tvdolgozat";
        String username = "root";
        String password = "";
        String sql = "";
        try {
            Connection con = DriverManager.getConnection(host,username,password);
            java.sql.Statement sta = con.createStatement();
            sql = "insert into medium(elnevezes,musorido,kozszolgalati,elofizeteses) values('"+musor.getElnevezes()+ "',"+ musor.getMusorido()+",'"+musor.getKozszolgalati()+"','"+musor.getElofizeteses()+ "')";
            sta.executeUpdate(sql);
            sta.close();
            con.close();
            
            
            
        } catch (Exception e) {
            
            Logger.getLogger(ADATOK.class.getName()).log(Level.SEVERE, e+" nem sikerult a hozzadas "+ sql , e+" nem sikerult a hozzadas");
            
        }
        
        
        
    }
    
    
    
}
