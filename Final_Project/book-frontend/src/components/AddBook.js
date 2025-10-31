import axios from "axios";
import { useState, useEffect } from "react";

function AddBook() {
  const [books, setBooks] = useState([]);
  const [authors, setAuthors] = useState([]);
  const [newBook, setNewBook] = useState({
    title: "",
    isbn: "",
    price: "",
    publishedDate: "",
    authorId: "",
  });

  const [newAuthor, setNewAuthor] = useState("");

  useEffect(() => {
    loadBooks();
    loadAuthors();
  }, []);

  const loadBooks = () => {
    axios
      .get("http://localhost:8080/books")
      .then((res) => setBooks(res.data))
      .catch((err) => console.error("Error fetching books:", err));
  };

  const loadAuthors = () => {
    axios
      .get("http://localhost:8080/authors")
      .then((res) => setAuthors(res.data))
      .catch((err) => console.error("Error fetching authors:", err));
  };

  const addAuthor = () => {
    if (!newAuthor.trim()) return;
    axios
      .post("http://localhost:8080/authors", { name: newAuthor })
      .then(() => {
        setNewAuthor("");
        loadAuthors(); // refresh dropdown
      })
      .catch((err) => console.error("Error adding author:", err));
  };

  const handleInputChange = (e) => {
    setNewBook({ ...newBook, [e.target.name]: e.target.value });
  };

  const addBook = () => {
    if (!newBook.title || !newBook.authorId) {
      alert("Please fill title and select author");
      return;
    }

    const bookData = {
      title: newBook.title,
      isbn: newBook.isbn,
      price: parseFloat(newBook.price),
      publishedDate: newBook.publishedDate,
      author: { id: parseInt(newBook.authorId) },
    };

    axios
      .post("http://localhost:8080/books", bookData)
      .then(() => {
        setNewBook({
          title: "",
          isbn: "",
          price: "",
          publishedDate: "",
          authorId: "",
        });
        loadBooks();
      })
      .catch((err) => console.error("Error adding book:", err));
  };

  const deleteBook = (id) => {
    axios
      .delete(`http://localhost:8080/books/${id}`)
      .then(() => loadBooks())
      .catch((err) => console.error("Error deleting book:", err));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>📚 Bookstore Management</h2>

      <h3>Add Author</h3>
      <input
        type="text"
        placeholder="Author Name"
        value={newAuthor}
        onChange={(e) => setNewAuthor(e.target.value)}
      />
      <button onClick={addAuthor}>Add Author</button>

      <h3>Add Book</h3>
      <input
        type="text"
        name="title"
        placeholder="Title"
        value={newBook.title}
        onChange={handleInputChange}
      />
      <input
        type="text"
        name="isbn"
        placeholder="ISBN"
        value={newBook.isbn}
        onChange={handleInputChange}
      />
      <input
        type="number"
        name="price"
        placeholder="Price"
        value={newBook.price}
        onChange={handleInputChange}
      />
      <input
        type="text"
        name="publishedDate"
        placeholder="dd/mm/yyyy"
        value={newBook.publishedDate}
        onChange={handleInputChange}
      />

      <select
        name="authorId"
        value={newBook.authorId}
        onChange={handleInputChange}
      >
        <option value="">Select Author</option>
        {authors.map((a) => (
          <option key={a.id} value={a.id}>
            {a.name}
          </option>
        ))}
      </select>

      <button onClick={addBook}>Add Book</button>

      <h3>Book List</h3>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Price</th>
            <th>Published Date</th>
            <th>Author</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {books.map((b) => (
            <tr key={b.id}>
              <td>{b.id}</td>
              <td>{b.title}</td>
              <td>{b.isbn}</td>
              <td>{b.price}</td>
              <td>{b.publishedDate}</td>
              <td>{b.author?.name}</td>
              <td>
                <button onClick={() => deleteBook(b.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default AddBook;
