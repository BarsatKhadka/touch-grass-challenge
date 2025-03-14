package com.barsat.touch_grass.Response;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResposne {

    String jwtToken;
    String message;
}