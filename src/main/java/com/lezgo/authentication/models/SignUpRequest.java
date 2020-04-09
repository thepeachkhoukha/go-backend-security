package com.lezgo.authentication.models;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SignUpRequest {
    @Valid
    private String username;

    @Valid
    private String password;

    @Valid
    private String name;

    @Valid
    private String location;

    @Valid
    private String university;

    @Valid
    private String occupation;

    @NotNull
    private int lat;

    @NotNull
    private int lng;

    @NotNull
    private String image;
}
