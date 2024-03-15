package com.mh.restapi03.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // select * from user where email = ? 자동으로 던져준다.
    public User findByEmail(String email);

    // select * from user where email =? and password =?;
    public User findByEmailAndPassword(String email, String password);

    // select * from user where username like '%길동%'  자동으로 like 구문 만들어 준다.
    //public User findByUsernameContaining(String username);
    public List<User> findByUsernameContainingOrEmailContaining(String username, String email);

    // JPQL Queydsl
    //@Query(value = "select m from User m where m.email = :emil")
    //public User findMyCustom(String email);
}
