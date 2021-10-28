package com.codegym.repository;

import com.codegym.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    //    Kiet login 23/10 Query account with username to verify httpBasic
    @Query(value = "select * from account a where a.account_username= ?1", nativeQuery = true)
    Account findAccountByUsername(String username);

    //    Kiet login 26/10 insert account but not active
    @Modifying
    @Query(value = "insert into account (account_username, account_password, email, activated_flag, delete_flag, lock_flag) " +
            "values (?1, ?2, ?3, 0, 0, 1)", nativeQuery = true)
    void signUpAccount(@Param("account_username") String username, @Param("account_password") String password, @Param("email") String email);

    //  Kiet login 26/10 set role user cho tai khoan vua moi dang ky
    @Modifying
    @Query(value = "insert into account_role (account_id, role_id) values(?1, 2)", nativeQuery = true)
    void setRoleForUser(@Param("account_id") int idOfAccount);

    @Modifying
    @Query(value = "update account set activated_flag = 1 where email = ?1", nativeQuery =true)
    void enableActiveAccount(@Param("email") String email);

    //HauPT do getAccountById function
    @Query(value = "select " +
            " account_id, email, account_password, account_username, activated_flag, delete_flag, lock_flag" +
            " from `account` a where a.account_id = :id", nativeQuery = true)
    Account getAccountById(int id);

    //HauPT do editPassword function
    @Modifying
    @Query(value = "update `sprint1`.`account` set account_password = ?2 where (account_id = ?1);", nativeQuery = true)
    void editPassword(Integer id ,String password);

}
