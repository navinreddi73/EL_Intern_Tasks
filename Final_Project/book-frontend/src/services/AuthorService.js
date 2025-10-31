import axios from "axios";

const BASE_URL = "http://localhost:8080/authors";

class AuthorService {
  getAllAuthors() {
    return axios.get(BASE_URL);
  }

  addAuthor(author) {
    return axios.post(BASE_URL, author);
  }
}

export default new AuthorService();
