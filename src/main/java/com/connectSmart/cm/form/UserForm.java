package com.connectSmart.cm.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3,message = "Min 3 character is required")
    private String name;
    @Size(min = 8,max = 12,message = "Invalid phone number")
    private String phoneNumber;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Min 6 character required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;

}
