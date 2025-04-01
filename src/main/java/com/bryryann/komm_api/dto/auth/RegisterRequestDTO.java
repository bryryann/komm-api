package com.bryryann.komm_api.dto.auth;

import com.bryryann.komm_api.security.Role;

public record RegisterRequestDTO(String username, String password, Role role) {
}
