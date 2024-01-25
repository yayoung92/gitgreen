package org.example;

import util.MyCLI;

import javax.management.DescriptorRead;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDB {
    private MyCLI cli = new MyCLI();

    public void insert(){
        Member member = cli.inputMember();
        boolean result = findByEmail(member.getEmail());

        if(!result){
            try{
                Connection con = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
                PreparedStatement pstmt = con.prepareStatement("insert into member " +
                        "(reg_time, update_time, created_by, modified_by, address, email, name, password, role) " +
                        "values " +
                        "(now(),now(),'',''," +
                        "?,?,?,?,'admin')");
                pstmt.setString(1, member.getAddress());
                pstmt.setString(2, member.getEmail());
                pstmt.setString(3, member.getName());
                pstmt.setString(4, member.getPassword());
                pstmt.executeUpdate();
    
            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
            System.out.println("중복되어서 회원가입 실패");
        }
    }

    public boolean findByEmail(String email){

        try{
            Connection conn = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
            PreparedStatement pstmt =
                    conn.prepareStatement("select * from member where email=?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){

                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("회원가입 되었습니다.");
        return false;
    }

    public Member login() {
        Member member = cli.loginMember();
        try{
            Connection conn = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);
            PreparedStatement pstmt = conn.prepareStatement("select * from member "+
                    "where email=? and password=?");
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                member.setRole(rs.getString("role"));
               return member;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
