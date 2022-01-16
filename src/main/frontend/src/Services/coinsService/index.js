import axios from "axios";

class CoinsService {
  async getAllCoins() {
    try {
      const response = await axios.get("http://localhost:8080/coins");
      return await response;
    } catch (error) {
      console.error(error);
    }
  }

  async getTopGainers() {
    try {
      const response = await axios.get("http://localhost:8080/topGainers");
      return await response;
    } catch (error) {
      console.error(error);
    }
  }

  async getTopLosers() {
    try {
      const response = await axios.get(" http://localhost:8080/topLosers");
      return await response;
    } catch (error) {
      console.error(error);
    }
  }
}

export default new CoinsService();
