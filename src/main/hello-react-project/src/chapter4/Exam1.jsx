
// 컴포넌트 만드는 방법
// 1. 해당 폴더를 오른쪽 클릭 -> [new file] -> 
// 2. 첫 글자가 대문자로 시작하는 .jsx 파일확장자로 생성한다.
// 예] Exam1.jsx
// 3. function 컴포넌트명(){}
// 4. 컴포넌트내 { return ( <> JSX문법 </> )}
// 5. 파일내 내보내기 할 컴포넌트 1개 , export default 컴포넌트명

// (1) FrontComp 컴포넌트 생성
function FrontComp( props ){ // props는 함수/컴포넌트 의 매개변수이며 프롭스 객체이다.

    console.log(props);
    // props가 머냐면  <FrontComp propData1={frontData} frTitle="프론트엔드"></FrontComp>

    const liRows = []; // 배열선언
    for( let i = 0 ; i<props.propData1.length ; i++ ){
        liRows.push(
                <li key={i}> {props.propData1[i]} </li>
        );
    }
    return (<>
        <li> { props.frTitle } </li>
        <ul>
            {liRows}
        </ul>
    </>)
} // c END

const BackComp = ({propData2 , baTitle}) => {
    // const ( a , b ) = { a : 1 , b : 2 } // 구조분해 , a속성 b속성으로 구성된 객체를 a변수 b변수로 분해한다.
    // confirm.log( a ); // 구조분해한 변수를 사용한다.
    // 즉] props는 객체인데.  const{ 변수명1 , 변수명2 } = props


    const liRows = []
    let keyCnt = 0;
    for( let row of propData2 ){
        liRows.push(
            <li key={ keyCnt++ }>{ row } </li>
        );
    }
    return(<>
        <li> {baTitle} </li>
        <ul>
            { liRows }
        </ul>
    </>)
}

    /* (1) 구조분해 없이 여러개 속성을 한꺼번에 받기. */
    function MyComponent(props){

        // props 에 존재하지 않은 속성명은 출력되지 않는다. < 상위 컴포넌트에서 전달받은 속성명 과 속성값 만 사용가능. >

        return (<>
        <p>
            {props.p1},{props.p2},{props.p3},{props.p4},{props.p5}
        </p>
            </>)
    }

    /* (2) 구조분해 사용해 필요한 속성만 받기 */
    function MyComponent2( { p1 , p3 } ){
        return(<>
            <p> { p1 } , { p3 } </p>
        </>)
    }

    function Exam1(){

    const frontData = [ 'HTML5' , 'CSS3' , 'Javascript' , 'jQuery' ];
    const backData = [ 'Java' , 'Oracle' , 'JSP' , 'SpringBoot' ]

    return(<> 
        <h3> 프롭스 예제 p.87 </h3>
        <ol>
        <FrontComp propData1={frontData} frTitle="프론트엔드"></FrontComp>
        <BackComp propData2={backData} baTitle="백엔드"></BackComp>
        </ol>
        <h3> props 객체 p.90 </h3>
        <MyComponent p1={"HTML"} p2="CSS" p3={'Javascript'} p4={"jQuery"} />
        <MyComponent2 p1={"HTML"} p2="CSS" p3={'Javascript'} p4={"jQuery"} />
     </>
    )  // R END
} // C END
export default Exam1;