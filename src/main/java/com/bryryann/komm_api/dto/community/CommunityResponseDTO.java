package com.bryryann.komm_api.dto.community;

import java.math.BigInteger;
import java.util.Date;

public record CommunityResponseDTO(
        long communityId,
        String name,
        String slug,
        String description,
        BigInteger createdBy,
        Date createdAt,
        Date updatedAt,
        boolean isPrivate,
        int memberCount
) {
}
