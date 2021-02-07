package sample;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class DiyetisyenPanelController implements Initializable {


    @FXML
    private AnchorPane Diyetisyen_panel;

    @FXML
    private AnchorPane D_pane_bilgi;

    @FXML
    private TableView<hasta> D_tableview_hasta_bilgi;

    @FXML
    private TableColumn<hasta, Integer> D_tableview_bilgi_id;

    @FXML
    private TableColumn<hasta, String> D_tableview_bilgi_ad;

    @FXML
    private TableColumn<hasta, String> D_tableview_bilgi_soyad;

    @FXML
    private TableColumn<hasta, Date> D_tableview_bilgi_dogum;

    @FXML
    private TableColumn<hasta, Integer> D_tableview_bilgi_boy;

    @FXML
    private TableColumn<hasta, Integer> D_tableview_bilgi_kilo;

    @FXML
    private TableColumn<hasta, String> D_tableview_bilgi_cinsiyet;

    @FXML
    private TableColumn<hasta, Integer> D_tableview_bilgi_tel;

    @FXML
    private TextField D_txt_id;

    @FXML
    private Button D_btn_bilgi_ekle;

    @FXML
    private Button D_btn_bilgi_sil;

    @FXML
    private Button D_btn_bilgi_guncelle;

    @FXML
    private TextField D_txt_boy;

    @FXML
    private TextField D_txt_soyad;

    @FXML
    private TextField D_txt_ad;

    @FXML
    private TextField D_txt_kilo;

    @FXML
    private TextField D_txt_cinsiyet;

    @FXML
    private TextField D_txt_dogum;

    @FXML
    private TextField D_txt_telefon;

    @FXML
    private TextField filterField_bilgi;

    @FXML
    private AnchorPane D_pane_menu;

    @FXML
    private TextField filterField_menu;

    @FXML
    private Button D_btn_menu_ekle;

    @FXML
    private Button D_btn_menu_sil;

    @FXML
    private Button D_btn_menu_guncelle;

    @FXML
    private AnchorPane D_pane_besin_deger;

    @FXML
    private TextField filterField_menu1;

    @FXML
    private AnchorPane D_pane_randevu;

    @FXML
    private TableView<randevu> D_tableview_randevu;

    @FXML
    private TableColumn<randevu, Integer> D_tableview_randevu_randevuId;

    @FXML
    private TableColumn<randevu, Integer> D_tableview_randevu_hastaId;

    @FXML
    private TableColumn<randevu, Integer> D_tableview_randevu_DiyetisyenId;

    @FXML
    private TableColumn<randevu, Date> D_tableview_randevu_tarih;

    @FXML
    private TextField filterField_bilgi1;

    @FXML
    private Button D_btn_randevu_ekle;

    @FXML
    private Button D_btn_randevu_sil;

    @FXML
    private Button D_btn_randevu_guncelle;

    @FXML
    private TextField D_txt_randevu_randevuId;

    @FXML
    private TextField D_txt_randevu_hastaId;

    @FXML
    private TextField D_txt_randevu_diyetisyenId;

    @FXML
    private TextField D_txt_randevu_tarih;

    @FXML
    private AnchorPane D_pane_hasta_ekle;

    @FXML
    private TableView<login> D_tableview_hasta_bilgi1;

    @FXML
    private TableColumn<login, Integer> D_tableview_bilgi_id1;

    @FXML
    private TableColumn<login, Integer> D_tableview_hasta_Tc;

    @FXML
    private TextField D_txt_id1;

    @FXML
    private Button D_btn_bilgi_ekle1;

    @FXML
    private TextField D_txt_boy1;

    @FXML
    private TextField D_txt_soyad1;

    @FXML
    private TextField D_txt_ad1;

    @FXML
    private TextField D_txt_kilo1;

    @FXML
    private TextField D_txt_cinsiyet1;

    @FXML
    private TextField D_txt_dogum1;

    @FXML
    private TextField D_txt_telefon1;

    @FXML
    private TextField filterField_bilgi2;


    @FXML
    private TextField D_txt_tc;
    @FXML
    private DatePicker date;
    @FXML
    private DatePicker date_randevu;
    @FXML
    private TableView<besindegerleri> D_tableview_besindeger;

    @FXML
    private TableColumn<besindegerleri, Integer> D_tableview_besinid;

    @FXML
    private TableColumn<besindegerleri, String> D_tableview_besinadi;

    @FXML
    private TableColumn<besindegerleri, Integer> D_tableview_kalori;

    @FXML
    private TableColumn<besindegerleri, Double> D_tableview_protein;

    @FXML
    private TableColumn<besindegerleri, Double> D_tableview_karbonhidrat;

    @FXML
    private TableColumn<besindegerleri, Double> D_tableview_yag;

    ObservableList<hasta> listM;
    ObservableList<hasta> dataList;
    ObservableList<login> ListN;
    ObservableList<login>  dataListN;
    ObservableList<besindegerleri> ListL;
    ObservableList<besindegerleri> dataListL;
    ObservableList<randevu> ListS;
    ObservableList<randevu> dataListS;
    int index=-1;



    public void DBilgiPaneShow() {
        D_pane_bilgi.setVisible(true);
        D_pane_besin_deger.setVisible(false);
        D_pane_randevu.setVisible(false);
        D_pane_hasta_ekle.setVisible(false);
    }


    public void DBesinDegerPaneShow() {
        D_pane_bilgi.setVisible(false);
        D_pane_besin_deger.setVisible(true);
        D_pane_randevu.setVisible(false);
        D_pane_hasta_ekle.setVisible(false);
    }

    public void DRandevuPaneShow() {
        D_pane_bilgi.setVisible(false);
        D_pane_besin_deger.setVisible(false);
        D_pane_randevu.setVisible(true);
        D_pane_hasta_ekle.setVisible(false);
    }
    public void DHastaEklePaneShow() {
        D_pane_bilgi.setVisible(false);

        D_pane_besin_deger.setVisible(false);
        D_pane_randevu.setVisible(false);
        D_pane_hasta_ekle.setVisible(true);
    }

    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;

    public void D_KullaniciEkle()
    {
        conn = MySqlConnect.ConnectDb();
        String sql="insert into hasta (HastaId,Ad,Soyad,DogumTarih,Boy,Kilo,Cinsiyet,Telefon) values (?,?,?,?,?,?,?,?)";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, D_txt_id1.getText());
            pst.setString(2, D_txt_ad1.getText());
            pst.setString(3, D_txt_soyad1.getText());
            pst.setString(4, String.valueOf(date.getValue()));
            pst.setString(5, D_txt_boy1.getText());
            pst.setString(6, D_txt_kilo1.getText());
            pst.setString(7, D_txt_cinsiyet1.getText());
            pst.setString(8, D_txt_telefon1.getText());


            pst.execute();
            JOptionPane.showMessageDialog(null,"Hasta Bilgileri Başarıyla kaydedildi");
            UpdateTable();
            search_hasta();


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }

    public void D_RandevuEkle()
    {
        conn = MySqlConnect.ConnectDb();
        String sql="insert into randevu (DiyetisyenId,HastaId,TarihSaat) values (1,?,?)";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, D_txt_randevu_hastaId.getText());
            pst.setString(2, String.valueOf(date_randevu.getValue()));



            pst.execute();
            JOptionPane.showMessageDialog(null,"Hasta Bilgileri Başarıyla kaydedildi");
            UpdateTable();



        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }



   @FXML
   void get (MouseEvent event) {

       index =D_tableview_hasta_bilgi.getSelectionModel().getSelectedIndex();

       if(index <= -1)
       {
           return;
       }
       D_txt_id.setText( D_tableview_bilgi_id.getCellData(index).toString());
       D_txt_ad.setText( D_tableview_bilgi_ad.getCellData(index));
       D_txt_soyad.setText(D_tableview_bilgi_soyad.getCellData(index));
       D_txt_dogum.setText(D_tableview_bilgi_dogum.getCellData(index).toString());
       D_txt_boy.setText( D_tableview_bilgi_boy.getCellData(index).toString());
       D_txt_kilo.setText( D_tableview_bilgi_kilo.getCellData(index).toString());
       D_txt_cinsiyet.setText( D_tableview_bilgi_cinsiyet.getCellData(index));
       D_txt_telefon.setText( D_tableview_bilgi_tel.getCellData(index).toString());

   }

    @FXML
    void get2 (MouseEvent event) {

        index =D_tableview_hasta_bilgi1.getSelectionModel().getSelectedIndex();

        if(index <= -1)
        {
            return;
        }
        D_txt_id1.setText( D_tableview_bilgi_id1.getCellData(index).toString());
        D_txt_tc.setText( D_tableview_hasta_Tc.getCellData(index).toString());


    }

    @FXML
    void get3 (MouseEvent event) {

        index =D_tableview_randevu.getSelectionModel().getSelectedIndex();

        if(index <= -1)
        {
            return;
        }
        D_txt_randevu_randevuId.setText( D_tableview_randevu_randevuId.getCellData(index).toString());
        D_txt_randevu_diyetisyenId.setText( D_tableview_randevu_DiyetisyenId.getCellData(index).toString());
        D_txt_randevu_hastaId.setText( D_tableview_randevu_hastaId.getCellData(index).toString());



    }



    public void Edit()
    {
        try{
            conn=MySqlConnect.ConnectDb();
            String value1=D_txt_id.getText();
            String value2=D_txt_ad.getText();
            String value3=D_txt_soyad.getText();
            String value4=D_txt_dogum.getText();
            String value5=D_txt_boy.getText();
            String value6=D_txt_kilo.getText();
            String value7=D_txt_cinsiyet.getText();
            String value8=D_txt_telefon.getText();

            String sql ="update hasta set HastaId='"+value1+"',Ad='"+value2+"',Soyad='"+value3+"',DogumTarih='"+value4+"',Boy='"+value5+"',Kilo='"+value6+"',Cinsiyet='"+value7+"',Telefon='"+value8+"' where HastaId='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Güncellendi");
            UpdateTable();
            search_hasta();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }

    public void RandevuEdit()
    {
        try{
            conn=MySqlConnect.ConnectDb();
            String value1=D_txt_randevu_randevuId.getText();
            String value2=D_txt_randevu_diyetisyenId.getText();
            String value3=D_txt_randevu_hastaId.getText();
            String value4=date_randevu.getValue().toString();


            String sql ="update randevu set RandevuId='"+value1+"',DiyetisyenId='"+value2+"',HastaId='"+value3+"',TarihSaat='"+value4+"' where RandevuId='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Güncellendi");
            UpdateTable();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }
    public void Delete()
    {
        conn=MySqlConnect.ConnectDb();
        String sql ="delete from hasta where HastaId=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,D_txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Silindi");
            UpdateTable();
            search_hasta();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }
    public void RandevuDelete()
    {
        conn=MySqlConnect.ConnectDb();
        String sql ="delete from randevu where RandevuId=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,D_txt_randevu_randevuId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Silindi");
            UpdateTable();


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }

    public void UpdateTable()
    {
        D_tableview_bilgi_id.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("HastaId"));
        D_tableview_bilgi_ad.setCellValueFactory(new PropertyValueFactory<hasta,String>("Ad"));
        D_tableview_bilgi_soyad.setCellValueFactory(new PropertyValueFactory<hasta,String>("Soyad"));
        D_tableview_bilgi_dogum.setCellValueFactory(new PropertyValueFactory<hasta,Date>("DogumTarih"));
        D_tableview_bilgi_boy.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Boy"));
        D_tableview_bilgi_kilo.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Kilo"));
        D_tableview_bilgi_cinsiyet.setCellValueFactory(new PropertyValueFactory<hasta,String>("Cinsiyet"));
        D_tableview_bilgi_tel.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Telefon"));
        listM=MySqlConnect.getDatahasta();
        D_tableview_hasta_bilgi.setItems(listM);

        D_tableview_besinid.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("BesinId"));
        D_tableview_besinadi.setCellValueFactory(new PropertyValueFactory<besindegerleri,String>("BesinAdi"));
        D_tableview_kalori.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("Kalori"));
        D_tableview_protein.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Protein"));
        D_tableview_yag.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Yag"));
        D_tableview_karbonhidrat.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Karbonhidrat"));
        ListL=MySqlConnect.getDatabesindegerleri();
        D_tableview_besindeger.setItems(ListL);

        D_tableview_bilgi_id1.setCellValueFactory(new PropertyValueFactory<login,Integer>("KullaniciId"));
        D_tableview_hasta_Tc.setCellValueFactory(new PropertyValueFactory<login,Integer>("KullaniciTc"));
        ListN=MySqlConnect.getDatalogin();
        D_tableview_hasta_bilgi1.setItems(ListN);

        D_tableview_randevu_randevuId.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("RandevuId"));
        D_tableview_randevu_DiyetisyenId.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("DiyetisyenId"));
        D_tableview_randevu_hastaId.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("HastaId"));
        D_tableview_randevu_tarih.setCellValueFactory(new PropertyValueFactory<randevu,Date>("TarihSaat"));
        ListS=MySqlConnect.getDatarandevu();
        D_tableview_randevu.setItems(ListS);




    }

    @FXML
    void search_hasta(){
        D_tableview_bilgi_id.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("HastaId"));
        D_tableview_bilgi_ad.setCellValueFactory(new PropertyValueFactory<hasta,String>("Ad"));
        D_tableview_bilgi_soyad.setCellValueFactory(new PropertyValueFactory<hasta,String>("Soyad"));
        D_tableview_bilgi_dogum.setCellValueFactory(new PropertyValueFactory<hasta,Date>("DogumTarih"));
        D_tableview_bilgi_boy.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Boy"));
        D_tableview_bilgi_kilo.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Kilo"));
        D_tableview_bilgi_cinsiyet.setCellValueFactory(new PropertyValueFactory<hasta,String>("Cinsiyet"));
        D_tableview_bilgi_tel.setCellValueFactory(new PropertyValueFactory<hasta,Integer>("Telefon"));

        dataList=MySqlConnect.getDatahasta();
        D_tableview_hasta_bilgi.setItems(dataList);
        FilteredList<hasta> filteredData=new FilteredList<>(dataList,b -> true);
    filterField_bilgi.textProperty().addListener((observable,oldValue,newValue) -> {
    filteredData.setPredicate(hasta -> {
                if(newValue==null || newValue.isEmpty()){
                    return  true;
                }
                String lowerCaseFilter =newValue.toLowerCase();

                if(hasta.getAd().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return  true;
                }else if(hasta.getSoyad().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else
                    return false;
    });
    });
        SortedList<hasta> sortedData =new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(D_tableview_hasta_bilgi.comparatorProperty());
        D_tableview_hasta_bilgi.setItems(sortedData);
    }

    @FXML
    void search_besindeger(){
        D_tableview_besinid.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("BesinId"));
        D_tableview_besinadi.setCellValueFactory(new PropertyValueFactory<besindegerleri,String>("BesinAdi"));
        D_tableview_kalori.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("Kalori"));
        D_tableview_protein.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Protein"));
        D_tableview_yag.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Yag"));
        D_tableview_karbonhidrat.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Karbonhidrat"));

        dataListL=MySqlConnect.getDatabesindegerleri();
        D_tableview_besindeger.setItems(dataListL);
        FilteredList<besindegerleri> filteredData=new FilteredList<>(dataListL,b -> true);
        filterField_menu1.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(besindegerleri -> {
                if(newValue==null || newValue.isEmpty()) {
                    return true;
                }String lowerCaseFilter =newValue.toLowerCase();

                if(besindegerleri.getBesinAdi().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return  true;


                }else
                    return false;
            });
        });
        SortedList<besindegerleri> sortedData =new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(D_tableview_besindeger.comparatorProperty());
        D_tableview_besindeger.setItems(sortedData);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateTable();
        search_hasta();
        search_besindeger();



    }
}
