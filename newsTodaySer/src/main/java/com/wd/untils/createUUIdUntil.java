package com.wd.untils;

import java.util.UUID;

/**
 * Created by aaa on 2017/4/11.
 */
public class createUUIdUntil {
    public static String createUUid() {
        UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString().trim().replaceAll("-", "");
    }
}
