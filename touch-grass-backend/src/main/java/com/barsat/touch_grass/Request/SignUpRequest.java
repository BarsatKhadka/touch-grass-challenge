package com.barsat.touch_grass.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class SignUpRequest {

    private String username;

    private String email;

    private String password;
}
