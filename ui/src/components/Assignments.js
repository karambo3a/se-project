import React, { useState, } from 'react';
import './Assignments.css'
import Task from './Task';

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
                {tasks.map(task => (
                  <Task key={task.id} title={task.title}/>
                ))}
            </main>
          </div>
    );
}

export default Assignments;