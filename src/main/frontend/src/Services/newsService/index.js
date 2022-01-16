import axios from "axios";

class NewsServices {
  async getAllNews() {
    try {
      const response = await axios.get("http://localhost:8080/news");
      return await response;
    } catch (error) {
      console.error(error);
    }
  }
}

export default new NewsServices();
