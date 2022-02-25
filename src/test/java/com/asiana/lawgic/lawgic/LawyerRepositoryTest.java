package com.asiana.lawgic.lawgic;

import com.asiana.lawgic.lawgic.entity.CarType;
import com.asiana.lawgic.lawgic.entity.Category;
import com.asiana.lawgic.lawgic.entity.Lawyer;
import com.asiana.lawgic.lawgic.repository.LawyerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class LawyerRepositoryTest {
    private String[] address = {"경기도 용인시 처인구 남사읍 화곡로 328-1", "인천광역시 미추홀구 염창로 1-1", "서울특별시 종로구 종로1가 24 르메이에르종로타운1", " 서울특별시 마포구 노고산동 57-4 신촌카리스빌딩", "서울특별시 강남구 삼성구 188 삼성동센트럴아이파크"};
    private String[] birthday = {"1995/03/16", "1996/04/25", "1997/12/24", "1993/06/23", "1997/02/12"};
    private CarType[] carType = {CarType.CITY_CAR, CarType.COMPACT_CAR, CarType.LARGE_SIZE_CAR, CarType.MID_SIZE_CAR, CarType.FULL_SIZE_LUXURY_CAR};
    private String[] email = {"kang@naver.com", "danny@nate.com", "terry@yahoo.com", "jack@gmail.com", "megan@naver.com"};
    private String[] name = {"강형성", "김윤성", "유아인", "김동성", "송인아"};
    private String[] password = {"DFGsdf", "wefR34!", "234dfD", "ghtr%^", "SDDS34e"};
    private String[] phone = {"01033426442", "01055236442", "01042365723", "01054625245", "01094358343"};
    private Category[] categories={Category.CAR_ONLY,Category.CAR_TO_CAR,Category.RAILROAD_CROSSING,Category.CAR_TO_CAR,Category.CAT_TO_PERSON};
    @Autowired
    private LawyerRepository lawyerRepository;
    @Test
    public void insertLawyerData(){
        IntStream.rangeClosed(1,5).forEach(i->{
            Lawyer lawyer=Lawyer.builder()
                    .password(password[i-1])
                    .name(name[i-1])
                    .address(address[i-1])
                    .email(email[i-1])
                    .phone(phone[i-1])
                    .categoryId(categories[i-1])
                    .valid(Math.round(Math.random())==1L?true:false)
                    .gender(Math.round(Math.random())==1L?true:false)
                    .build();
            lawyerRepository.save(lawyer);
        });
    }
}
