import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignIn from './components/SignIn';
import Assignments from './components/Assignments';
function App() {
  return (
    <div>
        <Router>
          <Routes>
              <Route path="/" element={<SignIn />} />
              <Route path="/assignments" element={<Assignments />} />
          </Routes>
        </Router>
     </div>
  );
}

export default App;