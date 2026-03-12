
// p.117 , 컴포넌트 내보내기 ? 다른 jsx에서 해당하는 컴포넌트 사용하기 위해
// 부모 컴포넌트로부터 상태변경 함수를 props로 받아서
// a 클릭하면 상태를 front 으로 수정한다.
// * a 마크업 클릭하면 페이지 이동 차단
export default function FrontComp( props ){
    return (<> 
        <li> 
             <a href = "/" onClick={ () => {
                event.preventDefault();
                props.onSetMode('front');
            } }> 
                프론트엔드 
             </a> 
            </li>
        <ul>
            <li> HTML5 </li>
            <li> CSS5 </li>
            <li> Javascript </li>
            <li> jQuery </li>
        </ul>
    </>)
}