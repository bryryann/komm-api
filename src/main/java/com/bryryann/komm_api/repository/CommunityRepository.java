package com.bryryann.komm_api.repository;

import com.bryryann.komm_api.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    Community findBySlug(String slug);
}
