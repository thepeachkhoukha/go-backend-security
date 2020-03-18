package com.lezgo.authentication.entities;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name= "lezgo_user_details")
public class UserDetails {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "university")
    private String university;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "lat")
    private int lat;

    @Column(name = "lng")
    private int lng;

    @Column(name = "image")
    private String image;
}
