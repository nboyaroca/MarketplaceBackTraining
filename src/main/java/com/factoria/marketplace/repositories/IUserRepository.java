package com.factoria.marketplace.repositories;

import com.factoria.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
