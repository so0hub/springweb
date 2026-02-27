console.log("index.js open"); // 확인용

// 요청 프로세스 : HTML -> JS -> SPRING ( CONTROLLER -> DAO ) -> MYSQL
// 응답 프로세스 : HTML <- JS -> SPRING ( CONTROLLER -> DAO ) <- MYSQL


// 1] 전체 조회 , 실행 조건 : JS가 열렸을 때 , 수정/등록/삭제 성공했을 때
const onFindAll = () => {
    // 1. 어디에 , document.querySelector( 출력할위치 );
    const tbody = document.querySelector("#boardTable tbody");
    // 2. 무엇을 , 출력할 내용물 정의
    let html = ""; // 동기화 : 1. 현재 함수명 앞에 async 키워드 붙인다.    2. axios 앞에 await 키워드 붙인다.
        const response = await axios.get("/board"); // TalendApi 말고 JS에서 스프링Controller와 통신하는 기술
        console.log( response );
    // 3. 출력 , innerHTML , 출력할 위치에 내용 대입한다.
    tbody.innerHTML = html;
} // fun END
onFindAll(); // JS가 열렸을 때

// 2] 등록
    // 1. 입력받은 값들을 가져온다. document.querySelector

// 3] 개별 수정

// 4] 개별 삭제