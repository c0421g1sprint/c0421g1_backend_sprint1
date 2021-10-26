package com.codegym.entity.about_account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Validator {
    private Integer accountId;
    @NotBlank(message = "please input code")
    private String accountUsername;
    @NotBlank
    private String accountPassword;
    private String accountEmail;
    private boolean activated_flag;
    private boolean lock_flag;
    private boolean delete_flag;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        if (!accountDto.accountUsername.matches("^[a-z]{8,20}$")) {
            errors.rejectValue("accountUsername", "account.accountUsername", "accountUsername format xxxxx or xxxxxxx[<20]");
        }
        if (!accountDto.accountPassword.matches("^[a-z]{5,20}$")) {
            errors.rejectValue("accountPassword", "account.accountPassword", "pass format XXXXXXXXX or XXXXXXXXXXXX ");
        }
    }
}
