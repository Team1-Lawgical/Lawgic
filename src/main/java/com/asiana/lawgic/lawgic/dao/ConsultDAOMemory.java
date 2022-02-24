package com.asiana.lawgic.lawgic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.asiana.lawgic.lawgic.entity.CarType.convertCarTypeToInteger;

public class ConsultDAOMemory implements ConsultDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement preparedStatement;
    private String result;

    public ConsultDAOMemory() {
        conn = DatabaseConnection.getConnection();
    }

    public String getClientById(Long clientId) throws SQLException {
        sql = "SELECT client_name, client_birthday, client_address, client_phone " +
                "FROM client " +
                "WHERE client_id = ?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, clientId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            result = rs.getString("client_name") + " " + rs.getString("client_birthday") + " "
                    + rs.getString("client_address") + " " + rs.getString("client_phone"); // 칼럼 위치로 지정해도 되지만 이름으로 지정명확하게 해줌
        }
        rs.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public String getLawyerById(Long lawyerId) throws SQLException {
        sql = "SELECT lawyer_name FROM lawyer WHERE lawyer_id = ?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, lawyerId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            result = rs.getString("lawyer_id");
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
            preparedStatement.setInt(8, convertCarTypeToInteger(consultVO.getOpponentCarType())); // TODO 수정사항
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
