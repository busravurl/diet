package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;


public class MySqlConnect {
    Connection conn=null;
    public static Connection ConnectDb()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/diyetisyen","root","123456");
            return conn;



        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;

        }

    }

    public static ObservableList<hasta> getDatahasta(){
        Connection conn=ConnectDb();
        ObservableList<hasta> list= FXCollections.observableArrayList();
        try{
            PreparedStatement ps =conn.prepareStatement("select * from hasta");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new hasta (Integer.parseInt(rs.getString("HastaId")),Integer.parseInt(rs.getString("Boy")),Integer.parseInt(rs.getString("Kilo")),Integer.parseInt(rs.getString("Telefon")),rs.getString("Ad"),rs.getString("Soyad"),rs.getString("Cinsiyet"), Date.valueOf(rs.getString("DogumTarih"))));

            }

        }catch (Exception e)
        {

        }
        return list;
    }

    public static ObservableList<login> getDatalogin(){
        Connection conn=ConnectDb();
        ObservableList<login> list2= FXCollections.observableArrayList();
        try{
            PreparedStatement ps =conn.prepareStatement("select KullaniciId,KullaniciTc from login");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list2.add(new login (Integer.parseInt(rs.getString("KullaniciId")),Integer.parseInt(rs.getString("KullaniciTc"))));

            }

        }catch (Exception e)
        {

        }
        return list2;
    }

    public static ObservableList<besindegerleri> getDatabesindegerleri(){
        Connection conn=ConnectDb();
        ObservableList<besindegerleri> list2= FXCollections.observableArrayList();
        try{
            PreparedStatement ps =conn.prepareStatement("select * from besindegerleri ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list2.add(new besindegerleri (Integer.parseInt(rs.getString("BesinId")),Integer.parseInt(rs.getString("Kalori")),rs.getString("BesinAdi"),Double.valueOf(rs.getString("Protein")),Double.valueOf(rs.getString("Yag")),Double.valueOf(rs.getString("Karbonhidrat"))));

            }

        }catch (Exception e)
        {

        }
        return list2;
    }

    public static ObservableList<randevu> getDatarandevu(){
        Connection conn=ConnectDb();
        ObservableList<randevu> list= FXCollections.observableArrayList();
        try{
            PreparedStatement ps =conn.prepareStatement("select * from randevu");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new randevu (Integer.parseInt(rs.getString("RandevuId")),Integer.parseInt(rs.getString("DiyetisyenId")),Integer.parseInt(rs.getString("HastaId")),Date.valueOf(rs.getString("TarihSaat"))));

            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);

        }
        return list;
    }
}
