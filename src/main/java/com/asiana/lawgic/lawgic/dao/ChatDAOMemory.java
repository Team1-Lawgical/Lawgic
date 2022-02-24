package com.asiana.lawgic.lawgic.dao;

//import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Message;
import com.asiana.lawgic.lawgic.entity.MessageType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ChatDAOMemory implements ChatDAO{
    private String sql;
    private Connection conn;
    public ChatDAOMemory(){
        sql="";
        conn=DatabaseConnection.getConnection();
    }
    @Override
    public void createChat(Consult consult) throws SQLException {
        String newChatId=UUID.randomUUID().toString().replace("-","");
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        sql="INSERT INTO chat VALUES ('"+newChatId+"', '"+
                consult.getClient().getClientId()+"', '"+
                consult.getConsultId()+"', '"+
                consult.getLawyer().getLawyerId()+"')";

        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();

        rs.close();
        pstmt.close();
    }

    @Override
    public void saveMessages(String chatId, Message message) throws SQLException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        sql="INSERT INTO message VALUES ('"+chatId+"', '"+
                message.getContent()+"', '"+
                message.getRegDate()+"', '"+
                message.getSender()+"', '"+
                message.getType()+"')";

        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();

        rs.close();
        pstmt.close();

    }

    @Override
    public Collection<String> getChatIdsByClientId(String clientId) throws SQLException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        List<String> chatIds=new ArrayList<>();

        sql="SELECT chat_id FROM chat WHERE client_id=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,clientId);

        rs = pstmt.executeQuery();

        while(rs.next()){
            chatIds.add(rs.getString("chat_id"));
        }

        rs.close();
        pstmt.close();
        return chatIds;
    }

    @Override
    public Collection<Message> getMessagesByChatId(String chatId) throws SQLException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        List<Message> messages=new ArrayList<>();

        sql="SELECT chat_id, content, regdate, sender, type FROM message WHERE chatId=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,chatId);

        rs = pstmt.executeQuery();

        while(rs.next()){
            String content=rs.getString("content");
            String sender=rs.getString("sender");
            int type=rs.getInt("type");
            MessageType messageType;
            if(type==0)
                messageType=MessageType.CHAT;
            else if(type==1)
                messageType=MessageType.JOIN;
            else
                messageType=MessageType.LEAVE;

            Message msg=Message.builder().content(content).
                    sender(sender).
                    type(messageType).
                    build();

            messages.add(msg);
        }

        rs.close();
        pstmt.close();
        return messages;
    }
}
