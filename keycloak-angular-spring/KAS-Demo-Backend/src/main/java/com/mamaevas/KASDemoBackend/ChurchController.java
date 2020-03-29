package com.mamaevas.KASDemoBackend;

import com.mamaevas.KASDemoBackend.entity.Church;
import com.mamaevas.KASDemoBackend.service.ChurchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/church")
public class ChurchController {

    private static final Logger log = LoggerFactory.getLogger(ChurchController.class);

    private ChurchService churchService;

    @Autowired
    public ChurchController(ChurchService churchService) {
        this.churchService = churchService;
    }

    @GetMapping("/getChurchByName")
    public Church getChurch(@RequestParam(defaultValue = "Acts church") String churchName){

        return churchService.getChurchByName(churchName);

    }
}
