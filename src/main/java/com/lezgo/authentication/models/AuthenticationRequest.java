package com.lezgo.authentication.models;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRequest implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
