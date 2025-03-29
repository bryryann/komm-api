package com.bryryann.komm_api.controller;

import com.bryryann.komm_api.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/community")
public class CommunityController {

    private final CommunityRepository repository;

    @Autowired
    public CommunityController(CommunityRepository repository) {
        this.repository = repository;
    }

}
