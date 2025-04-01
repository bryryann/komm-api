package com.bryryann.komm_api.mapper;

import com.bryryann.komm_api.dto.community.CommunityResponseDTO;
import com.bryryann.komm_api.model.Community;
import org.springframework.stereotype.Component;

@Component
public class CommunityMapper {

    public CommunityResponseDTO toCommunityResponseDTO(Community community) {
        return new CommunityResponseDTO(
                community.getCommunityId(),
                community.getName(),
                community.getSlug(),
                community.getDescription(),
                community.getCreatedBy(),
                community.getCreatedAt(),
                community.getUpdatedAt(),
                community.isPrivate(),
                community.getMemberCount()
        );
    }
}
