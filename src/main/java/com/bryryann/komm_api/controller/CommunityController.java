package com.bryryann.komm_api.controller;

import com.bryryann.komm_api.dto.community.CommunityResponseDTO;
import com.bryryann.komm_api.dto.community.NewCommunityRequestDTO;
import com.bryryann.komm_api.mapper.CommunityMapper;
import com.bryryann.komm_api.model.Community;
import com.bryryann.komm_api.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/community")
public class CommunityController {

    private final CommunityRepository repository;
    private final CommunityMapper mapper;

    @Autowired
    public CommunityController(CommunityRepository repository, CommunityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommunityResponseDTO>> allCommunities() {
        List<Community> communities = repository.findAll();
        List<CommunityResponseDTO> response = communities
                .stream()
                .map(mapper::toCommunityResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity newCommunity(@RequestBody NewCommunityRequestDTO dto) {
        // TODO: Implement newCommunity() route.
        return ResponseEntity.ok().build();
    }

}
