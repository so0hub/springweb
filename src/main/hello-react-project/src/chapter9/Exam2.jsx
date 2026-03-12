import {useState} from 'react'; // 모듈 임포트

function WriteForm( props ){
    // event / e 객체 이란 ? 해당 이벤트(onClick/onSubmit 등)가 발생했을 때 그 이벤트 정보를 담고 있는 객체
    return (<>
        <form onSubmit={ (event) =>{
            event.preventDefault(); // 기존 onSubmit 이벤트 정보 제거
            console.log( "이벤트 객체 : " , event );
            // let gubun = document.querySelector(); [리액트는 querySelector 방식 하지 않는다.]
            console.log("이벤트 발생한 주체 : " , event.target ); // <form> 
            console.log( event.target.gubun ); // <form> -> 하위요소 , .target.class명
            let gubun = event.target.gubun.value;  // <form> -> <select>
            let title = event.target.title.value; // <form> -> <select>
            // vs let title = document.querySelector('.title').value;
            props.등록하기( gubun , title ); // 부모 컴포넌트로부터 받은 함수에 입력받은 구분과 타입을 대입하여 함수 실행
        } }>
            <select name = "gubun">
                <option value="front"> 프론트엔드 </option>
                <option value="back"> 백엔드 </option>
            </select>
            <input type="text" name="title"/>
            <input type="submit" value="추가"/>
        </form>
    </>)
} // c END

export default function Exam2( props ){

    // 상태변수 란? 하나의 값 저장하고 변경되면 해당 컴포넌트가 렌더링/재실행 된다.
    const [ message , setMessage ] = useState("폼값 전송 진행 중");

    // 자식에게 전달할 함수
    const 등록함수 = ( gubun , title )=>{
        if( gubun !='' && title != '' ){
            let frmValue = `검증 완료 폼값 : ${ gubun },${ title }`
            // 등록했을 때 setXXX() 실행되면 해당 컴포넌트(Exam2)도 재호출이 된다.
            // 즉] return 재실행된다
            setMessage(frmValue);
        }else{
            alert("빈 칸 있음");
        }
    } // f END

    return (<>
        <h3> 135p. </h3>
        <WriteForm 등록하기={등록함수}/>
        <div> {message} </div>
    </>)
} // c END