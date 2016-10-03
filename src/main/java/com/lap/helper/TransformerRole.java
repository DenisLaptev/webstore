package com.lap.helper;

import com.lap.Role;

/**
 * Created by lapte on 15.09.2016.
 */
public class TransformerRole {

    public static Role transformRoleSqlToRole(String role) {
        if (role.equalsIgnoreCase("1")) {
            return Role.ADMIN;
        } else {
            return Role.USER;
        }
    }
}
