import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(<App />)
// // [1] index.html(싱글페이지) 에서 root 라는 id 갖는 div 호출
// const root = document.querySelector('#root');

// // [2] root 마크업에 렌더링(render)
// createRoot( root ).render(<h1>안녕하세요!</h1>)
// // vs. root.innerHTML = "<h1>안녕하세요!</h1>";

