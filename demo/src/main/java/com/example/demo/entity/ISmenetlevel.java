package com.example.demo.entity;




import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ISmenetlevel")
@Data
public class ISmenetlevel implements Serializable {
    @Id
    @Column(name = "sorszam", nullable = false)
    private Long sorszam;

    @Column(name = "honnan")
    private String honnan;

    @Column(name = "hova")
    private String hova;

    @Column(name = "gepjarmu_vezeto_neve")
    private String gepjarmuVezetoNeve;

    @Column(name = "km")
    private Integer km;

    @Column(name = "datum_kezdo")
    private String datumKezdo;

    @Column(name = "menetlevelAr")
    private float ar;

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "id")
    private ISauto aid;

    public ISmenetlevel(Long sorszam, String honnan, String hova, String gepjarmuVezetoNeve, Integer km, String datumKezdo, float ar, ISauto aid) {
        this.sorszam = sorszam;
        this.honnan = honnan;
        this.hova = hova;
        this.gepjarmuVezetoNeve = gepjarmuVezetoNeve;
        this.km = km;
        this.datumKezdo = datumKezdo;
        this.ar = ar;
        this.aid = aid;
    }

    public ISmenetlevel() {

    }

    public Long getSorszam() {
        return sorszam;
    }

    public void setSorszam(Long sorszam) {
        this.sorszam = sorszam;
    }

    public String getHonnan() {
        return honnan;
    }

    public void setHonnan(String honnan) {
        this.honnan = honnan;
    }

    public String getHova() {
        return hova;
    }

    public void setHova(String hova) {
        this.hova = hova;
    }

    public String getGepjarmuVezetoNeve() {
        return gepjarmuVezetoNeve;
    }

    public void setGepjarmuVezetoNeve(String gepjarmuVezetoNeve) {
        this.gepjarmuVezetoNeve = gepjarmuVezetoNeve;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getDatumKezdo() {
        return datumKezdo;
    }

    public void setDatumKezdo(String datumKezdo) {
        this.datumKezdo = datumKezdo;
    }

    public float getAr() {
        return ar;
    }

    public void setAr(float ar) {
        this.ar = ar;
    }

    public ISauto getAid() {
        return aid;
    }

    public void setAid(ISauto aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "ISmenetlevel{" +
                "sorszam=" + sorszam +
                ", aid=" + aid +
                ", honnan='" + honnan + '\'' +
                ", hova='" + hova + '\'' +
                ", gepjarmuVezetoNeve='" + gepjarmuVezetoNeve + '\'' +
                ", km=" + km +
                ", datumKezdo='" + datumKezdo + '\'' +
                ", ar=" + ar +
                '}';
    }
}