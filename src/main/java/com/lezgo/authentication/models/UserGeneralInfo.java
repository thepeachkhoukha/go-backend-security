package com.lezgo.authentication.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserGeneralInfo {
    private String city;
    private double lat;
    private double lng;
    private String image;
}
