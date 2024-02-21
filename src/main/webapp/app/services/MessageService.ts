import axios from "axios";
import { SendMessageResponse } from "../types";

class MessageService {
  protected baseUrl = "/api/v1/messages";

  async sendMessage(category: string, message: string): Promise<SendMessageResponse> {
    return axios
      .post<SendMessageResponse>(`${this.baseUrl}`, { category, message })
      .then((response) => response.data);
  }
}

export default new MessageService();
