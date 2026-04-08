import axios from "axios";
import { useEffect, useRef, useState } from "react"

// [6] npm install @stomp/stompjs ws 설치
// [7] stomp 클라이언트 객체 import
import { Client } from '@stomp/stompjs'

export default function Chat(props){

    // [8] Client 객체를 저장하는 변수 , useRef vs useState
    // 특정한 상태/값 저장하고 화면 렌더링에 영향을 주지 않는 저장소
    // 차이점!!!) useRef 가 변해도 렌더링은 안 된다. 하지만 useState는 변하면 렌더링된다.
    // useRef = { current : null } , useRef객체내 current 속성을 갖는다. current 저장된 상태/값

    // 예] 만약에 다른 상태들이 변해서 렌더링했을 때 채팅 클라이언트는 변화가 없게끔 하기 위해서
    const client = useRef( null );

    // [4] 로그인 정보 상태 변수
    const [ loginUser , setLoginUser ] = useState(null);

    // [3] AXIOS 회원정보 불러오기 함수
    const getMyInfo = async () => {
        try{
            const response = await axios.get("http://localhost:8080/api/member3/myinfo",
                {withCredentials : true}
            )
            setLoginUser( response.data || null ); // * 단축평가 : 조건 && 참 , 조건 || 거짓
            console.log( loginUser ); // 확인용    
        }catch(e){console.log(e)}
    }

    // [14] 서버에게 받은 메시지들을 저장하는 상태변수
    const [ messages , setMessages ] = useState( [ ] );


    // [5] 해당 컴포넌트 생명주기 , 1번실행
    useEffect( ()=>{
        getMyInfo();

         // [9] 웹소켓 연결 객체 생성 , new Client( { brokerURL : , onConnet } )
        const stomp = new Client( {
            brokerURL : "ws://localhost:8080/ws", // 스프링 웹소켓 엔드포인트
            reconnectDelay : 5000 , // 연동 실패시 5초마다 재연동
            onConnect : () => { // 연동 성공하면 실행할 로직(함수)
                console.log("백엔드 소켓과 클라이언트 소켓 연결 성공");

                // [13] 메시지 구독 ( 서버 -> 클라이언트 )
                // stomp.subscribe("구독주소" , (받은메시지) => {} );
                stomp.subscribe("/topic/message" , (메시지) => {
                    console.log(메시지);
                    // 1) 서버에 받은 메시지를 JSON 으로 변환 , ** AXIOS 는 자동 **
                    // JSON.parse(문자) 문자 -> 객체 , JSON.stringify(객체) 객체->문자
                    const data = JSON.parse(메시지.body);
                    // 2) 서버에 받은 메시지를 상태변수에 대입한다.
                    messages.push(data);
                    setMessages( [...messages] ) // 얕은 비교하기 때문에 ...객체복사
                
                    
                }); // 구독 주소는 스프링의 소켓컨트롤러( @SendTo ) 에서 설정한 주소 확인
            }
        } );

    
        
        // [10] 웹소켓 실행  .activate();
        stomp.activate();

        // [11] 웹소켓을 안전하게 useRef 보관한다. useRef 는 useState와 다르게 렌더링에 영향이 없다.
        client.current = stomp; // useRef의 값은 current 속성에 포함된다. 수정시 .current = 새로운값

        // [12] 컴포넌트 언마운트 될 때 , 컴포넌트 생명주기( 마운트=탄생/업데이트=인생/언마운트=죽음 )
        return () => {
            // 언마운트(화면에서 컴포넌트가 사라졌다는 뜻) 실행문;
            stomp.deactivate(); // 안전하게 소켓 닫기
        }
    } , [] )



    // [2] 입력받은 값을 저장하는 상태 변수
    const[ sendMsg , setSendMsg ] = useState(''); 

    // [1] 전송 버튼 클릭시 입력받은 값 가져오기 = 서버에게 채팅 메시지 보내기
    const sendMessage = () => {
        console.log( '입력받은값 : ' , sendMsg ) // 1) 입력받은 값 확인하기
        if( sendMsg == '' ){ // 2) 만약에 입력한 값이 없으면 메시지 전송 안 함
            alert('메시지를 입력하세요.'); return;
        }
        // [16] 서버에 보낼 메시지 구성 , sender 보낸사람 , message 입력받은값
        const obj = { sender : loginUser.mname , message : sendMsg }

        // [15] 연동된 소켓에 메시지 보내기 , useRef의 상태값 호출 , .current
        client.current.publish({ // client.current == stomp(웹소켓) [11] 보관했기 때문에
            destination : "/app/chat", // 메시지를 받을 주소 , 스프링 소켓컨트롤러(@MessageMapping) 에서 설정한 주소
            body : JSON.stringify( obj ) // 보낼 메시지를 JSON 형식의 문자열 타입 , * AXIOS 자동 *
        })
            setSendMsg(''); // *) 메시지 전송 후 입력상자 , 초기화

    }
    return(
        <div>
  <h3> 채팅 </h3>
            <div className="contents" style={ {width : "300px"}}>

                {/* 받은 메시지들이 저장된 messages 출력하기 */}
                {
                    messages.map( ( msg ) => {
                        return (
                            <div className="msgbox"> 
                                { /* 삼항연산자 이용한 html 분기 */}
                                { loginUser && loginUser.mname == msg.sender ? 
                                    (<>
                                        <div className="msg" style={ { textAlign : "right" }}> { msg.message } </div> 
                                    </>) : 
                                    (<>
                                          <div className="sender"> { msg.sender } </div>
                                          <div className="msg"> { msg.message } </div>
                                    </>) 
                                }
                            </div>
                        )
                    })
                }
            </div>
            { /* 입력상자내 value 속성에 상태변수 대입시 수정 불가능(입력은 가능하지만 렌더링 안 된 상태)하다. */ }
            { /* 상태변수는 렌더링해야 한다. 방안] onChange = { (e)=>{setXXXX( e.target.value )} } */ }
            <input value={ sendMsg } onChange={ (e) => {setSendMsg(e.target.value)}}/>
            { /* 인풋에 상태변수 넣을 거면 onChange 는 필수다. */ }
            <button onClick={sendMessage}> 전송 </button>
        </div>
    )
}