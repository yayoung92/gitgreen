package org.example.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor  // 모든 생성자 만드는 lombok 예약어
public class AA {
    private String name;

    public AA(String name){
        this.name = name;
    }
}
