import React, { Component } from 'react';
import TodoListTemplate from './components/TodoListTemplate';
import Form from './components/Form';
import TodoItemList from './components/TodoItemList';

const initialTodos = new Array(500).fill(0).map(
  (item, idx) => ({
    id: idx,
    text: `일정 ${idx}`,
    checked: false
  })
);

class App extends Component {
  //id = 3 // 이미 0,1,2 가 존재하므로 3으로 설정
  
  state = {
    input: '',
    todos: initialTodos
  }
  // initialTodos 추가 후에 id 값 변경해줌
  id = this.state.todos.length;
  
  handleFormChange = (e) => {
    this.setState({ input: e.target.value });
  }

  handleFormCreate = () => {
    const { input, todos } = this.state;
    this.setState({
      todos: todos.concat({
        id: this.id++,
        text: input,
        checked: false
      }),
      input: ''
    });
  }

  handleFormKeyPress = (e) => {
    if (e.key === 'Enter') {
      this.handleFormCreate();
    }
  }

  handleItemRemove = (id) => {
    this.setState({
      todos: this.state.todos.filter(todo => todo.id !== id)
    })
  }

  handleItemToggle = (id) => {
    const { todos } = this.state;
    // 파라미터로 받은 id 를 가지고 몇번째 Item인지 찾습니다.
    const index = todos.findIndex(todo => todo.id === id);
    const selected = todos[index]; // 선택한 객체
    const copyTodos = [...todos]; // 배열을 복사
    // 기존의 값들을 복사하고, checked 값을 덮어쓰기
    copyTodos[index] = {
      ...selected,
      checked: !selected.checked
    };
    this.setState({
      todos: copyTodos
    });
  }

  render() {
    const { input, todos } = this.state;
    const { handleFormChange, handleFormCreate, handleFormKeyPress, handleItemRemove, handleItemToggle } = this;
    return (
      <div>
        <TodoListTemplate form={
          <Form value={input}
            onChange={handleFormChange}
            onCreate={handleFormCreate}
            onKeyPress={handleFormKeyPress}
          />
        }>
          <TodoItemList todos={todos} onRemove={handleItemRemove} onToggle={handleItemToggle} />
        </TodoListTemplate>
      </div>
    );
  }
}

export default App;
