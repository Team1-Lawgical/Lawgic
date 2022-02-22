package com.asiana.lawgic.lawgic.dao;

import com.asiana.lawgic.lawgic.entity.Category;
import com.asiana.lawgic.lawgic.entity.Lawyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryDAOMemory implements CategoryDAO{
    private String sql;
    private Connection conn;
    public CategoryDAOMemory(){
        sql="";
        conn=DatabaseConnection.getConnection();
    }

    @Override
    public Collection<Lawyer> getAllLawyers() throws SQLException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Lawyer> lawyers=new ArrayList<>();
        Category category=null;
        sql="SELECT address, category_id, email, gender, lawyer_id, name, password, phone, valid from lawyer";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next()){
            Long lawyerId=rs.getLong("lawyer_id");
            String password=rs.getString("password");
            String address=rs.getString("address");
            int categoryId=rs.getInt("category_id");
            String email=rs.getString("email");
            boolean gender=rs.getBoolean("gender");
            String name=rs.getString("name");
            String phone=rs.getString("phone");
            boolean valid=rs.getBoolean("valid");

            if(categoryId==1)
                category=Category.CAR_TO_CAR;
            else if(categoryId==2)
                category=Category.CAT_TO_PERSON;
            else if(categoryId==3)
                category=Category.CAR_ONLY;
            else
                category=Category.RAILROAD_CROSSING;

            Lawyer lawyer=Lawyer.builder().
                    address(address).
                    categoryId(category).
                    email(email).
                    gender(gender).
                    lawyerId(lawyerId).
                    name(name).
                    password(password).
                    phone(phone).
                    valid(valid).
                    build();
            lawyers.add(lawyer);
        }
        return lawyers;
    }
}
