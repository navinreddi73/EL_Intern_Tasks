import axios from "axios";
import { useState, useEffect } from "react";

function AddBook() {
  const [authors, setAuthors] = useState([]);
  const [newAuthor, setNewAuthor] = useState("");

  useEffect(() => {
    loadAuthors();
  }, []);

  const loadAuthors = () => {
    axios.get("http://localhost:8080/authors")
      .then((response) => setAuthors(response.data))
      .catch((error) => console.error("Error fetching authors:", error));
  };

  const addAuthor = () => {
    if (!newAuthor) return;
    axios.post("http://localhost:8080/authors", { name: newAuthor })
      .then(() => {
        setNewAuthor("");
        loadAuthors(); // refresh dropdown
      })
      .catch((error) => console.error("Error adding author:", error));
  };

  return (
    <div>
      <h2>Add Author</h2>
      <input
        type="text"
        placeholder="Author Name"
        value={newAuthor}
        onChange={(e) => setNewAuthor(e.target.value)}
      />
      <button onClick={addAuthor}>Add Author</button>

      <h3>Select Author</h3>
      <select>
        {authors.map((a) => (
          <option key={a.id} value={a.id}>{a.name}</option>
        ))}
      </select>
    </div>
  );
}

export default AddBook;
