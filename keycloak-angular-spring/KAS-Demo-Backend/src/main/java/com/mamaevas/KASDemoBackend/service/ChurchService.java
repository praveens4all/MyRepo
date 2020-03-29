package com.mamaevas.KASDemoBackend.service;

import com.mamaevas.KASDemoBackend.entity.Church;
import com.mamaevas.KASDemoBackend.repositories.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChurchService {

    private final ChurchRepository churchRepository;

    @Autowired
    public ChurchService(ChurchRepository churchRepository) {
        this.churchRepository = churchRepository;
    }


    public Church getChurchByName(String churchName){
        return churchRepository.findByChurchName(churchName);
    }
}
