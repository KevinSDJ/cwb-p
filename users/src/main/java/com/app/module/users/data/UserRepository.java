package com.app.module.users.data;

import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UserRepository extends R2dbcRepository<UserEntity,UUID>{
    
}
