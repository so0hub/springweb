console.log( "task.js exe");
// [1] 타입 : JS는 동적타입이므로
    // 1. 기본 자료 / 리터럴
console.log( 3 ); console.log( true ); console.log( 3.14 ); console.log( "안녕");
    // 2. 배열
console.log( [3,true,3.14,"안녕"] );
    // 3. 객체/JSON
console.log( { "name" : "박진감" , "age" : 1 } )
    // 4. 함수
function func1( ){ }
// [2] 다양한 함수 형식
    // function func2( ) { } // 선언적 함수     - 1개월차
    // function ( ){ } // 익명 함수
    // ( ) => { } // 화살표(람다표현식) 함수      - 3개월차 ( 리액트 표현 )
// [3] 화살표 함수는 익명 이므로 변수/상수 에 저장한다.
const func3 = ( )=>{  }
// ========================================================================================== //
/*
    AXIOS
        1.정의 : 대표적으로 비동기/동기 통신 함수
            AXIOS(REACT) vs JS(FETCH) vs JQUERY(AJAX) 등
        2. 목적 : JS환경에서 서버와의 통신
        3. 설치 :
            1. HTML에 CDN 코드 추가한다.
            2. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        4. 사용법
*/
// axios.HTTP메소드명( "통신할주소" ) vs 탈렌드API
// [1]
axios.get("http://localhost:8080/day03/task")

// 프론트서버와 백엔드서버가 같다면 도메인 생략 가능
// [2] axious.HTTP메소드명("통신할주소").then( (response) => {response.data} );
axios.delete("/day03/task?name=박진감").then((response) => { console.log(response.data);});

// [3] axios.HTTP메소드명
axios
      .post("/day03/task?age=40")
      .then( (response) => { console.log( response.data ); } )
      .catch( (error) => { console.log( error ); } )

// [4] axios.HTTP메소드명( "통신할주소" , body )
const obj = {"name" : "박진감" , "age" : 1 } // 객체 생성
axios.put( "/day03/task" , obj )
     .then( ( r ) => { console.log( r.data ) } )
     .catch( ( e ) => { console.log(e) } )

// * 비동기통신 이란? 여러개 요청했을 때 먼저 처리된 응답부터 실행
//      즉] 먼저 처리된 로직부터 실행된다. 순서 보장 안 함.
// * 동기통신 이란? 여러개 요청했을 때 먼저 처리된 로직이 응답하는 순서대로 실행
//      즉] 먼저 요청한 로직이 먼저 실행한다. 순서 보장함.

// [5] async : 동기화 키워드
const func5 = async () => {
    try{ // 1) 예외처리한다.
    // 2) axios 앞에 await 키워드 이용한 동기화
    // 3) axios 결과를 변수.상수에 대입받는다.
    const response =
    await axios.get("/day03/task/axios?name=박명수") // 잠시 대기하라는 뜻.
    // 4) 결과를 확인한다.
    console.log(response.data);
    }catch(e){ console.log(e); }
} // class END
func5(); // 함수실행