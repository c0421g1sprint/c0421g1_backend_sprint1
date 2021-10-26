package com.codegym.repository;

import com.codegym.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    //HauPT do getAccountById function
    @Query(value = "select " +
            " account_id, account_email, account_password, account_username, activated_flag, delete_flag, lock_flag" +
            " from `account` a where a.account_id = :id", nativeQuery = true)
    Account getAccountById(int id);

    //HauPT do editPassword function
    @Modifying
    @Query(value = "update `sprint1`.`account` set account_password = ?2 where (account_id = ?1);", nativeQuery = true)
    void editPassword(Integer id ,String password);

}
