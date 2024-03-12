package com.app.module.users.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("roles")
public class Role {
    
    @Id
    private long id;
    private @Nonnull String name;
}
