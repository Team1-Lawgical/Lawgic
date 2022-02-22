package com.asiana.lawgic.lawgic.dao;

import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.vo.ClientVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static com.asiana.lawgic.lawgic.entity.CarType.convertToCarType;

public class ClientDAOMemory implements ClientDAO {
    private String sql;
    private Connection conn;

    public ClientDAOMemory() {
        sql = "";
        conn = DatabaseConnection.getConnection();
    }

//    @Override
//    public CarType convertToCarType(int num) {
//        CarType ct = null;
//        switch(num) {
//            case 1:
//                ct = CarType.CITY_CAR;
//                break;
//            case 2:
//                ct = CarType.SUBCOMPACT_CAR;
//                break;
//            case 3:
//                ct = CarType.COMPACT_CAR;
//                break;
//            case 4:
//                ct = CarType.MID_SIZE_CAR;
//                break;
//            case 5:
//                ct = CarType.FULL_SIZE_LUXURY_CAR;
//                break;
//            case 6:
//                ct = CarType.LARGE_SIZE_CAR;
//                break;
//            case 7:
//                ct = CarType.SPORTS_CAR;
//                break;
//        }
//        return ct;
//    }

    @Override
    public void registerClient(ClientVO vo) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "INSERT INTO client VALUES ('" +
                vo.getClientId() + "', '" +
                vo.getAddress() + "', '" +
                vo.getBirthday() + "', '" +
                vo.getCarType() + "', '" +
                vo.getEmail() + "', '" +
                vo.getGender() + "', '" +
                vo.getName() + "', '" +
                vo.getPassword() + "', '" +
                vo.getPhone() + "')";

        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        rs.close();
        pstmt.close();
    }

    @Override
    public String emailExistsCheck(String email) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        sql = "SELECT count(*) FROM client WHERE email=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            count = rs.getInt(1);
        }

        rs.close();
        pstmt.close();

        return (count == 0) ? "email ok" : "email fail";
    }

    @Override
    public ClientVO findClientByEmail(String email) throws SQLException {
        ClientVO vo = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "SELECT client_id, address, birthday, car_type, email, gender, name, password, phone "
                + "FROM client WHERE email=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        rs = pstmt.executeQuery();

        int carTypeNum = rs.getInt("car_type");

        if (rs.next()) {
            vo = new ClientVO(rs.getLong("client_id"),
                    rs.getString("address"),
                    rs.getDate("birthday"),
                    convertToCarType(carTypeNum),
                    rs.getString("email"),
                    rs.getInt("gender"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("phone")
            );
        }
        rs.close();
        pstmt.close();

        return vo;
    }

    @Override
    public ClientVO findClientById(int clientId) throws SQLException {
        ClientVO vo = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "SELECT client_id, address, birthday, car_type, email, gender, name, password, phone "
                + "FROM client WHERE client_id=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, clientId);
        rs = pstmt.executeQuery();
        int carTypeNum = rs.getInt("car_type");

        if (rs.next()) {
            vo = new ClientVO(rs.getLong("client_id"),
                    rs.getString("address"),
                    rs.getDate("birthday"),
                    convertToCarType(carTypeNum),
                    /* 1부터
                     * CITY_CAR, SUBCOMPACT_CAR, COMPACT_CAR, MID_SIZE_CAR, FULL_SIZE_LUXURY_CAR, LARGE_SIZE_CAR, SPORTS_CAR
                     * */
                    rs.getString("email"),
                    rs.getInt("gender"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("phone")
            );
        }
        rs.close();
        pstmt.close();

        return vo;
    }
}
