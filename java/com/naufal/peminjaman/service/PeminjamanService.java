/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.peminjaman.service;

import com.naufal.peminjaman.VO.Nasabah;
import com.naufal.peminjaman.VO.ResponseTemplateVO;
import com.naufal.peminjaman.entity.Peminjaman;
import com.naufal.peminjaman.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author IIISI
 */
@Service
public class PeminjamanService {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
    
    public ResponseTemplateVO getPeminjaman(Long peminjamanId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Peminjaman peminjaman =
                peminjamanRepository.findByPeminjamanId(peminjamanId);
        Nasabah nasabah =
        restTemplate.getForObject("http://localhost:9005/nasabah/"
                + peminjaman.getNasabahId(), Nasabah.class);
        vo.setPeminjaman(peminjaman);
        vo.setNasabah(nasabah);
        return vo;
    }
}
