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
    private String[] opponentName={"김예리","고은지","정다연","김윤환","유인아"};
    private CarType[] opponentCarType={ CarType.CITY_CAR, CarType.COMPACT_CAR, CarType.SPORTS_CAR, CarType.LARGE_SIZE_CAR, CarType.FULL_SIZE_LUXURY_CAR };
    private String[] opponentBirthday = {"1991-02-16", "1990-01-22", "1999-10-11", "1993-12-21", "1991-02-19"};
    private String[] summary={"저는 2차로에서 주행하고, 상대방은 1차로에서 2차로 변경하던 중 후미 사이드와 충돌했습니다. 상대방은 본인 과실 100으로 인정했는데 상대측 보험사에서 갑자기 80:20을 주장합니다. 제가 20% 잘못이 있는지 상담 요청드립니다.\n","저는 로터리에서 주행하고, 상대방은 로터리에 진입하던 중에 전방 충돌했습니다. 상대방은 본인 과실 100으로 인정했는데 상대측 보험사에서 갑자기 50:50을 주장합니다. 제가 50% 잘못이 있는지 상담 요청드립니다.","저는 영동고속도로 가차선에서 주행하고, 상대방은 차선 변경 중에 후미와 충돌했습니다. 상대방은 본인 과실 50으로 인정했는데, 제가 50%나 잘못이 있는지 상담 요청드립니다.\n"};
    private String[] address = {"경기도 시흥시 능곡동 809 시흥능곡지구 수질복원센터", "경기도 화성시 남양읍 장덕리 801", "경기도 수원시 권선구 세류동 1101-1 수원 채움 요양원", "경기도 성남시 분당구 서현동 277 분당세무서", "경기도 안양시 동안구 호계동 898-21"};
    private String[] judgement = {"상대방 과실이 100임을 인정받고자 합니다.", "상대방 과실이 80임을 인정받고자 합니다.", "상대방 과실이 50임을 인정받고자 합니다.\n", " 서울시 염창동", "서울시 관악구"};
    private String[] comment = {"분심위까지 가는 상황은 만들고 싶지 않습니다. 잘 부탁드립니다.", "소송까지 가는 상황은 만들고 싶지 않습니다. 잘 부탁드립니다.", "미디어에 노출 되는 상황은 만들고 싶지 않습니다. 잘 부탁드립니다.", " 서울시 염창동", "서울시 관악구"};
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

        IntStream.rangeClosed(1, 3).forEach(i -> {
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
                    .judgement(judgement[i-1])
                    .comments(comment[i-1])
                    .summary(summary[i-1])
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
