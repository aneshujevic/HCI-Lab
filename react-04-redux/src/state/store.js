import {configureStore} from "@reduxjs/toolkit";
import {departmentsReducer, studentsReducer} from "./reducers";

const store = configureStore({
    reducer: {
        students: studentsReducer,
        departments: departmentsReducer
    },
})

export {store};