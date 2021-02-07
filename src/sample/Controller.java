package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {




    @FXML
    private AnchorPane pane_giris;


    @FXML
    private Button btn_giris;

    @FXML
    private TextField txt_tc;

    @FXML
    private TextField txt_sifre;

    @FXML
    private AnchorPane pane_kayit;

    @FXML
    private TextField txt_ad_kayit;

    @FXML
    private TextField txt_tc_kayit;

    @FXML
    private TextField txt_sifre_kayit;

    @FXML
    private Button btn_kayit;


    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;


    public void GirisPaneShow() {
        pane_giris.setVisible(true);
        pane_kayit.setVisible(false);
    }

    public void KayitOlPaneShow() {
        pane_giris.setVisible(false);
        pane_kayit.setVisible(true);
    }

    String tc ="1234567";
    String sifre = "diyetisyen";


    public void girisYap() {
    if(tc.equals(txt_tc.getText()) && sifre.equals(txt_sifre.getText())){
        btn_giris.getScene().getWindow().hide();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DiyetisyenPanel.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e);
        }

    }
    else{
        conn = MySqlConnect.ConnectDb();
        String sql= "Select * from login where KullaniciTc = ? and Sifre = ?";

        try {
            pst =conn.prepareStatement(sql);
            pst.setString(1, txt_tc.getText());
            pst.setString(2, txt_sifre.getText());
            rs = pst.executeQuery();

            if(rs.next()){
                btn_giris.getScene().getWindow().hide();
                Parent root= FXMLLoader.load(getClass().getResource("KullaniciPanel.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();

            }else
                JOptionPane.showMessageDialog(null,"TC veya şifre hatalı girdiniz");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    }

    public void KullaniciEkle()
    {
        conn = MySqlConnect.ConnectDb();
        String sql="insert into login (KullaniciTc,Sifre,KullaniciTuru) values (?,?,1)";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, txt_tc_kayit.getText());
            pst.setString(2, txt_sifre_kayit.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null,"Hasta Bilgileri Başarıyla kaydedildi");


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
