package example.day12.스프링스케줄링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {


    // * 컨트롤러 유무와 상관없이 특정시간이 되면 서비스 자동 실행 *
    // 비동기 기반의 구조 , 목적 : 보안 , 자동화 , 백그라운드 처리
    // AppStart 클래스 위에 @EnableScheduling 주입한다.
    // [1] 3초마다 실행되는 스케줄 설정
    @Scheduled( fixedRate = 3000 ) // 밀리초 , 3초
    public void task1(){
        System.out.println("ScheduleService.task1"); // soutm
    }

    // [2] 5초(변수값)마다 실행되는 스케줄 설정
    final int time = 5000; // 밀리초(5초) // 알람 기능
    @Scheduled( fixedRate = time )
    public void task2(){
        System.out.println("ScheduleService.task2");
    }

    // [3] ** 시스템 날짜/시간 기준으로 스케줄링
    // @Scheduled( cron = 초 분 시 일 월 요일)
    @Scheduled( cron = " */5 * * * * * " ) // 매시각 5초이면 실행 ( 마다 X )
    // 매, 로 할 거면 앞에 와일드 카드 */n 이렇게 하기.
    public void task3(){
        System.out.println("ScheduleService.task3");
    }

    @Scheduled( cron = " 0 */1 * * * * ") // 매시각 1분 이면 실행 , 11:13:00 , 11:14:00
    public void task4(){
        System.out.println("ScheduleService.task4");
    }
}

 /*
    cron 패턴
        1. 형식 : @Scheduled( cron = " 초 분 시 일 월 요일 " )
        2. 첫번째 초 : 0~59
        2. 두번째 분 : 0~59
        3. 세번째 시 : 0~23
        4. 네번째 일 : 1~31
        5. 다섯번째 월 : 1~12
        6. 여섯번째 요일 : 0~6, 0 : 일요일 ~ 3 : 수요일 ~ 6 : 토요일

        예시]
            1) 주말(일/토) 마다 오전 10시 : @Scheduled( 0 0 10 * * 0,6 ); // 쉼표넣으면 두 개 넣을 수 있음
            2) 일요일 마다 오전 9시       : @Scheduled( 0 0 9 * * 0 );
            3) 매월 1일 오전 8시 30분     : @Scheduled( 0 30 8 1 * * );
            비동기 == 스케줄링 == 백그라운드
                1) HTTP 와 상관없이 자바(서버)내 내부로직 실행
                2) HTTP Response(응답) 제약 있다. 응답이 필요할 경우 추가 기술 필요
                    HTTP( 무상태 / 비연결 ) , vs Socket( 상태 / 연결유지 ) vs Message
                        HTTP : CRUD , 기초 통신 , 사용자가 요청이 있어야만 응답하는 구조
                        Socket : 실시간 양방향 통신 , 사용자가 요청이 없어도 응답 받아야 하는 경우 , 예] 채팅 / 실시간 데이터 / 푸시알림( 포스-키오스크 )
  */
