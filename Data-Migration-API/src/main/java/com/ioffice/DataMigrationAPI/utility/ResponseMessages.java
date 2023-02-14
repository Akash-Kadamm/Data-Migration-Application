package com.ioffice.DataMigrationAPI.utility;

import jakarta.persistence.SecondaryTable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseMessages {


        USER_ALREADY_MIGRATED("This User already migrated."),
        USER_NOT_EXISTS("User not exists. "),
        USER_REGISTERED("User registered."),
        USER_ALREADY_REGISTERED("User already exists."),
        USER_DELETED("User deleted."),
        USER_FAILED_TO_DELETE("User failed to delete."),
        USER_FAILED_TO_UPDATE("User failed to update."),
        USER_UPDATED("User updated."),
        USER_REGISTRATION_FAILED("User failed to registration.");



        private String message;
}
