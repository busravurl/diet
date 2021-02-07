package sample;

import java.sql.Date;

public class randevu {
    int RandevuId, DiyetisyenId,HastaId;
    Date TarihSaat;

    public void setRandevuId(int RandevuId)
    {
        this.RandevuId=RandevuId;
    }

    public void setDiyetisyenId(int DiyetisyenId)
    {
        this.DiyetisyenId=DiyetisyenId;
    }
    public void setHastaId(int HastaId)
    {
        this.HastaId=HastaId;
    }
    public void setTarihSaat(Date TarihSaat)
    {
        this.TarihSaat=TarihSaat;
    }

    public int getHastaId()
    {
        return HastaId;
    }
    public int getDiyetisyenId()
    {
        return DiyetisyenId;
    }
    public int getRandevuId()
    {
        return RandevuId;
    }
    public Date getTarihSaat() {return TarihSaat;}



    public  randevu(int RandevuId,int DiyetisyenId,int HastaId,Date TarihSaat)
    {
        this.RandevuId=RandevuId;
        this.DiyetisyenId=DiyetisyenId;
        this.HastaId=HastaId;
        this.TarihSaat=TarihSaat;

    }
}
