package com.app.module.users.data;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService{
    
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository= repository;
    }

    @Override
    public Flux<Collection<UserEntity>> getAllUsers() {
        return Flux.just(new ArrayList<>());
    }

    @Override
    public Flux<Collection<UserWithRole>> getAllUsersWithRol() {
        return Flux.just(new ArrayList<>());
    }

    @Override
    public Mono<UserEntity> getUserByEmail(String email) {
        return Mono.empty();
    }

    @Override
    public Mono<Long> getUsersQuantity() {
        return repository.count();
    }
    
}
