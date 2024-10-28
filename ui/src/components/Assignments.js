import React, { useState, } from 'react';
import { Button, Input } from 'antd';
import './Assignments.css'

function Assignments(){
    
    const tasks = [
      { id: 1, title: 'Задание 1' },
      { id: 2, title: 'Задание 2' },
      { id: 3, title: 'Задание 3' },
    ];


    return(
        <div>
            <header className='header'>
              <h1>Task</h1>
            </header>
            <main>
              <ul>
                {tasks.map(task => (
                  <li key={task.id}>{task.title}</li>
                ))}
              </ul>
            </main>
          </div>
    );
}

export default Assignments;