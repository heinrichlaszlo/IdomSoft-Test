package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ISnav")
@Data
public class ISnav implements Serializable {
    @Id
    @Column(name = "uzemanyagID", nullable = false)
    private Integer uzemanyagID;

    @Column(name = "nev")
    private String nev;

    @Column(name = "ar")
    private Integer ar;

    public ISnav(Integer uzemanyagID, String nev, Integer ar) {
        this.uzemanyagID = uzemanyagID;
        this.nev = nev;
        this.ar = ar;
    }

    public ISnav() {

    }

    public Integer getUzemanyagID() {
        return uzemanyagID;
    }

    public void setUzemanyagID(Integer uzemanyagID) {
        this.uzemanyagID = uzemanyagID;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public  Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "ISnav{" +
                "uzemanyagID=" + uzemanyagID +
                ", nev='" + nev + '\'' +
                ", ar=" + ar +
                '}';
    }
}