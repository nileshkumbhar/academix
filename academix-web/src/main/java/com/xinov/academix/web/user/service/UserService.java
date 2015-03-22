package com.xinov.academix.web.user.service;

import com.xinov.academix.core.model.User;

public interface UserService {

	User get(String userId, String password);
}
