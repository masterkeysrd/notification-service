import axios from "axios";
import { NotificationRecord, Page, Pageable } from "../types";
import PaginationUtils from "../utils/PaginationUtils";

class NotificationHistoryService {
  protected baseUrl = "/api/v1/notification-history";

  async getNotificationHistory(
    pageable: Pageable
  ): Promise<Page<NotificationRecord>> {
    const params = PaginationUtils.toPaginationParams(pageable);

    return axios
      .get<Page<NotificationRecord>>(`${this.baseUrl}?${params}`)
      .then((response) => response.data);
  }
}

export default new NotificationHistoryService();
