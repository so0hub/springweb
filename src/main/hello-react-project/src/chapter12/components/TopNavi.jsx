import { NavLink } from "react-router-dom"

export default function TopNavi(props){
    // jsx 와 js 구분 : 컴포넌트(함수)내 return(반환값) 뒤로 jsx 문법 그외 js
    // jsx 에서 html 없는 마크업들은 모두 컴포넌트이며 외부 호출시 import 한다.
    // <a> 새로고침(f5)포함 vs NavLink 새로고침(f5)미포함
    return(<>
        <nav> {/* jsx 형식의 주석처리 */} {/* nav 마크업 */}
            <a href="/"> 박진감보고싶다 </a>
            <NavLink to="/"> 생명주기 </NavLink>
            <NavLink to="/local"> 내부통신 </NavLink>
            <NavLink to="/external"> 외부통신 </NavLink>
        </nav>
        </>)
}