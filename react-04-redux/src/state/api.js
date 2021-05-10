import {createAsyncThunk} from "@reduxjs/toolkit";
import axios from "axios";
import {addDepartment, addStudent, deleteStudent} from "./actions";

/**
 interface ThunkAPI {
  dispatch: Function
  getState: Function
  extra?: any
  requestId: string
  signal: AbortSignal
}
 */

const fetchStudentsApi = createAsyncThunk(
    'API_FETCH_STUDENTS',
    async (_, thunkAPI) => {
        const studentsResponse = await axios.get('http://localhost:8080/student');
        studentsResponse.data._embedded.student.map( x => thunkAPI.dispatch(addStudent({student: x})));
        return studentsResponse.data._embedded.student;
    }
);

const deleteStudentApi = createAsyncThunk(
    'API_DELETE_STUDENT',
    async (studentLink, thunkAPI) => {
        axios.get(studentLink).then( resp => {
            thunkAPI.dispatch(deleteStudent({student: resp.data}))
        })
        await axios.delete(studentLink);
    }
)

const createStudentApi = createAsyncThunk(
    'API_CREATE_STUDENT',
    async (payload, thunkAPI) => {
        const resp = await axios.post("http://localhost:8080/student", payload.student);
        thunkAPI.dispatch(addStudent({student: resp.data}));
        console.log(resp.data)
    }
)

const fetchDepartmentsApi = createAsyncThunk(
    'API_FETCH_DEPARTMENTS',
    async (_, thunkAPI) => {
        const departmentsResponse = await axios.get('http://localhost:8080/department');
        departmentsResponse.data._embedded.department.map( x => thunkAPI.dispatch(addDepartment({department: x})));
        return departmentsResponse.data._embedded.department;
    }
);

export {fetchStudentsApi, fetchDepartmentsApi, deleteStudentApi, createStudentApi};