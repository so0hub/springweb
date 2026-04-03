import { Route, Routes } from "react-router-dom";
import Login from "./pages/member/Login";
import Header from "./components/Header";
import Write from "./pages/member/board/Write";
import Sign from "./pages/member/Sign";

export default function App( props ){
    return (
        <div id="wrap">
            <Header/>{ /* 헤더 */}
            <Routes>
                { /* 본문들 */ }
                <Route path="/member/login" element={ <Login/> } />
                <Route path="/board/write" element={ <Write/> } />
                <Route path="/member/signup" element={ <Sign/> } />
            </Routes>
            { /* 푸터 */ }
        </div>
    )
}