
function FrontComp( props ){
    return(<>
        {/* JSX( return 안에서 사용되는 문법 ) 에서 주석처리 하는 방법 */}
        <li>
            <a href="/" onClick={()=>{ props.onMyEvent1(); } } > 프론트엔드 </a>
        </li>
        <ul>
            <li> HTML5 </li> <li> CSS3 </li> <li> Javasript </li> <li> jQuery</li>
        </ul>
    </>)
}


function Exam2(){
    
    function 출력함수(){ alert('출력된메세지');} // 선언적 함수

    // 익명 함수 ? 이름이 없는 함수( 재사용이 안 된다. 일회성 또는 이벤트함수 )
    // 화살표 함수 ? 이름이 없고 => 화살표 표현식 사용하는 함수 ( 주로 변수에 저장하여 재사용한다. )
    
    return (<>
        <h3> 이벤트 처리 p.100 </h3>
        <button onClick={출력함수}> 선언적 함수 버튼 </button> 
        <button onClick={ function(){ alert('출력된 메시지2');}}> 익명 함수 버튼 </button>
        <button onClick={ ()=>{alert('출력되는 메시지2')} }> 화살표 함수 버튼 </button>
        <FrontComp onMyEvent1 = { ()=>{alert('프론트엔드 클릭됨') } }></FrontComp>
    </>)
}
export default Exam2;

/*
    리액트 이벤트에서 주의할 점
        1. onClick --> onClick , 합성이벤트(리액트가 핸들러/연결 통해 이벤트 실행)
        2. onClick 에서 함수 실행하는 구조 아니고 *전달!* 하는 구조
            1] 선언방법 , function 함수명(){}
            2] 호출방법 , 함수명()
            3] 함수란? 여러개 코드/계산식(데이터X) 묶음
            4] 변수란? 하나의 값 저장하는 공간
        ** HTML : <button onclick="출력함수()">
        ** REACT : <button onClick={ 출력함수 }>  , <button onClick={ ()=>{} }></button>
*/