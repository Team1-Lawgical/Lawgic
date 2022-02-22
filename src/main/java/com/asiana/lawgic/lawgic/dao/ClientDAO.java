package com.asiana.lawgic.lawgic.dao;

import java.sql.SQLException;

//import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.vo.ClientVO;

public interface ClientDAO {
    // CarType
//    CarType convertToCarType(int num);

    // 새 client 추가
    void registerClient(ClientVO vo) throws SQLException;

    // 중복 이메일인지 체크 (로그인 아이디로 사용)
    String emailExistsCheck(String email) throws SQLException;

    // email로 client 검색
    ClientVO findClientByEmail(String email) throws SQLException;

    // id로 client 검색
    ClientVO findClientById(int clientId) throws SQLException;

}
