package com.educavalieri.interfaceIt.dtos;

import com.educavalieri.interfaceIt.entities.User;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MessageDto {

    private String text;
    private Integer code;
    private Long userId;


}
