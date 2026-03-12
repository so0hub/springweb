console.log('write.js');

// 등록 함수 정의
const 등록 = async() => {
    // 1. 입력 DOM 가져오기
    const writerInput = document.querySelector('.writerInput');
     const contentInput = document.querySelector('.contentInput');
      const titleInput = document.querySelector('.titleInput')
    // 2. DOM에서 입력받은 값 가져오기
    const bwriter = writerInput.value;
    const bcontent = contentInput.value;
    const btitle = titleInput.value;
    // 3. 객체 구성 , 속성명과 변수명이 같을 경우 속성명 생략 가능!
    const obj = {bwriter , bcontent , btitle};
    // 4. AXIOS 이용하여 서버에게 저장,요청 / 응답 받기
    const response = await axios.post("/board" , obj );
    const data = response.data;
    // 5. 결과
    if( data==true ){
    alert('등록성공');
    location.href="/종합예제10/index.html" // 페이지 이동 : HTML <a> , JS location.href=
    }else{ alert('등록실패 : 관리자에게 문의');}
}