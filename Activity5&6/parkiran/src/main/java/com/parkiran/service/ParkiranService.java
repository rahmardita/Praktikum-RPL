/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkiran.service;

import com.parkiran.model.ModelParkiran;
import com.parkiran.repository.ParkiranRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adelia
 */
@Service
public class ParkiranService {

    @Autowired
    private ParkiranRepository repo;

    public void masukParkir(ModelParkiran park) {
        repo.save(park);
    }

    public String keluarParkir(String platNomor) {
        Optional<ModelParkiran> optionalParkiran = repo.findByPlatNomor(platNomor);
        if (optionalParkiran.isPresent()) {
            ModelParkiran parkiran = optionalParkiran.get();
            LocalDateTime waktuKeluar = LocalDateTime.now();
            Duration durasi = Duration.between(parkiran.getWaktuMasuk(), waktuKeluar);
            long jamParkir = durasi.toHours();
            if (durasi.toMinutesPart() > 0) {
                jamParkir++; 
            }

            int tarifPerJam = (parkiran.getJenisKendaraan() == 1) ? 5000 : 10000;
            long totalBiaya = jamParkir * tarifPerJam;
            String total = totalBiaya + "";

            String jenisKendaraan = (parkiran.getJenisKendaraan() == 1) ? "Motor" : "Mobil";

            repo.delete(parkiran);
            
            return total;
        } else {
            return "Kendaraan dengan plat nomor " + platNomor + " tidak ditemukan.";
        }
    }
    public List<ModelParkiran> getAllParkiran(){
        return repo.findAll();
    }
}
