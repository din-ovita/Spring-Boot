package com.example.tokoonline.controller;

import com.example.tokoonline.dto.TiketKeretaDTO;
import com.example.tokoonline.model.TiketKereta;
import com.example.tokoonline.response.CommonResponse;
import com.example.tokoonline.response.ResponseHelper;
import com.example.tokoonline.service.TiketKeretaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiket_kereta")
public class TiketKeretaController {
    @Autowired
    private TiketKeretaService tiketKeretaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{pasaggerType}")
    public CommonResponse<TiketKereta> addTiketKereta(@PathVariable("pasaggerType") Integer pasaggerType,  @RequestBody TiketKeretaDTO tiketKeretaDTO) {
        return ResponseHelper.ok(tiketKeretaService.addTiketKereta(pasaggerType, modelMapper.map(tiketKeretaDTO, TiketKereta.class)));
    }

//    @PostMapping("/{pasaggerType}")
//    public ResponseEntity<?> addTiketKereta(@PathVariable("pasaggerType") Integer pasaggerType,  @RequestBody TiketKeretaDTO tiketKeretaDTO) {
//        return ResponseHelper.ok(tiketKeretaService.addTiketKereta(pasaggerType, modelMapper.map(tiketKeretaDTO, TiketKereta.class)));
//    }

    @GetMapping("/all-tiket")
    public CommonResponse<List<TiketKereta>> getAllTiket() {
        return ResponseHelper.ok(tiketKeretaService.getAllTiket());
    }

    @GetMapping("/{id}")
    public CommonResponse<TiketKereta> getTiketKereta(@PathVariable("id") Long id) {
        return ResponseHelper.ok(tiketKeretaService.getTiketKereta(id));
    }

    @PutMapping("/{id}")
    public CommonResponse<TiketKereta> updateTiket(@PathVariable("id") Long id, @RequestParam("pasaggerType") int pasaggerType, @RequestBody TiketKeretaDTO tiketKeretaDTO) {
        return ResponseHelper.ok(tiketKeretaService.updateTiket(id, pasaggerType, modelMapper.map(tiketKeretaDTO, TiketKereta.class)));
    }

    @DeleteMapping("/{id}")
    public void deleteTiket(@PathVariable("id") Long id) {
        tiketKeretaService.deleteTiket(id);
    }

//    @DeleteMapping("/{id}")
//    public CommonResponse<Map<String, Boolean>> deleteTiket(@PathVariable("id") Long id) {
//        return ResponseHelper.ok(tiketKeretaService.deleteTiket(id));
//    }
}
