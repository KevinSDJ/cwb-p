package com.app.module.users.data;

import java.util.Set;
import java.util.UUID;

public record UserWithRole(
    UUID id,
    String name,
    String surname,
    String fullname,
    String email,
    String password,
    Set<Role> role) {
    
}
