import axios from "axios";


export default function Write(props){
    // [1] REST API로 글쓰기 요청
    const boardWrite = async( e ) => { e.preventDefault();
   
        // 0) token
        const token = localStorage.getItem('token');

        // 1) 입력받은 값 가져오기
        const btitle = e.target.btitle.value;
        const bcontent = e.target.bcontent.value;
        const uploadFile = e.target.uploadFile.files[0];
        // value : 입력받은 자료 , files : file type의 등록된 파일 , files[0] : 선택된 1개 파일

        // 2) 객체 구성하지 않고 멀티(대용량/바이트)폼 객체 , multipart/form-data
        const formData = new FormData(); // 대용량 폼을 지원하는 객체
        formData.append( 'btitle',btitle ); // .append( 속성명 , 값 );
        formData.append( 'bcontent',bcontent );
            // * 만약에 첨부파일이 존재하면 추가
            if(uploadFile){formData.append('uploadFile',uploadFile);}

        // 3) AXIOS
        const response = await axios.post(
            'http://localhost:8080/api/board/write3', // 서버 주소
            formData, // 전송할 객체/폼
            { headers:{ Authorization : `Bearer ${token}`} } // HTTP 요청 HEADER
        );

        const data = response.data;
        if( data == true ){alert('글쓰기 성공');
        }else{
            alert('글쓰기 실패!');
        }
    }
    return(<>
        <div>
            <h3> 글쓰기 페이지 </h3>
            <form onSubmit={boardWrite}>
                제목 : <input name="btitle" />                     <br/>
                내용 : <textarea name="bcontent" ></textarea>      <br/>
                첨부파일 : <input name="uploadFile" type="file" />  <br/>
                <button> 등록 </button>
            </form>
        </div>
    </>)
}