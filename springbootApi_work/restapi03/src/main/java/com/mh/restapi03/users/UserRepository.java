package com.mh.restapi03.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // select * from user where email = ? 자동으로 던져준다.
    public User findByEmail(String email);

}
