package com.ygy.restapi05.member;

import org.junit.jupiter.api.Test;

class RoleTest {
    @Test
    public void dummy(){
        for(Role role : Role.values()){
            System.out.println(role);
        }
    }

}