import React, { useState, } from 'react';
import PropTypes from 'prop-types';
import { Button, Input } from 'antd';
import './Task.css'

function Task(props){
    
    const [title, ChangeTitle] = useState('Task');


    return(
        <div >
            <Button className='task'> {props.title} </Button>
        </div>
    );
}

export default Task;

Task.propTypes = {
    title: PropTypes.string
};