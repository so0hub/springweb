import axios from "axios";
import React, { useEffect, useState } from "react";

export default function DepartmentManager(props) {

  // [2] REST API 에게 받은 자료 저장하는 상태(state)변수
    const [deptList , setDeptList] = useState([]);
    
    // 부서 목록(전체 조회)
    // [1] REST API 에게 전제조회 자료 요청 
    const dpList = async()=>{
      try{
        const response = await axios.get("http://localhost:8080/api/dp/list");
        const data = response.data;
        setDeptList(data)
      }catch{ console.log(e) }
    }

    // [3] 컴포넌트 생명주기 , REST API 통신 응답 처리된 후 재렌더링(새로고침)
    useEffect ( () => {dpList();},[ ]) // 의존성배열이 빈배열이면 최초1번 실행 

    // [4] 삭제 요청 REST API , delete update , write 존재하는 키워드 이므로 불가능하다.
    const dpDelete = async(dno)=>{
      const result = confirm('정말 삭제할까요?');
      if(result == true ){
        const response = await axios.delete('http://localhost:8080/api/dp/delete?dno='+dno);
        // 본문이 없으므로 본문으로 분기하지 않고 HTTP 응답 코드 분기
        if(response.status == 204){alert('삭제가 완료되었습니다.'); dpList();}
        else{alert('삭제에 실패하였습니다.');}
      }

    }


   

    
    // 부서 등록
    const dpAdd = async( e ) => { e.preventDefault();
    const dname = e.target.dname.value;
    try{
        const response = await axios.post("http://localhost:8080/api/dp/add" , 
        {dname:dname}
      );

  if(response.data == true){
    alert("부서가 등록되었습니다.");
    dpList();

  }else{alert("부서 등록에 실패하였습니다.");}
  }catch(error){console.error('에러 발생 : ',error);
  }
}
  

  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form className="dept-input" onSubmit={dpAdd}>
        <input type="text" placeholder="신규 부서명 입력" name="dname"/>
        <button type="submit">추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          {deptList.map((dept)=>(
            <tr key={dept.dno}>
            <td>{dept.dname}</td>
            <td>
              <span className="edit" onClick={()=>{dpUpdate(dept.dno);}}>수정</span>
              <span className="delete" onClick={()=>{dpDelete(dept.dno);}}>삭제</span>
            </td>
          </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}