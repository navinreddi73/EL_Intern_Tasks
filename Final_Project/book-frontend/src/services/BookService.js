import axios from "axios";

const BASE_URL = "http://localhost:8080/books";

class BookService {
  getAllBooks() {
    return axios.get(BASE_URL);
  }

  createBook(book) {
    return axios.post(BASE_URL, book);
  }

  deleteBook(id) {
    return axios.delete(`${BASE_URL}/${id}`);
  }
}

export default new BookService();
