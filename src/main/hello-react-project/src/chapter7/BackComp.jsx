// p.117
// 부모 컴포넌트로부터 상태변경 함수를 props로 받아서
// props { } 구조분해할당하여 
// a 클릭하면 상태를 back 으로 수정한다.
const BackComp = ( {setMode} ) => {
    return (<>
        <li>
            <a href="/" onClick={()=>{
                event.preventDefault();
                setMode('back');
            }}>백엔드</a>
        </li>
        <ul>
            <li> Java </li>
            <li> Oracle </li>
            <li> JSP </li>
            <li> Spring Boot </li>
        </ul>
    </>)
}
export default BackComp;