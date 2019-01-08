package com.khzero.querydsl;

import com.khzero.model.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> findAllLike(String keyword);

    int maxAge();

    int minAge();
}
