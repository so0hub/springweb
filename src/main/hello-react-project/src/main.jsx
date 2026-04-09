import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.jsx'



// ** index.html 에서 root 가져오기 **
const root = document.querySelector('#root');


// minitest 0409
import App from './minitestreact/App';
import {BrowserRouter} from 'react-router-dom'
createRoot( root ).render(
    <BrowserRouter>
        <App />
    </BrowserRouter>
)

// reactweb 260403
// import App from './reactweb/App';
// import {BrowserRouter} from 'react-router-dom'
// createRoot( root ).render(
//     <BrowserRouter>
//         <App />
//     </BrowserRouter>
// )

// practice1 260402
// import App from './practice1/App';
// import {BrowserRouter} from 'react-router-dom'
// createRoot( root ).render(
//     <BrowserRouter>
//         <App />
//     </BrowserRouter>
// )

// Chapter12 예제
// import App from './chapter12/App.jsx';
// import { BrowserRouter } from 'react-router-dom';
// createRoot(root).render(
// <BrowserRouter>
//     <App/>
// </BrowserRouter>
// );

// Chapter11 예제
// import Exam2 from './chapter11/Exam2.jsx';
// import {BrowserRouter} from 'react-router-dom'; // [1] 라이브러리 import 하기
// createRoot(root).render(
//     // [2] 최초 렌더링되는 컴포넌트에 BrowserRouter 감싼다.
//     <BrowserRouter>
//         <Exam2/>
//     </BrowserRouter>
// );

// Chapter10 예제
// import Exam1 from './chapter10/Exam1.jsx';
// createRoot(root).render(<Exam1/>);

// Chapter9 예제
// import Exam2 from './chapter9/Exam2.jsx';
// createRoot(root).render(<Exam2/>);

// Chapter8 예제
// import Exam1 from './chapter8/Exam1.jsx';
// createRoot(root).render(<Exam1/>);

// Chapter7 예제 코드
// import Exam2 from './chapter7/Exam2.jsx';
// createRoot(root).render(<Exam2/>);


// Chapter6 예제 코드
// import Exam1 from './chapter6/Exam1.jsx';
// createRoot( root ).render( <Exam1/> );

// Chapter5 예제 코드
// import Exam2 from './chapter5/Exam2.jsx';
// createRoot( root ).render( <Exam2/>);

// Chapter4 예제 코드
// import Exam1 from './chapter4/Exam1.jsx'; // 컴포넌트 불러오기
// createRoot( root ).render( <Exam1/>) // root 에 최초 컴포넌트 렌더링 하기


// * 기존코드
// createRoot(document.getElementById('root')).render(<App />)

// // [1] index.html(싱글페이지) 에서 root 라는 id 갖는 div 호출
// const root = document.querySelector('#root');

// // [2] root 마크업에 렌더링(render)
// createRoot( root ).render(<h1>안녕하세요!</h1>)
// // vs. root.innerHTML = "<h1>안녕하세요!</h1>";

