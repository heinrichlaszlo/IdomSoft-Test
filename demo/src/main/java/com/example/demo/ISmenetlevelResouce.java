package com.example.demo;

import com.example.demo.dto.ISmenetlevelRequest;
import com.example.demo.entity.ISmenetlevel;

import com.example.demo.service.ISmenetlevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/ismenetlevel")
public class ISmenetlevelResouce {


    private ISmenetlevelService ismenetlevelService;

    private EntityManager em;

    public ISmenetlevelResouce(ISmenetlevelService ismenetlevelService) {
        this.ismenetlevelService = ismenetlevelService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ISmenetlevel>> getAllisMenetlevel() {
        List<ISmenetlevel> ismenetlevels = ismenetlevelService.findAllMenetlevel();
        return new ResponseEntity<>(ismenetlevels, HttpStatus.OK);
    }

    @GetMapping("/find/{sorszam}")
    public ResponseEntity<ISmenetlevel> getisMenetlevelBySorszam(@PathVariable("sorszam") Long sorszam) {
        ISmenetlevel ismenetlevelek = ismenetlevelService.findMEnetlevelBySorszam(sorszam);
        return new ResponseEntity<>(ismenetlevelek, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ISmenetlevel> addIsMenetlevel(@RequestBody ISmenetlevelRequest iSmenetlevelRequest) {

        ISmenetlevel newISmenetlevel = ismenetlevelService.addMenetlevel(iSmenetlevelRequest);
        //System.out.println(ismenetlevel.getSorszam()+"asd");
        return new ResponseEntity<>(newISmenetlevel, HttpStatus.CREATED);
    }
    @PutMapping("/updatear/{sorszam}")
    public ResponseEntity<ISmenetlevel> updateAr(@PathVariable("sorszam") Long sorszam) {
        try {
            return new ResponseEntity<ISmenetlevel>(ismenetlevelService.updateMenetlevelAr(sorszam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ISmenetlevel>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{sorszam}")
    public ResponseEntity<String> deleteMenetlevel(@PathVariable("sorszam") Long sorszam) {
        try {
            return new ResponseEntity<String>(ismenetlevelService.deleteMenetLevel(sorszam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllAr/{id}")
    public Integer getaAllAr(@PathVariable Long id){
        return ismenetlevelService.getaAllAr(id);
    }
    @GetMapping("/getAllKm/{id}")
    public Integer getaAllKm(@PathVariable Long id){
        return ismenetlevelService.getaAllKm(id);
    }
    @PutMapping("/update")
    public ResponseEntity<ISmenetlevel> updateML(@RequestBody ISmenetlevelRequest iSmenetlevelRequest) {
        ISmenetlevel updateISmenetlevel = ismenetlevelService.updateML(iSmenetlevelRequest);
        return new ResponseEntity<>(updateISmenetlevel, HttpStatus.OK);
    }
}
