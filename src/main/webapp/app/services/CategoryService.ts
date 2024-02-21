import axios from "axios";
import { Category } from "../types/Category";

class CategoryService {
  protected baseUrl = "/api/v1/categories";

  async getCategories(): Promise<Category[]> {
    return axios
      .get<Category[]>(`${this.baseUrl}`)
      .then((response) => response.data);
  }
}

export default new CategoryService();