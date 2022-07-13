package com.educavalieri.interfaceIt.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;

}
