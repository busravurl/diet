package sample;

import java.util.Date;

public class besindegerleri {
    int BesinId;
    String BesinAdi;
    int Kalori;
    double Protein,Yag,Karbonhidrat;

    public void setBesinId(int BesinId)
    {
        this.BesinId=BesinId;
    }

    public void setKalori(int Kalori)
    {
        this.Kalori=Kalori;
    }
    public void setBesinAdi(String BesinAdi)
    {
        this.BesinAdi=BesinAdi;
    }
    public void setProtein(double Protein)
    {
        this.Protein=Protein;
    }
    public void setYag(double Yag)
    {
        this.Yag=Yag;
    }
    public void setKarbonhidrat(double Karbonhidrat)
    {
        this.Karbonhidrat=Karbonhidrat;
    }

    public int getBesinId()
    {
        return BesinId;

    }

    public int getKalori()
    {
        return Kalori;
    }
    public String getBesinAdi()
    {
        return BesinAdi;
    }
    public double getProtein()
    {
        return Protein;
    }
    public double getYag()
    {
        return Yag;
    }

    public double getKarbonhidrat()
    {
        return Karbonhidrat;
    }

    public  besindegerleri(int BesinId,int Kalori,String BesinAdi,double Protein,double Yag,double Karbonhidrat)
    {this.BesinId=BesinId;
        this.BesinAdi=BesinAdi;
        this.Kalori=Kalori;
        this.Protein=Protein;
        this.Yag=Yag;
        this.Karbonhidrat=Karbonhidrat;
    }


}
