import React, { useState, } from 'react';
import { Button, Input } from 'antd';
import './Task.css'

function Task(){
    
    const [title, ChangeTitle] = useState('Task');


    return(
        <div>
            <Button> {title} </Button>
        </div>
    );
}

export default Task;

