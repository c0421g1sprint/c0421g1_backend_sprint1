package com.codegym.repository;

import com.codegym.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT into user_roles (account_id,role_id) values (?1,?2) ", nativeQuery = true)
    void saveRole(Long account_id, Long role_id);

    @Transactional
    @Modifying
    @Query(value = "INSERT into account (account_username,account_password,activated_flag,lock_flag,delete_flag) values (?1,?2,0,1,0) ", nativeQuery = true)
    void saveQuery(String accountUsername, String accountPassword);

    @Query(value = "select * from account where account.account_id = ?1", nativeQuery = true)
    Optional<Account> findByIdQuery(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE teacher set account_id = ?1 where teacher_id = ?2 ", nativeQuery = true)
    void updateIdAccountTeacher(Integer teacherId,Integer accountId);
}

