package com.bryryann.komm_api.dto.community;

public record NewCommunityRequestDTO(
        String name,
        String slug,
        String description,
        boolean isPrivate
) {

}
