package com.example.tokoonline.service;

import com.example.tokoonline.model.PasaggerType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PasaggerTypeService {
    PasaggerType addPasagger(PasaggerType pasaggerType);

    List<PasaggerType> getAllPasagger();

    PasaggerType updatePasagger(Integer id, String name);

    void deletePasagger(Integer id);

}
