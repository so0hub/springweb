console.log( 'detail.js');

// 1] 쿼리스트링이란? URL(주소) 뒤에 ?로 매개변수(값) 포함하는 경우
// 2] JS에서 쿼리스트링의 값 가져오는 방법
// new URLSearchParams( location.search ).get( "변수명" );
const bno = new URLSearchParams(location.search).get("bno");
// 3] 확인
console.log(bno);

// 개별 조회 함수 정의
const 개별조회 = async() => {
    // 1) 어디에
    const boardBox = document.querySelector('#boardBox');
    // 2) 무엇을 , 쿼리스트링에 존재하는 ( 클릭한게시물 ) bno 에 게시물 정보 서버에게 요청/응답
    const response = await axios.get(`/board/detail?bno=${bno}`); // ? 쿼리스트링 방법
    const data = response.data;
        // += 누적 vs 대입
    let html = `<h3>게시물 상세</h3>
                제목 : <div> ${data.btitle} </div> </br>
                 작성자/작성일 : <div> ${data.bwriter} / ${data.createDate} </div>
                 내용 : <div> ${data.bcontent} </div>
                  <button onclick="개별수정( ${data.bno} )"> 수정 </button>
                  <button onclick="개별삭제( ${data.bno} )"> 삭제 </button>

                    <hr/>

                        댓글 작성자 : <input class="rwriterInput"> </br>
                        댓글 내용 : <textarea class="rcontentInput"></textarea>
                        <button onclick="댓글등록()"> 댓글등록 </button>
                        <hr/>


                  `;
    // 3) 출력
    boardBox.innerHTML = html;
}

// 개별 조회 함수 호출
개별조회();


// 댓글 등록 함수 정의
const 댓글등록 = async() => {
// 1. 입력 DOM 가져오기
const rwriterInput = document.querySelector('.rwriterInput');
const rcontentInput = document.querySelector('.rcontentInput');
// 2. DOM에서 입력받은 값 가져오기
const rwriter = rwriterInput.value;
const rcontent = rcontentInput.value;
// 3. 객체 구성, 속성명과 변수명이 같을 경우 속성명 생략 가능
const obj = {rwriter , rcontent , bno};
// 4. AXIOS 이용하여 서버에게 저장,요청 / 응답 받기
const response = await axios.post("/reply" , obj );
const data = response.data;
// 5. 결과
if( data==true ){
alert('댓글 등록 성공');
location.href="/종합예제10/index.html"
}else{alert('댓글 등록 실패 : 관리자에게 문의');}
}

// 개별 삭제 함수 정의
const 개별삭제 = async( bno ) => {
    // 1) 현재 게시물을 삭제하기 위해 현재 게시물 번호 확인 ( bno는 매개변수 또는 쿼리스트링 )
    // 2) axios 이용하여 서버에게 게시물 삭제 요청 결과받기
    const response = await axios.delete(`/board?bno=${bno}`);
    const data = response.data;
    // 3) 결과
    if(data==true){
    alert('삭제성공'); location.href="/종합예제10/index.html";
    }else{alert('삭제실패');}
} // f END

// 개별 수정 함수 정의
const 개별수정 = async( bno ) => {
 // 1) 현재 게시물을 수정하기 위해 현재 게시물 번호 확인 ( bno는 매개변수 또는 쿼리스트링 )
 // 2) 수정할 내용 입력받기 . 테스트용
 const btitle = prompt('수정할 제목 입력하세요.');
 const bcontent = prompt('수정할 내용 입력하세요.');
 const bwriter = prompt('수정할 작성자 입력하세요.');
 // 3) axios 이용하여 서버에게 게시물 수정 요청 결과받기
 const obj = {bno,btitle,bcontent,bwriter}; // 수정할 내용들(객체)
 const response = await axios.put('/board' , obj);
 const data = response.data;
 // 4) 결과
 if( data==true ){
 alert('수정성공'); location.reload; // 현재 페이지 새로고침[F5기능]
 }else{alert('수정실패');}
} // f END
