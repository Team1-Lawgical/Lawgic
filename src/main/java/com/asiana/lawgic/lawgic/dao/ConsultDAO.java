package com.asiana.lawgic.lawgic.dao;

import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.vo.ConsultVO;

import java.sql.SQLException;
import java.util.Optional;

public interface ConsultDAO {

    // 상담신청서에 작성할 고객의 정보 가져오기
    String getClientById(Long clientId, Long lawyerId) throws SQLException;

    // 상담신청서 작성하기
    void saveConsult(ConsultVO consultVO);
}
