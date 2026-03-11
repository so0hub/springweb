// p.110
const BackComp = ( {onMyEvent} ) => {
    return (<>
        <li>
            <a href="/" onClick={(event)=>{
                event.preventDefault();
                onMyEvent2('백엔드 클릭됨(자식 전달)');
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