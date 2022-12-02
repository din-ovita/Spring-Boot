package com.example.tokoonline.service;

import com.example.tokoonline.model.TiketKereta;

import java.util.List;

public interface TiketKeretaService {
    TiketKereta addTiketKereta(int pasaggerType, TiketKereta tiketKereta);

    TiketKereta getTiketKereta(Long id);

    List<TiketKereta> getAllTiket();

    TiketKereta updateTiket(Long id, int pasaggerType, TiketKereta tiketKereta);

//     TiketKereta updateTiket(Long id, TiketKereta tiketKereta);

    void deleteTiket(Long id);

//    Map<String, Boolean> delete(int id)
}
