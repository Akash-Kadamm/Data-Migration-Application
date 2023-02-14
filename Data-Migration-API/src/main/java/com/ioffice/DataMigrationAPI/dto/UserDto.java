package com.ioffice.DataMigrationAPI.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;

    private String userName;

    private String userCompanyName;

}
