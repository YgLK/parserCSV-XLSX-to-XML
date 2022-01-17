package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
* Class representing
 * single invoice with corresponding
 * fields.
 *
 */
@XmlRootElement(name="faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    // Ivoice data columns
    private String NazwaOdbiorcy;
    private String AdresOdbiorcy;
    private String NIPodbiorcy;
    private String DataWystawienia;
    private String DataSprzedazy;
    private String NrFaktury;
    private String TytulPozycji;
    private String LiczbaSztuk;
    private String CenaJednostkowa;
    private String StawkaPodatku_Procenty;
    private String KwotaPodatku;
    private String CenaNettoPozycji;
    private String CenaBruttoPozycji;
    private String CenaNettoFakturyLacznie;
    private String CenaBruttoFakturyLacznie;

    /**
     * Set invoice data.
     *
     * Columns data:
     * @param nazwaOdbiorcy
     * @param adresOdbiorcy
     * @param nipOdbiorcy
     * @param dataWystawienia
     * @param dataSprzedazy
     * @param nrFaktury
     * @param tytulPozycji
     * @param liczbaSztuk
     * @param cenaJednostkowa
     * @param stawkaPodatku_Procenty
     * @param kwotaPodatku
     * @param cenaNettoPozycji
     * @param cenaBruttoPozycji
     * @param cenaNettoFakturyLacznie
     * @param cenaBruttoFakturyLacznie
     * @return this
     */
    public Invoice setData(
        String nazwaOdbiorcy,
        String adresOdbiorcy,
        String nipOdbiorcy,
        String dataWystawienia,
        String dataSprzedazy,
        String nrFaktury,
        String tytulPozycji,
        String liczbaSztuk,
        String cenaJednostkowa,
        String stawkaPodatku_Procenty,
        String kwotaPodatku,
        String cenaNettoPozycji,
        String cenaBruttoPozycji,
        String cenaNettoFakturyLacznie,
        String cenaBruttoFakturyLacznie
    ){
        this.setNazwaOdbiorcy(nazwaOdbiorcy);
        this.setAdresOdbiorcy(adresOdbiorcy);
        this.setNIPodbiorcy(nipOdbiorcy);
        this.setDataWystawienia(dataWystawienia);
        this.setDataSprzedazy(dataSprzedazy);
        this.setNrFaktury(nrFaktury);
        this.setTytulPozycji(tytulPozycji);
        this.setLiczbaSztuk(liczbaSztuk);
        this.setCenaJednostkowa(cenaJednostkowa);
        this.setStawkaPodatku_Procenty(stawkaPodatku_Procenty);
        this.setKwotaPodatku(kwotaPodatku);
        this.setCenaNettoPozycji(cenaNettoPozycji);
        this.setCenaBruttoPozycji(cenaBruttoPozycji);
        this.setCenaNettoFakturyLacznie(cenaNettoFakturyLacznie);
        this.setCenaBruttoFakturyLacznie(cenaBruttoFakturyLacznie);

        // return reference to the actual invoice in order to add it to the list
        return this;
    }

    public String getNazwaOdbiorcy() {
        return NazwaOdbiorcy;
    }

    public void setNazwaOdbiorcy(String nazwaOdbiorcy) {
        NazwaOdbiorcy = nazwaOdbiorcy;
    }

    public String getAdresOdbiorcy() {
        return AdresOdbiorcy;
    }

    public void setAdresOdbiorcy(String adresOdbiorcy) {
        AdresOdbiorcy = adresOdbiorcy;
    }

    public String getNIPodbiorcy() {
        return NIPodbiorcy;
    }

    public void setNIPodbiorcy(String NIPodbiorcy) {
        this.NIPodbiorcy = NIPodbiorcy;
    }

    public String getDataWystawienia() {
        return DataWystawienia;
    }

    public void setDataWystawienia(String dataWystawienia) {
        DataWystawienia = dataWystawienia;
    }

    public String getDataSprzedazy() {
        return DataSprzedazy;
    }

    public void setDataSprzedazy(String dataSprzedazy) {
        DataSprzedazy = dataSprzedazy;
    }

    public String getNrFaktury() {
        return NrFaktury;
    }

    public void setNrFaktury(String nrFaktury) {
        NrFaktury = nrFaktury;
    }

    public String getTytulPozycji() {
        return TytulPozycji;
    }

    public void setTytulPozycji(String tytulPozycji) {
        TytulPozycji = tytulPozycji;
    }

    public String getLiczbaSztuk() {
        return LiczbaSztuk;
    }

    public void setLiczbaSztuk(String liczbaSztuk) {
        LiczbaSztuk = liczbaSztuk;
    }

    public String getCenaJednostkowa() {
        return CenaJednostkowa;
    }

    public void setCenaJednostkowa(String cenaJednostkowa) {
        CenaJednostkowa = cenaJednostkowa;
    }

    public String getStawkaPodatku_Procenty() {
        return StawkaPodatku_Procenty;
    }

    public void setStawkaPodatku_Procenty(String stawkaPodatku_Procenty) {
        StawkaPodatku_Procenty = stawkaPodatku_Procenty;
    }

    public String getKwotaPodatku() {
        return KwotaPodatku;
    }

    public void setKwotaPodatku(String kwotaPodatku) {
        KwotaPodatku = kwotaPodatku;
    }

    public String getCenaNettoPozycji() {
        return CenaNettoPozycji;
    }

    public void setCenaNettoPozycji(String cenaNettoPozycji) {
        CenaNettoPozycji = cenaNettoPozycji;
    }

    public String getCenaBruttoPozycji() {
        return CenaBruttoPozycji;
    }

    public void setCenaBruttoPozycji(String cebaBruttoPozycji) {
        CenaBruttoPozycji = cebaBruttoPozycji;
    }

    public String getCenaNettoFakturyLacznie() {
        return CenaNettoFakturyLacznie;
    }

    public void setCenaNettoFakturyLacznie(String cenaNettoFakturyLacznie) {
        CenaNettoFakturyLacznie = cenaNettoFakturyLacznie;
    }

    public String getCenaBruttoFakturyLacznie() {
        return CenaBruttoFakturyLacznie;
    }

    public void setCenaBruttoFakturyLacznie(String cenaBruttoFakturyLacznie) {
        CenaBruttoFakturyLacznie = cenaBruttoFakturyLacznie;
    }
}