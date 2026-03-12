 
 	
console.log( "index.js" );

// JS함수 , function 함수명(){} vs const 변수명 = ( ) => { }
// 전체조회 함수 정의 
const 전체조회 = async ( ) => {
    // 1. 어디에 
    const tbody = document.querySelector('#boardTable');
    // 2. 무엇을 , 스프링 서버에게 전달받은 데이터 요청/응답
    let html = ``;
    const response = await axios.get( "/board" ); // 2-1] 서버와 통신 
    const data = response.data; // 2-2] 통신 결과 내용물 확인 , List<BoardDto>
    for( index = 0 ; index <= data.length-1 ; index++ ){
        const boardDto = data[index]; // 2-3] 게시물 하나씩 꺼낸다.
        html += `<tr>
                    <td> ${ boardDto.bno } </td>
                    <td> <a href="/종합예제10/detail.html?bno=${ boardDto.bno }"> ${ boardDto.btitle } </a> </td>
                    <td> ${ boardDto.bwriter }</td>
                    <td> ${ boardDto.createDate } </td>
                </tr>`
    }
    // 3. 출력 
    tbody.innerHTML = html;

} // f end 
전체조회(); // 함수 실행 
