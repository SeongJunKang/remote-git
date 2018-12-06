import React, { Component } from 'react';
import TodoItem from './TodoItem';

class TodoItemList extends Component {

    // 입력을 입력할 때 마다, 랜더링을 하므로 너무 오래걸림.
    // 아래의 함수를 추가해준다면, 상태가 바뀌지 않으면 랜더링을 하지 않음.
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.todos !== nextProps.todos;
    }

    render() {
        const { todos, onToggle, onRemove } = this.props;
        /*
        // item은 id, text, checked를 가진 Object이므로 둘 중 하나를 선택해도 됨
        const todoList = todos.map((item) => (
            <TodoItem
                key={item.id}
                text={item.text}
                checked={item.checked}
                id={item.id}
                onToggle={onToggle}
                onRemove={onRemove}
            /> 
        ));
        */
        const todoList = todos.map(({id, text, checked}) => (
            <TodoItem
                key={id}
                text={text}
                checked={checked}
                id={id}
                onToggle={onToggle}
                onRemove={onRemove}
            />
        ));
        return (
            <div>
                {todoList}
            </div>
        );
    }
}
export default TodoItemList;