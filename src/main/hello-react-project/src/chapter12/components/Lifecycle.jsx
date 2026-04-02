import { use, useEffect, useState } from "react"

function MoveBox(props){
    // props란? 상위컴포넌트에서 해당 컴포넌트 호출시 전달해주는 속성명과 속성값들(여러개)을 객체로 받는 매개변수
    // props ->? {initPosition : 50}

    // useState란? 컴포넌트내 데이터(값) 상태 관리하는 함수 , 왜? 재렌더링하려고!!~~~
    // const[ 상태명 , set상태명 ] = useState(초기값);
    const[ position , setPosition ] = useState(props.initPosition); // 초기값 50

    const[ leftCount , setLeftCount ] = useState(1); // 초기값 1
    // setLeftCount(3); // 수정 , 현재 함수(MoveBox) 재실행이 된다 -> return 다시 반환된다. -> html 다시 그리기
    // vs
    // let rightCount = 2; // 변수 선언
    // rightCount = 3; // 수정 , 현재 함수(MoveBox) 재실행 안 된다.

    // [0] CSS 문법을 객체지향으로 표현 가능 , 변수대입은 `${}` 백틱 사용하여 대입 가능
    const boxStyle = {
        backgroundColor : 'red',
        position : 'relative', 
        left : `${position}px`, // CSS 요소의 JS 변수 대입 즉] CSS를 변수화/객체화
        width : '100px', height : '100px' , margin : '10px'
    }
    // [1]
    const moveLeft = ( ) => {
        setPosition( () => position - 20 );
        setLeftCount( () => leftCount +1);
    }
    // [2]
    const moveRight = () => {
        setPosition( () => position +20 );
    }
    // [3]
    useEffect( function(){
        console.log("useEffect 실행 : 마운트" )
        return()=>{
            console.log("useEffect 실행 : 언마운트" ); // 재(다시)렌더링하면 기존 렌더링된 컴포넌트(화면/함수)는 지운다.
        }
    }, [leftCount] ) // 의존성 배열이란? state(상태) 변수 배열내 대입하여 해당하는 상태가 변경되면 useEffect 실행
    // } ) // 179p (1) 생략
    // },[]) // 179p (2) 빈배열
    // }.[leftCount]) // 179p (3) 특정한 state 변수 대입
    
    
    // [4]
    console.log("return 실행 : 렌더링" )
    // 해당 컴포넌트 실행하고 , 좌측이동 버튼 3번 클릭 했을 때 return 총 4번.
    // 해당 컴포넌트 실행하고 , 우측이동 버튼 3번 클릭 했을 때 return 총 4번.
    // 해당 컴포넌트 실행하고 , 좌측이동 버튼 3번 클릭 했을 때 마운트 총 4번.
    // 해당 컴포넌트 실행하고 , 우측이동 버튼 3번 클릭 했을 때 마운트 총 1번.
    return(<>
        <div>
            <h4> 함수형 컴포넌트의 생명주기 </h4>
            <div style={boxStyle}> {leftCount} </div>
            <input type="button" value="좌측이동" onClick={moveLeft}/>
            <input type="button" value="우측이동" onClick={moveRight}/>
        </div>
    </>)
}

export default function LifeCycle(props){

// html 에 없는 마크업들은 모두 컴포넌트 취급한다. 즉] 컴포넌트란? 나만의 마크업 만들기

return(<>
    <h2> chapter12 </h2>
    <MoveBox initPosition={50}></MoveBox>
    </>)
}