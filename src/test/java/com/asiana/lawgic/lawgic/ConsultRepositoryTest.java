package com.asiana.lawgic.lawgic;

import com.asiana.lawgic.lawgic.dto.ClientDTO;
import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.entity.Client;
import com.asiana.lawgic.lawgic.entity.Consult;
import com.asiana.lawgic.lawgic.entity.Lawyer;
import com.asiana.lawgic.lawgic.repository.ClientRepository;
import com.asiana.lawgic.lawgic.repository.ConsultRepository;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ConsultRepositoryTest {
    private String[] appointmentDate = {"2022-01-16", "2022-06-25", "2022-04-12", "2022-01-23", "2022-01-11"};
    private String[] opponentPhone={"01034523623","01046234324","01045233734","01036239385","01035236343"};
    private String[] opponentName={"이윤성","서유리","정다은","김은성","고윤정"};
    private CarType[] opponentCarType={ CarType.CITY_CAR, CarType.COMPACT_CAR, CarType.SPORTS_CAR, CarType.LARGE_SIZE_CAR, CarType.FULL_SIZE_LUXURY_CAR };
    private String[] opponentBirthday = {"1995-03-16", "1996-04-25", "1997-12-24", "1993-06-23", "1997-02-12"};
    private String[] address = {"경기도 시흥시", "경기도 화성시", "서울시 화곡동", " 서울시 염창동", "서울시 관악구"};
    private String[] judgement = {"경기도 시흥시", "경기도 화성시", "서울시 화곡동", " 서울시 염창동", "서울시 관악구"};
    private String[] comment = {"경기도 시흥시", "경기도 화성시", "서울시 화곡동", " 서울시 염창동", "서울시 관악구"};
    @Autowired
    private ConsultRepository consultRepository;
    @Autowired
    private LawyerRepository lawyerRepository;
    @Autowired
    ClientRepository clientRepository;
    @Test
    public void consultInsertData(){
        Object[] lawyers=lawyerRepository.getAllLawyers();
        Object[] clients=clientRepository.getAllClients();

        IntStream.rangeClosed(1, 5).forEach(i -> {
            Lawyer lawyer=((Lawyer)lawyers[i-1]);
            Client client=((Client)clients[i-1]);
            Consult consult=Consult.builder()
                    .appointmentDate(Date.valueOf(appointmentDate[i-1]))
                    .lawyer(lawyer)
                    .client(client)
                    .summary("summary "+i)
                    .opponentPhone(opponentPhone[i-1])
                    .opponentName(opponentName[i-1])
                    .opponentCarType(opponentCarType[i-1])
                    .opponentBirthday(Date.valueOf(opponentBirthday[i-1]))
                    .opponentAddress(address[i-1])
                    .judgement("judgement "+i)
                    .comments("comment "+i)
                    .build();
            consultRepository.save(consult);

        });
    }
    @Test
    public void getConsultByLawyerAndClientIdTest(){
        Consult consult=consultRepository.getConsultByLawyerAndClientId(6L,1L);
        System.out.println("consult:"+consult.getConsultId());
    }
    @Test
    public void getLawyersByClientId(){
        Object[] lawyers=consultRepository.getLawyersByClientId(1L);
        for(Object o:lawyers){
            System.out.println(((Lawyer)o).getName());
        }
    }
    @Test
    public void getClientsByLawyerId(){
        Object[] clients=consultRepository.getClientsByLawyerId(6L);
        for(Object o:clients){
            System.out.println(((Client)o).getName());
        }
    }
}
