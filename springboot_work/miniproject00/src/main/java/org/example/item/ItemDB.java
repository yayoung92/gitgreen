package org.example.item;

import org.example.DBINFO;
import org.example.util.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDB {
    private ItemCLI icli = new ItemCLI();
    public void insert() throws Exception{
        System.out.println("상품 등록 기능 만들계획");
        Item item = icli.inputItem();

        Connection conn = null;        // db 연결객체
        PreparedStatement pstmt = null; // sql 문장 담기

        try{
            conn = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
            pstmt = conn.prepareStatement("INSERT INTO item " +
                    "(reg_time, update_time, created_by, modified_by, " +
                    "item_detail, item_nm, item_sell_status, price, stock_number) " +
                    "VALUES " +
                    "(NOW(), NOW(), ?, ?, " +
                    "?, ?, ?, ?, ?);");
            pstmt.setString(1, Login.member.getName());
            pstmt.setString(2, Login.member.getName());
            pstmt.setString(3, item.getItem_detail());
            pstmt.setString(4, item.getItem_nm());
            pstmt.setString(5, item.getItem_sell_status());
            pstmt.setInt(6, item.getPrice());
            pstmt.setInt(7, item.getStock_number());

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
            pstmt.close();
        }
    }

    public void select(){
        List<Item> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
            pstmt = con.prepareStatement("select * from item");
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(
                    new Item(rs.getLong("item_id"),
                            rs.getString("reg_time"),
                            rs.getString("update_time"),
                            rs.getString("created_by"),
                            rs.getString("modified_by"),
                            rs.getString("item_nm"),
                            rs.getString("item_detail"),
                            rs.getString("item_sell_status"),
                            rs.getInt("price"),
                            rs.getInt("stock_number"))
                );
            }
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i).getItem_id()+"\t");
                System.out.print(list.get(i).getItem_nm()+"\t");
                System.out.print(list.get(i).getItem_sell_status()+"\t");
                System.out.print(list.get(i).getItem_detail()+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
