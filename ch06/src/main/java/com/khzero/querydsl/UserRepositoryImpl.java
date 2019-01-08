package com.khzero.querydsl;

import com.khzero.model.QUserEntity;
import com.khzero.model.UserEntity;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {
    public UserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public List<UserEntity> findAllLike(String keyword) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        JPQLQuery<UserEntity> query = from(qUserEntity);
        return query.where(qUserEntity.userName.like(keyword)).fetch();
    }

    @Override
    public int maxAge() {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        return from(qUserEntity).select(qUserEntity.age.max()).fetchOne();
    }

    @Override
    public int minAge() {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        return from(qUserEntity).select(qUserEntity.age.min()).fetchOne();
    }
}