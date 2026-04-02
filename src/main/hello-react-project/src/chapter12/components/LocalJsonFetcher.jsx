import { useEffect, useState } from "react";
import axios from 'axios';

const GlobalTop = (props) => {
    console.log("[1] 컴포넌트 실행");
    const [myList,setMyList] = useState([]); // 빈배열 갖는 상태변수

    // [1] AXIOS 사용하기 , 설치 : npm i axios , 임포트 : import axios from 'axios'
    const axios1 = async() => { // axios 통신하는 함수 하나 만든다. async 동기화 한다. 
        const response = await axios.get('/json/myData.json'); // await 동기화된 axios 통신한다.
        // response에는 HTTP 응답 관련 정보들이 객체로 들어있다.
        // 그중에 response.data는 실질적 결과물(내용물/body) 있다.
        const result = response.data; // 통신결과내 .data가 실질적인 결과물(내용물/body)가져온다.
        setMyList(result); // axios 통신결과를 상태변수에 대입한다. <렌더링>
    }
    // (1) useEffect( () => {} )                        : 최초실행, 렌더링할때마다실행
    // (2) useEffect( () => {} , [] )                   : 최초실행
    // (3) useEffect( () => {} , [상태변수1,상태변수2] )   : 최초실행 , 특정상태변경될때마다실행
    useEffect( () => {
        console.log('[3]useEffect 실행')
        axios1();
    } , [] )

    // [3] 현재 상태(myList => json => axios) 정보를 반복하여 html 구성 함수
    // 리스트/배열변수명.map( (반복변수) => {<> JSX </>} ) // 주로 HTML 구성할 때 사용된다.
      // myList = [ {"num":1, "id":"yu", "name":"유비", "cell":"(02) 235-1111"},
    // {"num":2, "id":"kwan", "name":"관우", "cell":"(051) 235-2222"},
    // {"num":3, "id":"jang", "name":"장비", "cell":"(031) 235-3333"} ]
    let listTag = myList.map( (data) => { 
        // 첫 번째 반복 data = {"num":1, "id":"yu", "name":"유비", "cell":"(02) 235-1111"}
        // 두 번째 반복 data = {"num":2, "id":"kwan", "name":"관우", "cell":"(051) 235-2222"}
        // 세 번째 반복 data = {"num":3, "id":"jang", "name":"장비", "cell":"(031) 235-3333"}

    return(
        <li key={ data.id }>
            <a href={ data.id } data-id={data.num} onClick={ (e)=>{ // a : 이벤트(a마크업 클릭)를 발생시키는 마크업
                e.preventDefault(); // a 마크업 관련된 기본 기능 제거 ( 깜빡거리는 기능 제거 )
                props.myListClick( e.target.dataset.id );
            }}> { data.id } </a>
        </li>
    )
    } )
    // console.log(listTag); // 변수예측 

    console.log('[2] return 실행')
    return(<>
        <nav>
            <ul>
                {listTag}
            </ul>
        </nav>
    </>)
}

// 클릭된 정보를 그리는 컴포넌트
const ContentBody = (props)=>{
    return(<>
        <div>
            <h2> {props.myResult.name} </h2>
            <ul>
                <li> num : {props.myResult.num}</li>
                <li> id : {props.myResult.id}</li>
                <li> cell : {props.myResult.cell}</li>
                <li> description : {props.myResult.description}</li>
            </ul>
        </div>
        </>)
}

export default function LocalJsonFetcher(props){

    const [ myResult , setMyResult ] = useState({}); // 상태변수 , 배열 아닌 객체 , 빈 객체
    console.log(myResult); // 확인

    return(<>
        <h2> 내부 서버 통신 </h2>
        <GlobalTop myListClick={async(num)=>{ // async() => {} vs async function(){} vs async function함수명(){}
            console.log('클릭',num); 

            // fetch 대신에 axios ( 책이랑 다름 )
            const response = await axios.get(`./json/dto${num}.json`);
            const result = response.data;
            setMyResult(result);
        }}></GlobalTop>

        <ContentBody myResult={myResult}>
        </ContentBody>
    </>)
}
/*
    // 함수 선언
    function add(x){
        return x+3;
    }

    // 일반함수호출 : add(3) , 결과 : 6
    // 컴포넌트함수호출 : <add x=3> , 결과 : 6이 아니라 Html이 나올 것
*/