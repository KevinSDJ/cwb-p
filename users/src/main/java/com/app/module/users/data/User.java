package com.app.module.users.data;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Table("USER")
public class User {
    
    @Id
    private UUID id;
    private @NonNull String name;
}
