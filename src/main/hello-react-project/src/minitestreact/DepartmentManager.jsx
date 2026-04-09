import React from "react";

export default function DepartmentManager() {
  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form className="dept-input">
        <input type="text" placeholder="신규 부서명 입력" />
        <button>추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>개발팀</td>
            <td>
              <span className="edit">수정</span>
              <span className="delete">삭제</span>
            </td>
          </tr>
          <tr>
            <td>디자인팀</td>
            <td>
              <span className="edit">수정</span>
              <span className="delete">삭제</span>
            </td>
          </tr>
          <tr>
            <td>기획팀</td>
            <td>
              <span className="edit">수정</span>
              <span className="delete">삭제</span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}