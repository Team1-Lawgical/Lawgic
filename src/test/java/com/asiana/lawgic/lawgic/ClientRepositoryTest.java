package com.asiana.lawgic.lawgic;

import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClientRepositoryTest {
    private String[] address = {"경기도 시흥시", "경기도 화성시", "서울시 화곡동", " 서울시 염창동", "서울시 관악구"};
    private String[] birthday = {"1995-03-16", "1996-04-25", "1997-12-24", "1993-06-23", "1997-02-12"};
    private CarType[] carType = { CarType.CITY_CAR, CarType.COMPACT_CAR, CarType.SPORTS_CAR, CarType.LARGE_SIZE_CAR, CarType.FULL_SIZE_LUXURY_CAR };
    private String[] email = {"young@naver.com", "teddy@nate.com", "catherine@yahoo.com", "jessy@gmail.com", "sung@naver.com"};
    private String[] name = {"유영균", "김정현", "박동은", "이연하", "이유리"};
    private String[] password = {"sddfjj@", "2324gsddf!", "we$#SD", "TS3wddfs", "w32345SD"};
    private String[] phone = {"01033426442", "01055236442", "01042365723", "01054625245", "01094358343"};

    @Autowired
    private ClientRepository clientRepository;


//    @Test
//    public void clientInsertData() {
//        IntStream.rangeClosed(1, 5).forEach(i -> {
//
//
//            Client client = Client.builder()
//                    .address(address[i - 1])
//                    .birthday(java.sql.Date.valueOf(birthday[i - 1]))
//                    .carType(carType[i - 1])
//                    .email(email[i - 1])
//                    .gender((Math.round(Math.random()) == 1L ? 1 : 0))
//                    .name(name[i - 1])
//                    .password(password[i - 1])
//                    .phone(phone[i - 1])
//                    .build();
//            if(clientRepository==null){
//                System.out.println("null 임");
//            }
//            clientRepository.save(client);
//
//        });
//    }

    @Test
    public void getClientByEmailTest(){
        Optional<Client> result=clientRepository.findClientByEmail("young@naver.com");
//        if(result.isPresent()){
//            System.out.println("이미 존재하는 이메일");
//        }else{
//            System.out.println("사용가능한 이메일");
//        }
        System.out.println(result.toString());
    }
}
