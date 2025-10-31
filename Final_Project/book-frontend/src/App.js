import React from "react";
import AuthorManager from "./components/AuthorManager";
import AddBook from "./components/AddBook";

function App() {
  return (
    <div>
      <h1>📚 Bookstore Management</h1>
      <AuthorManager />
      <hr />
      <AddBook />
    </div>
  );
}

export default App;
