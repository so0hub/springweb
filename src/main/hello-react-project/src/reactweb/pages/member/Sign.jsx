import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Sign(props){
    const onSignup = async (e) => {
        e.preventDefault();
    
    // 폼 데이터 가져오기
   const mid = e.target.mid.value;
   const mpwd = e.target.mpwd.value;
   const mname = e.target.mname.value;

   // 보낼 객체 만들기
   const obj = {mid,mpwd,mname};

   // AXIOS 통신
        const response = await axios.post(
            'http://localhost:8080/api/member2/signup',  // 통신할(스프링 컨트롤러 매핑) 주소
            obj
        );
    

    if(response.data == true){alert('회원가입에 성공했습니다!'); location.href="/";
    }else{alert('회원가입에 실패하였습니다!');}
}
    
    return(<>
    <div>
        <h3> 회원가입 페이지 </h3>
        <form onSubmit={onSignup}>
            아이디 : <input name="mid"/> <br/>
            비밀번호 : <input name="mpwd"/> <br/>
            닉네임 : <input name="mname"/>
            <button> 가입 </button>
        </form>
    </div>
    </>)
}