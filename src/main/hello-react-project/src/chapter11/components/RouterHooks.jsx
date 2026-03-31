import { useLocation, useSearchParams } from "react-router-dom"

export default function RouterHooks(props){

    const location = useLocation();

    // [1] useSearchParams 훅 선언한다.  이유 : URL 상의 쿼리스트링 값 가져오기
    const [ searchParams , setSearchParams ] = useSearchParams();
    const mode = searchParams.get('mode'); // 쿼리스트링내 mode 변수명 값 가져오기
    const pageNum = searchParams.get('pageNum'); // 쿼리스트링내 pageNum 변수명 값 가져오기
    
    // [2] changeMode, // 만약에 mode가 list 이면 view 변경 아니면 list 변경
    const changeMode = () => {
        const nextMode = (mode==='list') ? 'view' : 'list'; 
        setSearchParams( { mode : nextMode , pageNum } )
    }

    // [3] nextPage , 만약에 pageNum가 null 이면
    const nextPage = () => {
        let pageTemp = (pageNum == null || isNaN(pageNum)) ? 1 : parseInt(pageNum) + 1;
        setSearchParams( {mode : mode , pageNum : pageTemp } )
    }

    // [4] prevPage, 만약에 pageNum가 null 이면 1페이지 아니면 -1
    const prevPage = ()=>{
        let pageTemp = (pageNum == null || isNaN(pageNum)) ? 1 : parseInt( pageNum) -1;
        setSearchParams( { mode : mode , pageNum : pageTemp } )
    }

    return(<>
    <h2> 라우터 관련 Hook </h2>
    <div>
        <ul>
            <li> URL : {location.pathname}</li>
            <li> 쿼리스트링 : {location.search}</li>
            <li> mode : {mode} </li>
            <li> pageNum : {pageNum} </li>
        </ul>
        <button onClick={changeMode}>mode변경</button>
        <button onClick={prevPage}>이전Page</button>
        <button onClick={nextPage}>다음Page</button>
    </div>
        
    </>)
}