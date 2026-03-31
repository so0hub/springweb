import { Outlet } from "react-router-dom";


export default function CommonLayout(props){
    return(<>
        <div>
            <header style={ {background : 'lightgray',padding:'10px'}}>
                Outlet 컴포넌트 알아보기
            </header>
            <article>
                <Outlet/> {/* 자식 컴포넌트가 렌더링 될 위치 */}
            </article>
            <footer style={{background : 'lightgray' , padding : '10px'}}>
                공통 레이아웃
            </footer>
        </div>
    </>)
}