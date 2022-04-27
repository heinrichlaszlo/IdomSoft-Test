package com.example.demo.service;

import com.example.demo.dao.ISautoRepository;
import com.example.demo.dao.ISmenetlevelRepository;
import com.example.demo.entity.ISauto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISautoService {

    private final ISautoRepository isAutoRepository;

    private final ISmenetlevelRepository iSmenetlevelRepository;


    public ISautoService(ISautoRepository isAutoRepository, ISmenetlevelRepository iSmenetlevelRepository) {
        this.isAutoRepository = isAutoRepository;
        this.iSmenetlevelRepository = iSmenetlevelRepository;
    }


    public List<ISauto> findAllauto(){
        return isAutoRepository.findAll();
    }

    public ISauto updateIsauto(Long id){
        ISauto isauto = isAutoRepository.findById(id).get();
        Integer ar;
        ar = iSmenetlevelRepository.getaAllAr(id);
        isauto.setOsszar(ar);
        return isAutoRepository.save(isauto);
    }

    public ISauto updateIsautoKm(Long id){
        ISauto isauto = isAutoRepository.findById(id).get();
        Integer km;
        km = iSmenetlevelRepository.getaAllKm(id);
        isauto.setOsszkm(km);
        return isAutoRepository.save(isauto);
    }
}
