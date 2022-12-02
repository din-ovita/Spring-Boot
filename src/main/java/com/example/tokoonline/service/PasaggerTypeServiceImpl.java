package com.example.tokoonline.service;

import com.example.tokoonline.model.PasaggerType;
import com.example.tokoonline.repository.PasaggerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasaggerTypeServiceImpl implements PasaggerTypeService{

    @Autowired
    PasaggerTypeRepository pasaggerTypeRepository;

    @Override
    public PasaggerType addPasagger(PasaggerType pasaggerType){
        return pasaggerTypeRepository.save(pasaggerType);
    }

    @Override
    public List<PasaggerType> getAllPasagger() {
        return pasaggerTypeRepository.findAll();
    }

    @Override
    public PasaggerType updatePasagger(Integer id, String name) {
        PasaggerType pasaggerType = pasaggerTypeRepository.findById(id).get();
        pasaggerType.setName(name);
        return pasaggerTypeRepository.save(pasaggerType);
    }

    @Override
    public void deletePasagger(Integer id) {
        pasaggerTypeRepository.deleteById(id);
    }

}
