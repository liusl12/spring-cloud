package com.liusl.repository;

import com.liusl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by l1 on 2017/8/31.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
