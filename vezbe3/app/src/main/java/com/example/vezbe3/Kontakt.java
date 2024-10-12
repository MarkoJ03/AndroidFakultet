package com.example.vezbe3;

public class Kontakt {
    private String ime;
    private String prezime;
    private String broj;

    // Konstruktor
    public Kontakt(String ime, String prezime, String broj) {
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getBroj() {
        return broj;
    }


    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}