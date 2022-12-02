package com.example.tokoonline.controller;

import com.example.tokoonline.model.PasaggerType;
import com.example.tokoonline.response.CommonResponse;
import com.example.tokoonline.response.ResponseHelper;
import com.example.tokoonline.service.PasaggerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasagger-type")
public class PasaggerTypeController {

    @Autowired
    private PasaggerTypeService pasaggerTypeService;

    @PostMapping
    public CommonResponse<PasaggerType> addPasagger(@RequestBody PasaggerType pasaggerType) {
        return ResponseHelper.ok(pasaggerTypeService.addPasagger(pasaggerType));
    }

    @GetMapping("/all-pasagger")
    public CommonResponse<List<PasaggerType>>  getAllPasagger() {
        return ResponseHelper.ok(pasaggerTypeService.getAllPasagger());
    }

    @PutMapping("/{id}")
    public CommonResponse<PasaggerType> updatePasagger(@PathVariable("id") Integer id, @RequestBody PasaggerType pasaggerType) {
        return ResponseHelper.ok(pasaggerTypeService.updatePasagger(id, pasaggerType.getName()));
    }

    @DeleteMapping("/{id}")
    public void deletePasagger(@PathVariable("id") Integer id) {
        pasaggerTypeService.deletePasagger(id);
    }
}