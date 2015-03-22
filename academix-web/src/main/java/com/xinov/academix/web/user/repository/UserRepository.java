package com.xinov.academix.web.user.repository;

import com.xinov.academix.core.model.User;

public interface UserRepository {

	User get(String userId, String password);
}
