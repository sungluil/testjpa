package com.example.testjpa.settings;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class PasswordForm {

    @Length(min = 3, max = 20)
    private String newPassword;

    @Length(min = 3, max = 20)
    private String newPasswordConfirm;
}
