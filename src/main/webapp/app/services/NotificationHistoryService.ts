import axios from "axios";
import { NotificationRecord, Page } from "../types";

class NotificationHistoryService {
  protected baseUrl = "/api/v1/notification-history";

  async getNotificationHistory(): Promise<Page<NotificationRecord>> {
    return axios
      .get<Page<NotificationRecord>>(`${this.baseUrl}`)
      .then((response) => response.data);
  }
}

export default new NotificationHistoryService();
