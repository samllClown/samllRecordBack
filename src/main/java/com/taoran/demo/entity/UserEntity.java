package com.taoran.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userUuid;

}
