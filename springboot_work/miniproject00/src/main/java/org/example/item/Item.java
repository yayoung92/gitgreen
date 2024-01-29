package org.example.item;

import lombok.*;
@Data
@Builder
public class Item {
    private long item_id;       // 자동증가
    private String reg_time;    // 현재시간
    private String update_time; // 수정시간
    private String created_by;  // 로그인시간
    private String modified_by; // 로그아웃시간

    private String item_nm;     // 상품 이름
    private String item_detail; // 상품 상세정보
    private String item_sell_status;    // 상품 판매여부(상태)
    private int price;          // 상품 가격
    private int stock_number;   // 상품 재고
}
