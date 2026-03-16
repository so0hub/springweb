package example.day10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {
    public static void main(String[] args) {

        // 람다표현식 , ( 매개변수 ) -> { 구현부 }
        // 스트링 API : 데이터( 매개변수 ) --> 중간연산 --> 최종출력

        List< Integer > number = List.of( 1, 2, 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 ); // 임의 데이터를 담고 있는 리스트

        // [1] 리스트변수명.stream().forEach( );  , 중간연산 없이 바로 최종출력
        // 매개변수에 반복변수를 하나씩 대입하여 return 없는 반복문
        number.stream().forEach( ( x )  -> {
            System.out.println( x * 2 ); // 2 4 6 8 10 12 14 16 18 20
        } );

        // [2] 리스트변수명.stream().map( 중간연산 ).collect( 최종출력 );
        // 매개변수에 반복변수를 하나씩 대입하여 return 있는 반복문 , 반복 return 값들을 collect(  Collectors.toXXX()  ) 반환받는다.
        List< Integer > result = number.stream()
                    .map( ( x ) -> { return x * 2; } )      // 중간연산
                    .collect( Collectors.toList() );               // 중간연산 결과를 새로운 리스트에 반환해준다.
        System.out.println("result = " + result);

        // [3] 리스트변수명.stream().map( 중간 연산 )
        number.stream().map( (x) -> { return x * 2 ; } ).forEach( (중간연산결과 ) -> {
            System.out.println( "result = " + 중간연산결과 ); // 중간연산 결과를 출력한다.
        });

        // [4]
        number.stream() // 리스트 내 데이터들의 흐름 시작
                .filter( x -> x % 2 == 0 ) // 중간연산 , 짝수찾기 반환한다.
                .forEach( y -> System.out.println("y = " + y)); // 최종 출력 :

        // [5]
        number.stream() // 리스트 내 데이터들의 흐름 시작
                .sorted(Comparator.reverseOrder() ) // 중간 연산 , 오름차순 , 내림차순( Comparator.reverseOrder() )
                .forEach( y -> System.out.println("y = " + y));

        // [6]
        number.stream()
                .distinct() // 중복제거 , 중간연산
                .collect( Collectors.toList() );

        // [7]
        number.stream()
                .limit( 5 ) // 중간연산 , 앞에서부터 n개까지
                .forEach( y -> System.out.println("y = " + y));

        /*
            스트링이란? 데이터 다니는 연속적인 흐름
                - 데이터들 ---> 중간연산 ---> 최종출력
                - 중간연산은 여러개 가능
                - 최종연산은 반드시 1개 가능

            주요연산
                - 중간 연산 :  .map( ) .filter( ) .sorted( ) .distinct( ) .limit( )
                - 최종 연산 : forEach( ) collect( )
        */
    } // main
} // class END

// vs
//for( int index = 0 ; index <= number.size() -1 ; index++ ){
//if( number.get(index) % 2 == 0 ){
//System.out.println("number.get(index)  = " + number.get(index) );
//}
//}


/*
        ===================== ntt리스트를 dto리스트로 변환하는 방법 ========================
        1번 방법] for문 ( 정석 ) ( 나머지를 몰라도 이건 알아야 함 )
        List<BoardDto> list = new ArrayList<>(); // 여러개 dto 담는 리스트
        for( int i = 0 ; i<=entityList.size()-1; i++ ){
            BoardDto boardDto = entityList.get(i).toDto();
            list.add( boardDto );
        }


        // vs
        2번 방법] for Each 를 써서 하는 법
        List<BoardDto> list = new ArrayList<>(); // 여러개 dto 담는 리스트
        entityList.forEach( entity -> {  // 리스트변수명.forEach( 반복변수 -> { 실행문; } );
            BoardDto boardDto = entity.toDto(); // 3] 엔티티 하나씩 dto로 변환
            list.add( boardDto ); // 4] 새로운 리스트에 담기
        } );


        // vs
        3번 방법] map을 써서 하는 법
        List<BoardDto> list =
                entityList.stream().map( entity -> entity.toDto() ).collect( Collectors.toList() );

        // vs
        4번 방법] 이게 가장 짧고 좋다능.
        List<BoardDto> list =
            entityList.stream().map( entity :: toDto ).collect( Collectors.toList() );

 */
