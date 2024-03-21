package com.ygy.restapi05.member;

public enum Role {
    USER, ADMIN;

    public static Role fromString(String userRole){
        for(Role role : Role.values()){
            if(role.toString().equalsIgnoreCase(userRole)){
                return role;
            }
        }
        // 여기까지 오면 USER 도 아니도 ADMIN 도 아닌 이상한 userRole 이다?
        return null;
    }
}
