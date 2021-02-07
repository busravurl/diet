package sample;

import java.util.Date;

public class hasta {
    int HastaId,Boy,Kilo;
    int Telefon;
    String Ad,Soyad,Cinsiyet;
    Date DogumTarih;

    public void setHastaId(int HastaId)
    {
        this.HastaId=HastaId;
    }

    public void setBoy(int Boy)
    {
        this.Boy=Boy;
    }
    public void setKilo(int Kilo)
    {
        this.Kilo=Kilo;
    }
    public void setTelefon(int Telefon)
    {
        this.Telefon=Telefon;
    }
    public void setAd(String Ad)
    {
        this.Ad=Ad;
    }
    public void setSoyad(String Soyad)
    {
        this.Soyad=Soyad;
    }
    public void setCinsiyet(String Cinsiyet)
    {
        this.Cinsiyet=Cinsiyet;
    }
    public void setDogumTarih(Date DogumTarih)
    {
        this.DogumTarih=DogumTarih;
    }
    public int getHastaId()
    {
        return HastaId;

    }

    public int getBoy()
    {
        return Boy;
    }
    public int getKilo()
    {
        return Kilo;
    }
    public int getTelefon()
    {
        return Telefon;
    }
    public String getAd()
    {
        return Ad;
    }
    public String getSoyad()
    {
        return Soyad;
    }
    public String getCinsiyet()
    {
        return Cinsiyet;
    }
    public Date getDogumTarih()
    {
        return DogumTarih;
    }
    public  hasta(int HastaId,int Boy,int Kilo,int Telefon,String Ad,String Soyad,String Cinsiyet,Date DogumTarih)
    {
        this.HastaId=HastaId;
        this.DogumTarih=DogumTarih;
        this.Cinsiyet=Cinsiyet;
        this.Ad=Ad;
        this.Soyad=Soyad;
        this.Telefon=Telefon;
        this.Boy=Boy;
        this.Kilo=Kilo;
    }


}
