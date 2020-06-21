package org.example.alvin.repository;

import org.example.alvin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);

    User findByUserName(String userName);

    Integer countByUserNameAndPassword(String userName, String password);

}
