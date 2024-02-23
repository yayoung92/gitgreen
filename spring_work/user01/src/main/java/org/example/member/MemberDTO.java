package org.example.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {

     private String emil;
     private String name;
     private String password;
     private String confirmPassword;

     public boolean isEqualsPassword(){
         return password.equals(confirmPassword);
     }

}
