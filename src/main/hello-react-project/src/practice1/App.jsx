import { Route, Routes } from "react-router-dom";
import Index from "./components/Index";
import Create from "./components/Create";
import Detail from "./components/Detail";
import Edit from "./components/Edit";

export default function App( props ){
    return (<>
        컴포넌트
        <Routes> 
            <Route path="/" element={ <Index /> } />
            <Route path="/task/create" element={ <Create /> } />
            <Route path="/task/detail" element={ <Detail /> } />
            <Route path="/task/edit" element={ <Edit /> } />
        </Routes>
    </>)
}