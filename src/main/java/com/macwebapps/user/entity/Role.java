package com.macwebapps.user.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by froilan.macugay@pictureworks.com.au on 26/4/17.
 */
public enum Role {

    ADMIN, PREMIUM_MEMBER, MEMBER;

    public String authority() {
        return "ROLE_" + this.name();
    }


    private static Map<String, Role> namesMap = new HashMap<String, Role>(3);

    static {
        namesMap.put("ADMIN", ADMIN);
        namesMap.put("PREMIUM_MEMBER", PREMIUM_MEMBER);
        namesMap.put("MEMBER", MEMBER);
    }

    @JsonCreator
    public static Role forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }
}
