import React from 'react';
import './App.css';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

const books = [
  { id: 101, bname: 'Master React', price: 669 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 799 },
  { id: 103, bname: 'Mongo Essentials', price: 449 },
];

function App() {
  const showBooks = true;
  const showCourses = true;
  const showBlogs = true;

  return (
    <div className="App" style={{ display: 'flex', justifyContent: 'space-around' }}>
      {showCourses && <CourseDetails />}
      {showBooks && <BookDetails books={books} />}
      {showBlogs ? <BlogDetails /> : <p>No Blog Content</p>}
    </div>
  );
}


export default App;
