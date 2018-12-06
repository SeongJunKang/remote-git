import Counter from '../components/Counter';
import * as actions from '../actions';
import { connect } from 'react-redux';
import { getRandomColor } from '../utils';

// 1. Store에 저장된 state값을 props로 연결
// connect()의 첫번째 인자값
const mapStateToProps = (state) => ({
    color: state.color,
    number: state.number
});

// 2. dispatch
const mapDispatchToProps = (dispatch) => ({
    onIncrement: () => dispatch(actions.increment()),
    onDecrement: () => dispatch(actions.decrement()),
    onSetColor: () => {
        const color = getRandomColor();
        dispatch(actions.setcolor(color));
    }
});

/*Counter 컴포넌트를 애플리케이션의 데이터 레이어와 묶는 역할을 합니다.*/
const CounterContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(Counter);
export default CounterContainer;