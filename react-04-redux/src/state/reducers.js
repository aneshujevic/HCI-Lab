import {createReducer} from "@reduxjs/toolkit";
import {addDepartment, createStudent, deleteStudent} from "./actions";

/** Bez redux toolkit-a
 function studentReducer(state = {students: []}, action) {
        switch (action.type) {
            case ''ADD_STUDENT'':
                return {value: [...state.students.value, action.student]}
            case 'DELETE_STUDENT':
                return {
                    value: state.students.value.filter(x =>
                        x.name !== action.student.name &&
                        x.surname !== action.student.surname &&
                        x.gender !== action.student.gender
                    )
                }
            default:
                return state
        }
    }

 function departmentReducer(state = {departments: []}, action) {
        switch (action.type) {
            case 'ADD_DEPARTMENT':
                return {value: [...state.departments.value, action.department]}
            default:
                return state
        }
    }
 **/

const studentsReducer = createReducer([], (builder => {
        builder.addCase(createStudent, (state, action) => {
            state.push(action.payload.student)
        })
            .addCase(deleteStudent, (state, action) => {
                return state.filter(x =>
                    x.name !== action.payload.student.name &&
                    x.surname !== action.payload.student.surname &&
                    x.gender !== action.payload.student.gender)
            })
    })
)

const departmentsReducer = createReducer([], (builder => {
        builder.addCase(addDepartment, (state, action) => {
            state.push(action.payload.department)
        })
    })
);

export {studentsReducer, departmentsReducer};