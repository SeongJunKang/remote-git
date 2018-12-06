import * as types from './ActionTypes';

// Increment 액션 함수 정의
export const increment = () => ({
    type: types.INCREMENT
});
// Decrement 액션 함수 정의
export const decrement = () => ({
    type: types.DECREMENT
});
// setcolor 액션 함수 정의
export const setcolor = (color) => ({
    type: types.SET_COLOR,
    color
});