import React from "react";

export default function EmployeeManager() {
  return (
    <div className="main">
      {/* 사원 등록 */}
      <form className="form-box">
        <h3>사원 등록</h3>

        <div className="form-row">
          <input type="text" placeholder="이름" />
          <input type="text" placeholder="직급" />
        </div>

        <div className="form-row">
          <select>
            <option>부서를 선택하세요</option>
            <option>개발팀</option>
            <option>디자인팀</option>
            <option>기획팀</option>
          </select>
          <input type="file" />
        </div>

        <div className="form-action">
          <button className="primary">등록</button>
        </div>
      </form>

      {/* 사원 목록 */}
      <div className="table-box">
        <h3>사원 전체 목록</h3>

        <table>
          <thead>
            <tr>
              <th>사진</th>
              <th>이름</th>
              <th>부서</th>
              <th>직급</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><img className="img-box" /> </td>
              <td>김민준</td>
              <td>개발팀</td>
              <td>선임 개발자</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>

            <tr>
              <td><img className="img-box" /> </td>
              <td>이서연</td>
              <td>디자인팀</td>
              <td>수석 디자이너</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>

            <tr>
              <td><img className="img-box" /> </td>
              <td>박도윤</td>
              <td>기획팀</td>
              <td>팀장</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}