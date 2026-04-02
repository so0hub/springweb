import{ Route , Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import LifeCycle from "./components/Lifecycle";
import LocalJsonFetcher from "./components/LocalJsonFetcher";
import ExternalApiFetcher from "./components/ExternalApiFetcher";

export default function App(props){
    return(<>
    <TopNavi></TopNavi>
    {/* 새로운 컴포넌트(페이지) 만들면 라우터에 경로부터 연결해주기!!! */}
    <Routes>
        <Route path="/" element={<LifeCycle/>}> </Route>
        <Route path="/local" element={<LocalJsonFetcher/>}> </Route>
        <Route path="/external" element={<ExternalApiFetcher/>}></Route>
    </Routes>
    </>)
}