/** Bez redux toolkit-a
 * function addStudent(student) {
 *     return {
 *         type: 'ADD_STUDENT',
 *         payload: { student },
 *     }
 * }
 *function deleteStudent(student) {
 *     return {
 *         type: 'DELETE_STUDENT',
 *         payload: { student },
 *     }
 * }
 * function addDepartment(department) {
 *     return {
 *         type: 'ADD_DEPARTMENT',
 *         payload: { department },
 *     }
 * }
**/
import {createAction} from "@reduxjs/toolkit";


const addStudent = createAction('ADD_STUDENT');
// addStudent({student: someStudentObj}) izgleda kao
// {type: 'ADD_STUDENT', payload: {student: someStudentObj}}

const deleteStudent = createAction('DELETE_STUDENT');

const addDepartment = createAction('ADD_DEPARTMENT');

export {addStudent, deleteStudent, addDepartment}