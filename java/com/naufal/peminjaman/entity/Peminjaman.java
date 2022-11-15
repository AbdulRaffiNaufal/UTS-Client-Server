/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.peminjaman.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author IIISI
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nasabahId;
    private String namaNasabah;
    private double jumlahPinjaman;
    private double lamaPinjaman;
    private double bunga;
    private double angsuranBulan;
    private double angsuranPokok;
    private double totalHutang;
    
    public void setAngsuranPokok(double angsuranPokok){
        this.angsuranPokok=angsuranPokok;
    }
    
    public double getAngsuranPokok(){
        angsuranPokok = jumlahPinjaman / lamaPinjaman;
        return angsuranPokok;
    }
    
    public void setAngsuranBulan(double angsuranBulan){
        this.angsuranBulan=angsuranBulan;
    }
    
    public double getAngsuranBulan(){
        angsuranBulan = (bunga/12) + angsuranPokok;
        return angsuranBulan;
    }
    
    public void setTotalHutang(double totalHutang){
        this.totalHutang=totalHutang;
    }
    
    public double getTotalHutang(){
        totalHutang = (angsuranPokok + angsuranBulan) + bunga;
        return totalHutang;
    }
}
