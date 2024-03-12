package com.app.module.users.data;

import java.util.Collection;
import jakarta.annotation.Nonnull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    
    Flux<Collection<UserEntity>> getAllUsers();
    Flux<Collection<UserWithRole>> getAllUsersWithRol();
    Mono<UserEntity> getUserByEmail(@Nonnull String email);

}
