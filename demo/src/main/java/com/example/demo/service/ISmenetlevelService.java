package com.example.demo.service;


import com.example.demo.dao.ISautoRepository;
import com.example.demo.dao.ISmenetlevelRepository;
import com.example.demo.dto.ISmenetlevelRequest;
import com.example.demo.entity.ISauto;
import com.example.demo.entity.ISmenetlevel;
import com.example.demo.exception.MenetlevelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ISmenetlevelService {

    @Autowired
    private final ISmenetlevelRepository isMenetlevelRepository;

    @Autowired
    private final ISautoRepository isautoRepository;


    @Autowired
    public ISmenetlevelService(ISmenetlevelRepository isMenetlevelRepository, ISautoRepository isautoRepository) {
        this.isMenetlevelRepository = isMenetlevelRepository;
        this.isautoRepository = isautoRepository;

    }

    public ISmenetlevel addMenetlevel(ISmenetlevelRequest iSmenetlevelRequest){
        //menetlevel.setSorszam(Long.parseLong(String.valueOf(UUID.randomUUID())));
        ISauto isauto = isautoRepository.findById(iSmenetlevelRequest.getAid_id()).get();
        ISmenetlevel iSmenetlevel = new ISmenetlevel();
        iSmenetlevel.setSorszam(iSmenetlevelRequest.getSorszam());
        iSmenetlevel.setHonnan(iSmenetlevelRequest.getHonnan());
        iSmenetlevel.setHova(iSmenetlevelRequest.getHova());
        iSmenetlevel.setGepjarmuVezetoNeve(iSmenetlevelRequest.getGepjarmuVezetoNeve());
        iSmenetlevel.setKm(iSmenetlevelRequest.getKm());
        iSmenetlevel.setDatumKezdo(iSmenetlevelRequest.getDatumKezdo());
        iSmenetlevel.setAr(0);
        iSmenetlevel.setAid(isauto);
        return isMenetlevelRepository.save(iSmenetlevel);
    }

    public List<ISmenetlevel> findAllMenetlevel(){
        return isMenetlevelRepository.findAll();
    }
    public ISmenetlevel updateMenetlevelAr(Long sorszam){
        ISmenetlevel ismenetlevel = isMenetlevelRepository.findById(sorszam).get();
        updateIsmenetlevel(ismenetlevel);
        ISauto iSauto = isautoRepository.findById(ismenetlevel.getAid().getId()).get();
        iSauto.setOsszar(0);
        iSauto.setOsszkm(0);
        isautoRepository.save(iSauto);
        return isMenetlevelRepository.save(ismenetlevel);
    }
    public ISmenetlevel updateIsmenetlevel(ISmenetlevel ismenetlevel){
        float ar;
        ar = (((float)ismenetlevel.getKm()/100)*(float)ismenetlevel.getAid().getUzemanyagFogyasztas()*(float)ismenetlevel.getAid().getNavArak().getAr());
        ismenetlevel.setAr(ar);
        return isMenetlevelRepository.save(ismenetlevel);
    }
    public ISmenetlevel findMEnetlevelBySorszam( Long sorszam){
        return isMenetlevelRepository.findMenetlevelBySorszam(sorszam).orElseThrow(() -> new MenetlevelNotFoundException("hiba"));
    }

    public String deleteMenetLevel(Long sorszam){
        isMenetlevelRepository.deleteById(sorszam);
        return "sikeresen törölve";
    }

   public Integer getaAllAr(Long id){
        return isMenetlevelRepository.getaAllAr(id);
    }

    public Integer getaAllKm(Long id){
        return isMenetlevelRepository.getaAllKm(id);
    }

    public ISmenetlevel updateML(ISmenetlevelRequest iSmenetlevelRequest){
        ISauto isauto = isautoRepository.findById(iSmenetlevelRequest.getAid_id()).get();
        ISmenetlevel iSmenetlevel =  isMenetlevelRepository.findById(iSmenetlevelRequest.getSorszam()).get();
        iSmenetlevel.setSorszam(iSmenetlevelRequest.getSorszam());
        iSmenetlevel.setHonnan(iSmenetlevelRequest.getHonnan());
        iSmenetlevel.setHova(iSmenetlevelRequest.getHova());
        iSmenetlevel.setGepjarmuVezetoNeve(iSmenetlevelRequest.getGepjarmuVezetoNeve());
        iSmenetlevel.setKm(iSmenetlevelRequest.getKm());
        iSmenetlevel.setDatumKezdo(iSmenetlevelRequest.getDatumKezdo());
        iSmenetlevel.setAr(0);
        iSmenetlevel.setAid(isauto);
        return isMenetlevelRepository.save(iSmenetlevel);
    }



}


