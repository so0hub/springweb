import React from "react";
import "./App.css";
import DepartmentManager from "./DepartmentManager";
import EmployeeManager from "./EmployeeManager";

export default function App() {
  return (
    <div className="page-wrapper">
      <div className="container">
        <h2>인사 관리 대시보드</h2>
        <p className="sub-title">부서, 사원 관리 시스템</p>

        <div className="layout">
          <DepartmentManager />
          <EmployeeManager />
        </div>
      </div>
    </div>
  );
}