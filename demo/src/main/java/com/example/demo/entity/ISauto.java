package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ISauto")
@Data
public class ISauto implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "rendszam")
    private String rendszam;

    @Column(name = "szallithato_szemelyek_szama")
    private Integer szallithatoSzemelyekSzama;

    @Column(name = "szin")
    private String szin;

    @Column(name = "osszar")
    private Integer osszar;

    @Column(name = "osszkm")
    private Integer osszkm;

    @Temporal(TemporalType.DATE)
    @Column(name = "gyartasi_ev")
    private Date gyartasiEv;

    @Column(name = "uzemanyag_fogyasztas")
    private Integer uzemanyagFogyasztas;

    @JsonIgnore
    @OneToMany(mappedBy = "aid")
    private List<ISmenetlevel> ismenetlevelek;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzemanyagID")
    private ISnav navArak;

    public ISauto(Long id, String rendszam, Integer szallithatoSzemelyekSzama, String szin, Integer osszar, Integer osszkm, Date gyartasiEv, Integer uzemanyagFogyasztas, ISnav navArak) {
        this.id = id;
        this.rendszam = rendszam;
        this.szallithatoSzemelyekSzama = szallithatoSzemelyekSzama;
        this.szin = szin;
        this.osszar = osszar;
        this.osszkm = osszkm;
        this.gyartasiEv = gyartasiEv;
        this.uzemanyagFogyasztas = uzemanyagFogyasztas;
        this.navArak = navArak;
    }

    public ISauto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public Integer getSzallithatoSzemelyekSzama() {
        return szallithatoSzemelyekSzama;
    }

    public void setSzallithatoSzemelyekSzama(Integer szallithatoSzemelyekSzama) {
        this.szallithatoSzemelyekSzama = szallithatoSzemelyekSzama;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public Date getGyartasiEv() {
        return gyartasiEv;
    }

    public void setGyartasiEv(Date gyartasiEv) {
        this.gyartasiEv = gyartasiEv;
    }

    public Integer getUzemanyagFogyasztas() {
        return uzemanyagFogyasztas;
    }

    public void setUzemanyagFogyasztas(Integer uzemanyagFogyasztas) {
        this.uzemanyagFogyasztas = uzemanyagFogyasztas;
    }



    public ISnav getNavArak() {
        return navArak;
    }

    public void setNavArak(ISnav navArak) {
        this.navArak = navArak;
    }

    @Override
    public String toString() {
        return "ISauto{" +
                "id=" + id +
                ", rendszam='" + rendszam + '\'' +
                ", szallithatoSzemelyekSzama=" + szallithatoSzemelyekSzama +
                ", szin='" + szin + '\'' +
                ", gyartasiEv=" + gyartasiEv +
                ", uzemanyagFogyasztas=" + uzemanyagFogyasztas +

                ", navArak=" + navArak +
                '}';
    }
}