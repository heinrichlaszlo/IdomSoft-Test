package com.example.demo;

import com.example.demo.entity.ISauto;
import com.example.demo.service.ISautoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/isauto")
public class ISautoResourve {

    private final ISautoService isautoService;

    public ISautoResourve(ISautoService isautoService) {
        this.isautoService = isautoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ISauto>> getfindAllauto() {
        List<ISauto> isautok = isautoService.findAllauto();
        return new ResponseEntity<>(isautok, HttpStatus.OK);
    }

    @PutMapping("/updateOsszAr/{id}")
    public ResponseEntity<ISauto> updateAr(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<ISauto>(isautoService.updateIsauto(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ISauto>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateOsszKm/{id}")
    public ResponseEntity<ISauto> updateKm(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<ISauto>(isautoService.updateIsautoKm(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ISauto>(HttpStatus.BAD_REQUEST);
        }
    }
}
