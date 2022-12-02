package com.example.tokoonline.service;

import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.PasaggerType;
import com.example.tokoonline.model.TiketKereta;
import com.example.tokoonline.repository.PasaggerTypeRepository;
import com.example.tokoonline.repository.TiketKeretaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TiketKeretaServiceImpl implements TiketKeretaService {

//    STATIC : method bisa diakses langsung
//    final : tidak bisa diubah
//    default primitis :
//    HOUR : rumus
//    rumus jam dimulai dari mili second
    private static final int HOUR = 3600 * 1000;

    @Autowired
    private TiketKeretaRepository tiketKeretaRepository;

    @Autowired
    private PasaggerTypeRepository pasaggerTypeRepository;

    @Override
    public TiketKereta addTiketKereta(int pasaggerType, TiketKereta tiketKereta) {
        PasaggerType typePasagger = pasaggerTypeRepository.findById(pasaggerType).orElseThrow(() -> new NotFoundException("Pasager type not found"));
        tiketKereta.setPasaggerType(typePasagger);
        tiketKereta.setEnd_date(new Date(new Date().getTime() + 3 * HOUR));
        tiketKereta.setKodeBocking(random());
        return tiketKeretaRepository.save(tiketKereta);
    }

//    @Transactional
//    @Override
//    public TiketKereta addTiketKereta(int pasaggerType, TiketKereta tiketKereta) {
//        tiketKereta.setEnd_date(new Date(new Date().getTime() + 3 * HOUR));
//        tiketKereta.setKodeBocking(random());
//        var res = tiketKeretaRepository.save(tiketKereta);
//        PasaggerType typePasagger = pasaggerTypeRepository.findById(pasaggerType).orElseThrow(() -> new NotFoundException("Pasager type not found"));
//        res.setPasaggerType(typePasagger);
//        return tiketKeretaRepository.save(res);
//    }
//

//    to create random code
    private String random() {
        Random random = new Random();
        String result = "";
        String character = "aabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-+";
        for (int i = 0; i < 12; i++) {
            result += character.charAt(random.nextInt(character.length()));
        }
        return result;
    }

    @Override
    public TiketKereta getTiketKereta(Long id) {
        return tiketKeretaRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public List<TiketKereta> getAllTiket() {
        return tiketKeretaRepository.findAll();
    }

    @Override
    public TiketKereta updateTiket(Long id, int pasaggerTypeId, TiketKereta tiketKereta) {
        TiketKereta update = tiketKeretaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tiket kereta id not found"));
        PasaggerType pasaggerType = pasaggerTypeRepository.findById(pasaggerTypeId).orElseThrow(() -> new NotFoundException("Pasagger type tidak ditemukan"));
        update.setNama(tiketKereta.getNama());
        update.setKrl(tiketKereta.getKrl());
        update.setDeparture(tiketKereta.getDeparture());
        update.setEndDeparture(tiketKereta.getEndDeparture());
        update.setPasaggerType(pasaggerType);
        return tiketKeretaRepository.save(update);
    }

//    @Override
//    public TiketKereta updateTiket(Long id, int pasaggerType, String nama, String krl, String departure, String endDeparture) {
//        TiketKereta update = tiketKeretaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tiket kereta id not found"));
//        PasaggerType pasaggerType = pasaggerTypeRepository.findById(pasaggerType).orElseThrow(() -> new NotFoundException("Pasagger type tidak ditemukan"));
//        tiketKereta.setNama(nama);
//        tiketKereta.setKrl(krl);
//        tiketKereta.Departure(departure);
//        tiketKereta.setEndDeparture(endDepartue));
//        update.setPasaggerType(pasaggerType);
//        return tiketKeretaRepository.save(update);
//    }

    @Override
    public void deleteTiket(Long id) {
        tiketKeretaRepository.deleteById(id);
    }

//    public Map<String, Boolean> delete(int id) {
//
//    }
}