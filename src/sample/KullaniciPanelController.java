package sample;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;


public class KullaniciPanelController implements Initializable{


    @FXML
    private AnchorPane Kullanici_panel;

    @FXML
    private AnchorPane pane_hasta_bilgilerim;

    @FXML
    private TextField txt_hasta_ad;

    @FXML
    private TextField txt_hasta_soyad;

    @FXML
    private TextField txt_hasta_dogumtarihi;

    @FXML
    private TextField txt_hasta_boy;

    @FXML
    private TextField txt_hasta_kilo;

    @FXML
    private TextField txt_hasta_cinsiyet;

    @FXML
    private TextField txt_hasta_telefon;

    @FXML
    private Button btn_kullanici_bilgi_guncelle;

    @FXML
    private TextField txt_hasta_tc;


    @FXML
    private AnchorPane pane_hasta_randevu;



    @FXML
    private AnchorPane pane_hasta_besindeger;
    @FXML
    private TableView<besindegerleri> tableview_besindegerleri;

    @FXML
    private TableColumn<besindegerleri, Integer> tableview_besinid;

    @FXML
    private TableColumn<besindegerleri, String> tableview_besinadi;

    @FXML
    private TableColumn<besindegerleri, Integer> tableview_kalori;

    @FXML
    private TableColumn<besindegerleri, Double> tableview_protein;

    @FXML
    private TableColumn<besindegerleri, Double> tableview_yag;

    @FXML
    private TableColumn<besindegerleri, Double> tableview_karbonhidrat;

    @FXML
    private TextField filterfield_kullanici;


    @FXML
    private TableView<randevu> tableview_randevu;

    @FXML
    private TableColumn<randevu, Integer> tableview_randevu_hasta;

    @FXML
    private TableColumn<randevu, Integer> tableview_randevu_diyetisyen;

    @FXML
    private TableColumn<randevu, Date> tableview_randevu_tarih;

    @FXML
    private TableColumn<randevu, Integer> tableview_randevuid;

    @FXML
    private TextField txt_randevu_hastaid;

    @FXML
    private DatePicker datepicker_randevu;

    @FXML
    private DatePicker datepicker_kullanici;

    ObservableList<besindegerleri> ListP;
    ObservableList<besindegerleri> dataListP;
    ObservableList<randevu> ListT;


    public void BilgiPaneShow() {
        pane_hasta_bilgilerim.setVisible(true);
        pane_hasta_besindeger.setVisible(false);
        pane_hasta_randevu.setVisible(false);
    }

    public void BesinDegeriPaneShow() {
        pane_hasta_bilgilerim.setVisible(false);
        pane_hasta_besindeger.setVisible(true);
        pane_hasta_randevu.setVisible(false);
    }

    public void RandevuPaneShow() {
        pane_hasta_bilgilerim.setVisible(false);
        pane_hasta_besindeger.setVisible(false);
        pane_hasta_randevu.setVisible(true);
    }
    Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst =null;

    public void KullaniciEdit()
    {
        try{
            conn=MySqlConnect.ConnectDb();
            String value1=txt_hasta_tc.getText();
            String value2=txt_hasta_ad.getText();
            String value3=txt_hasta_soyad.getText();
            String value4= String.valueOf(datepicker_kullanici.getValue());
            String value5=txt_hasta_boy.getText();
            String value6=txt_hasta_kilo.getText();
            String value7=txt_hasta_cinsiyet.getText();
            String value8=txt_hasta_telefon.getText();

            String sql ="update hasta set HastaId='"+value1+"',Ad='"+value2+"',Soyad='"+value3+"',DogumTarih='"+value4+"',Boy='"+value5+"',Kilo='"+value6+"',Cinsiyet='"+value7+"',Telefon='"+value8+"' where HastaId='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Güncellendi");
            KullaniciUpdateTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }
    @FXML
    void search_besindeger(){
        tableview_besinid.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("BesinId"));
        tableview_besinadi.setCellValueFactory(new PropertyValueFactory<besindegerleri,String>("BesinAdi"));
        tableview_kalori.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("Kalori"));
        tableview_protein.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Protein"));
        tableview_yag.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Yag"));
        tableview_karbonhidrat.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Karbonhidrat"));

        dataListP=MySqlConnect.getDatabesindegerleri();
        tableview_besindegerleri.setItems(dataListP);
        FilteredList<besindegerleri> filteredData=new FilteredList<>(dataListP, b -> true);
        filterfield_kullanici.textProperty().addListener((observable,oldValue,newValue) -> {
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
        sortedData.comparatorProperty().bind(tableview_besindegerleri.comparatorProperty());
        tableview_besindegerleri.setItems(sortedData);
    }

    public void KullaniciRandevuEkle()
    {
        conn = MySqlConnect.ConnectDb();
        String sql="insert into randevu (DiyetisyenId,HastaId,TarihSaat) values (1,?,?)";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1, txt_randevu_hastaid.getText());
            pst.setString(2, String.valueOf(datepicker_randevu.getValue()));



            pst.execute();
            JOptionPane.showMessageDialog(null,"Randevu Bilgileri Başarıyla kaydedildi");
            KullaniciUpdateTable();



        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }


    public void KullaniciUpdateTable()
    {
        tableview_besinid.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("BesinId"));
        tableview_besinadi.setCellValueFactory(new PropertyValueFactory<besindegerleri,String>("BesinAdi"));
        tableview_kalori.setCellValueFactory(new PropertyValueFactory<besindegerleri,Integer>("Kalori"));
        tableview_protein.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Protein"));
        tableview_yag.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Yag"));
        tableview_karbonhidrat.setCellValueFactory(new PropertyValueFactory<besindegerleri,Double>("Karbonhidrat"));
        ListP=MySqlConnect.getDatabesindegerleri();
        tableview_besindegerleri.setItems(ListP);

        tableview_randevuid.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("RandevuId"));
        tableview_randevu_diyetisyen.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("DiyetisyenId"));
        tableview_randevu_hasta.setCellValueFactory(new PropertyValueFactory<randevu,Integer>("HastaId"));
        tableview_randevu_tarih.setCellValueFactory(new PropertyValueFactory<randevu,Date>("TarihSaat"));
        ListT=MySqlConnect.getDatarandevu();
        tableview_randevu.setItems(ListT);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KullaniciUpdateTable();
        search_besindeger();

    }
}
