import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom"

export default function Detail( props ){

    // [1] 쿼리스트링의 id 가져오기 
    const [ searchParams , setSearchParams ] = useSearchParams();
    const id = searchParams.get( "id" );

    // [3] Rest Api 결과를 담는 상태 변수 
    const [ task , setTask ] = useState( null ); // 초기값은 null

    // [2] Rest API 이용하여 개별조회
    const getTaskDetail = async( ) =>{
        const response = await axios.get( 'http://localhost:8080/api/task/detail?id='+id );
        const data = response.data;
        setTask( data );
    }

    // [4] 최초 1번 Rest API 요청 
    useEffect( () => { getTaskDetail() } , [ ] )

    // [5] 만약에 최초 렌더링 이면 
    if( task == null ) return <div> 가져오는중. </div>
    
    return (<>
        <h3> 상세 페이지 </h3>
        <Link to="/"> 뒤로가기 </Link>
        <p> 번호 : { task.id } </p>
        <p> 제목 : { task.title } </p>
        <p> 내용 : { task.content } </p>
        <p> 상태 : { task.status } </p>
        <p> 등록일 : { task.createAt } </p>
    </>)
}