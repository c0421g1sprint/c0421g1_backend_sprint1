
package com.codegym.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccountDto {
    @NotBlank
    @NotNull
    private String accountUsername;
    @NotBlank
    @NotNull
    private String accountPassword;
    @Pattern(regexp = "^[a-zA-Z0-9]+\\@[a-z]+\\.[a-z]+$")
    private String email;
    private final boolean activated_flag = false;
    private final boolean lock_flag = true;
    private final boolean delete_flag = false;

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated_flag() {
        return activated_flag;
    }

    public boolean isLock_flag() {
        return lock_flag;
    }

    public boolean isDelete_flag() {
        return delete_flag;
    }
}
