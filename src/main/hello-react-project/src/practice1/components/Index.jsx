import axios from "axios"
import { useEffect, useState } from "react";
import { Link } from "react-router-dom"

export default function Index( props ){

    // [2] REST API 에게 받은 자료 저장하는 상태(state)변수
    const [ taskAry , setTaskAry ] = useState( [ ] ); // 초기값은 빈배열 , 추후에 rest 결과 담기 

    // [1] REST API 에게 전제조회 자료 요청 
    const taskList = async() => {
        try{
            const response = await axios.get( 'http://localhost:8080/api/task' );  
            const data = response.data;                                             
            setTaskAry( data );
        }catch{ console.log( e ) }
    } // f end 

    // [3] 컴포넌트 생명주기 , REST API 통신 응답 처리된 후 재렌더링(새로고침)
    useEffect( ( ) => { taskList(); } , [ ] ) // 의존성배열이 빈배열이면 최초1번 실행 

    // [4] 삭제 요청 REST API , delete update , write 존재하는 키워드 이므로 불가능하다.
    const deleteTask = async( id )=>{
        const result = confirm( '정말 취소할까요? '); // 확인true , 취소false 
        if( result == true ){
            const response = await axios.delete('http://localhost:8080/api/task?id='+id);
            // 본문이 없으므로 본문으로 분기하지 않고 HTTP 응답 코드 분기
            if( response.status == 204 ){ alert('삭제성공'); taskList(); } 
            else{ alert('삭제실패'); }
        }



    }

    return (<>
        <h3> 전체조회 </h3>
        <a href="/task/create"> 등록(깜빡임있음) </a>       { /* HTML 이동마크업 */}
        <Link to="/task/create"> 등록(깜빡임없음) </Link>    { /* 라우터 이동마크업 */}
        <table>
            <thead border = "1">
                <tr>
                    <th>번호</th><th>제목</th><th> 요청자명 </th>
                    <th>상태</th><th>등록일</th><th> 비고 </th>
                </tr>
            </thead>
            <tbody>
                { 
                    taskAry.map( (task) => { 
                        return (
                            <tr key={task.id}>
                                <td>{ task.id }</td><td>{ task.title }</td><td>{ task.requester }</td>
                                <td> { task.status } </td><td> { task.updateAt.split('T')[0] } </td>
                                <td> 
                                    <button> <Link to={'/task/detail?id='+task.id} > 상세보기 </Link> </button>
                                    <button> 수정 </button>
                                    <button onClick={ ()=>{deleteTask(task.id);}}> 삭제 </button>
                                </td>
                            </tr>
                        )
                    })
                }
            </tbody>
        </table>
    </>)
}