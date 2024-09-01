package com.example.putera_demo.v1.users.repository;

import com.example.putera_demo.v1.users.model.entity.Role;
import com.example.putera_demo.v1.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @NonNull
    Optional<User> findById(@NonNull String id);
}
