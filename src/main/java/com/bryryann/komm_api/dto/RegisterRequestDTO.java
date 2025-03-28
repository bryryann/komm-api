package com.bryryann.komm_api.dto;

import com.bryryann.komm_api.security.Role;

public record RegisterRequestDTO(String username, String password, Role role) {
}
