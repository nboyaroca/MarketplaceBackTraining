package com.factoria.marketplace.services;

import com.factoria.marketplace.models.User;

public interface IUserService {
    User getById(Long id);
}
