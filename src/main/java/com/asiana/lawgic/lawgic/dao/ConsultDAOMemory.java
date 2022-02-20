package com.asiana.lawgic.lawgic.dao;

import com.asiana.lawgic.lawgic.vo.ConsultVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultDAOMemory implements ConsultDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement preparedStatement;
    private String result;

    public ConsultDAOMemory() {
        conn = DatabaseConnection.getConnection();
    }

    @Override
    public String getClientById(Long clientId, Long lawyerId) throws SQLException {
        sql = "SELECT appointment_date, lawyer_name, client_name, client_birthday, client_address, client_phone " +
                "FROM client c1, lawyer l1, consult c2 " +
                "WHERE c2.client_id = ? AND c2.lawyer_id = ? AND c1.client_id = c2.client_id AND l1.lawyer_id = c2.lawyer_id";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, clientId);
        preparedStatement.setLong(2, lawyerId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            result = rs.getString("appointment_date") + " " + rs.getString("lawyer_name") + " "
                    + rs.getString("client_name") + " " + rs.getString("client_birthday") + " "
                    + rs.getString("client_address") + " " + rs.getString("client_phone"); // 칼럼 위치로 지정해도 되지만 이름으로 지정명확하게 해줌
        }
        rs.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void saveConsult(ConsultVO consultVO) { // 실제 데이터를 넣을 때, PK 전략을 AUTO 증가로 설정하면 consult_id가 안 쓰이지 않을까
        try {
            sql = "INSERT INTO consult(consult_id, appointment_date, lawyer_id, opponent_name, opponent_address, " +
                    "opponent_birthday, opponent_phone, opponent_car_type, comments, judgement, summary, client_id) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, consultVO.getConsultId());
            preparedStatement.setString(2, consultVO.getAppointmentDate());
            preparedStatement.setLong(3, consultVO.getLawyerId());
            preparedStatement.setString(4, consultVO.getOpponentName());
            preparedStatement.setString(5, consultVO.getOpponentAddress());
            preparedStatement.setString(6, consultVO.getOpponentBirthday());
            preparedStatement.setString(7, consultVO.getOpponentPhone());
            preparedStatement.setString(8, consultVO.getOpponentCarType().toString()); // TODO 수정사항
            preparedStatement.setString(9, consultVO.getComments());
            preparedStatement.setString(10, consultVO.getJudgement());
            preparedStatement.setString(11, consultVO.getSummary());
            preparedStatement.setLong(12, consultVO.getClientId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("정상 insert 되었습니다");
    }
}
