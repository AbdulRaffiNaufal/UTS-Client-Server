/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.nasabah.repository;

import com.naufal.nasabah.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author IIISI
 */
@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, Long>{
    
    public Nasabah findByNasabahId(Long nasabahId);
}
