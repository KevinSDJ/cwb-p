package com.app.module.users.data;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Table("users")
public class UserEntity {
    
    @Id
    private UUID id;
    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull String fullname;
    private @NonNull String email;
    private @NonNull String password;
}
