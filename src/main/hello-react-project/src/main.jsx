import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
const root = document.querySelector('#root'); // index html 에서 root 가져오기

// Chapter5 예제 코드
import Exam2 from './chapter5/Exam2.jsx';
createRoot( root ).render( <Exam2/>);

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

