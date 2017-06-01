package com.wd.until;

import java.util.UUID;

/**
 * Created by aaa on 2017/4/11.
 */
public class createUUIdUntil {
    public static String createUUid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().trim().replaceAll("-", "");
    }
}
