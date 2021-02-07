package sample;

import java.util.Date;

public class login {
    int KullaniciId, KullaniciTc;
    //String Sifre;
    //boolean KullaniciTuru;

    public void setKullaniciId(int KullaniciId)
    {
        this.KullaniciId=KullaniciId;
    }

    public void setKullaniciTc(int KullaniciTc)
    {
        this.KullaniciTc=KullaniciTc;
    }
    /*public void setSifre(String Sifre)
    {
        this.Sifre=Sifre;
    }
    public void setKullaniciTuru(boolean KullaniciTuru)
    {
        this.KullaniciTuru=KullaniciTuru;
    }*/

    public int getKullaniciId()
    {
        return KullaniciId;

    }

    public int getKullaniciTc()
    {
        return KullaniciTc;
    }
    /*public String getSifre()
    {
        return Sifre;
    }
    public boolean getKullaniciTuru()
    {
        return KullaniciTuru;
    }*/

    public  login(int KullaniciId, int KullaniciTc)
    {
        this.KullaniciId=KullaniciId;
        this.KullaniciTc=KullaniciTc;
       // this.Sifre=Sifre;
        //this.KullaniciTuru=KullaniciTuru;

    }


}
