import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom"

export default function Header(props){

    // [2] 로그인 상태 저장하는 상태변수,
    const [login,setLogin] = useState( false ); // 초기값은 false 로그인 안 했다는 뜻

    // [3] 로그인 중인 회원정보 담는 상태변수
    const [ user , setUser ] = useState( null ); // 초기값은 비로그인 상태

    // [1] 로그인 상태에 따라 상단메뉴 분기
    const getMyInfo = async () => {
        // 1) 로그인시 localStorage 저장한 token 가져오기 , .setItem , .getItem
        const token = localStorage.getItem('token');
        // 2) 만약에 token이 없으면 함수 종료 , 로그인 상태
        if(!token){setLogin(false); return;}
        // 3) 헤더에 표시할 로그인된 유저 아이디 가져오기
        const response = await axios.get(
            'http://localhost:8080/api/member2/myinfo', // 통신할(스프링 컨트롤러 매핑) 주소
            { headers : { Authorization : `Bearer ${token}`} } // { headers : {속성명:값} }
            // * axios 특징 : Content-Type : application/json 이 기본값이다.
            // 만약에 Content-Type 이 json 아닌 경우 명시한다.
        );
        // 4) 통신 결과 분기
        const data = response.data;
        if( data || data != false ){ // 응답 자료가 존재하면
            setLogin( true ); // 로그인상태 변경
            setUser( data ); // 응답 받은 자료(회원정보) 를 저장
        }else{
            setLogin(false); // 비로그인상태 변경
        }
    }

    // [4] 헤더가 열리면 최초 1번 실행 , 로그인상태(백엔드 검증해야한다.)
    useEffect( () => { getMyInfo(); } , [] )

    // [5] 로그아웃
    const logout = () => {
        // 1) localStorage 에서 token 제거 , .removeItem()
        localStorage.removeItem('token');
        // 2) 로그인 상태 변경
        setLogin( false );
        // 3)
        alert('로그아웃'); location.href="/";
    }


    // JS 삼항연산자 , 조건 ? 참실행문 : 거짓실행문 , 조건이 참이면 실행문 , 거짓이면 거짓실행문 
    // JS 단축평가 , 조건 && 실행문 , 조건이 참이면 실행문 , 거짓이면 생략
    return(
        <div>
            {/* 로그인 상태에 따른 메뉴 분기 */}
            <Link to="/"> 홈 </Link> |

            {/* 비로그인 메뉴 */}

            { login == false && (<>

            <Link to="/member/login"> 로그인 </Link> |
            <Link to="/member/signup"> 회원가입 </Link> |
            </> )}

            {/* 로그인 메뉴 */}
            { login == true && (<> 
             <span> {user.mid}님 </span> |
            <Link to="/member/myinfo"> 내정보 </Link> |
            <Link to="/board/write"> 글쓰기 </Link>
            <button onClick={logout}> 로그아웃 </button>
            </>)}
           <hr/>
        </div>
    )

}