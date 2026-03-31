
// 컴포넌트 생성 : export default function 컴포넌트명( props ){ return JSX문법 }

import { useState } from "react"

// 컴포넌트2
const TopComp = ({MyData}) => {

    // 이 구간은 JSX가 아님

    // const 상수 , let 변수
    // ( 매개변수 ) => { } 화살표함수 , function( 매개변수 ){ } 익명함수 , function 함수명( 매개변수 ){ } 선언적함수
    // {MyData} , 구조분해 : 상위컴포넌트로부터 props객체를 구조화해서 변수로 받기( props객체내 MyData속성값 변수로 받기 )
    // return : 함수의 반환값
    // 리액트JSX return : JSX 반환
    // JSX 이란? HTML + JS 조합된 문법
    // JSX 주석? {/* 주석 */}
    // JAVA MAP , 배열/리스트.stream.map( ( 반복변수 ) -> { } )
    // JS MAP , 배열/리스트.map( ( 반복변수 ) => { } )
        // FOREACH 반복문(return없음) VS MAP(return있음)
        // JSX 문법에서 반복된 자료를 HTML로 구성하여 반환하는 구조 다수, MAP 활용된다.
        // 예] MyData.front = [ 'A' , 'B' , 'C' ]
        // 3+3 -> 6 , <li key={ i } > {A} </li> <li key={ i } > {B} </li> <li key={ i } > {C} </li>
    return (<>
        {/* 주석처리 */}
        <ol>
            <li> 프론트엔드 </li>
            <ul>
                {MyData.front.map((item,index) => <li key={ index } > {item} </li>)}
            </ul>
            <li> 백엔드 </li>
            <ul>
                {MyData.back.map((item,index) => <li key={ index } > {item} </li>)}
            </ul>
        </ol>
    
    </>)
    {/* return 부터! 여기가 JSX. 주석도 //가 아니라 이렇게 중괄호 안에 가둬야 함. */ }
} // f END

// 컴포넌트1
export default function Exam1( props ){
    const [ MyData , setMyData ] = useState({ 
        front : ['HTML5','CSS3','JavaScript','jQuery'],
        back : ['Java','Oracle','JSP','Spring Boot'],
    });

    // 예] const [a,b] = {a:1,b:2}
    // a에는 1 , b에는 2
    // useState 훅(hook : 갈고리-연결 상태/값/데이터 <-- 갈고리 --> 컴포넌트 )
    // 즉] 상태(state)가 (*주소/참조)값 변경되면 컴포넌트 렌더링 된다.
    // const [ 상태명 , set상태명 ] = useState( 초기값 );
    // 리터럴 : 키보드로부터 입력받은 상수 자료 , 주소/참조 값 : 자료가 위치한 메모리 주소값
        // let a = 3; // 주소값 몇개? 2개 , 3(101번지) , a(201번지)
        // let b = 3; // 주소값 몇개? 3개 , 3(101번지) , a(201번지) b(202번지)

        // MemberDto dto1 = new MemberDto();  // 주소값 몇개? 2개 , new MemberDto(301번지) , dto1(401번지)
        // MemberDto dto2 = new MemberDto();  // 주소값 몇개? 4개 , new MemberDto(301번지) ,  new MemberDto(302번지) , dto2(402번지)
        // MemberDto dto3 = dto2;             // 주소값 몇개? 5개 , new MemberDto(301번지) ,  new MemberDto(302번지) , dto3(402번지)

    // 1] 렌더링 안 되는 코드
    const addFront = () => {
        MyData.front.push('React'); // MyData( 101동203호 ) , push( ) : 배열내 값 추가 함수 , 주소 변경 없이 주소내 값 추가
        setMyData(MyData); // set상태명( 새로운주소값 ); // 상태는 값변경 감지하지 않고 상태의 주소값 변경 감지한다. ( 얕은 비교 )
    }
    // 2] 렌더링 되는 코드 , 스프레드연산자 { ...기존객체} , [...기존배열] ,   {...기존객체 , 속성명:값} , [...기존배열 , 값 ]
    const addBack = () => {
        const newBack = [...MyData.back,'Node.js'];
        const newMyData = { ...MyData, back: newBack }; // newMyData = { ...MyData(101동203호) }
        setMyData(newMyData);                           // newMyData 105동 702호
    }

    return <> 
        <h2> Chapter10 </h2>
        <TopComp MyData={ MyData } />
        <button type="button" onClick={ addFront }> 프론트추가 </button>
        <button type="button" onClick={ addBack }> 백엔드추가 </button>
     </>
} // f END
// onclick : HTML 코드 , onClick : JSX코드(가상/가짜DOM)
// 리액트가 가상/가짜 DOM 사용하는 이유 : HTML이 객체지향이 아니라서 HTML을 객체지향으로 만든 구조 JSX
// DOM : document object model : html 마크업들을 객체지향