import { useState } from "react";
import { NotificationRecord, Page, Pageable } from "../types";
import NotificationHistoryService from "../services/NotificationHistoryService";

const initialPageable = (): Pageable => ({
  page: 0,
  size: 10,
  sort: "timestamp,desc",
});

const initialResponse = (): Page<NotificationRecord> => ({
  content: [],
  totalPages: 0,
  totalElements: 0,
  last: true,
  size: 0,
  number: 0,
  first: true,
  numberOfElements: 0,
  empty: true,
});

function useGetNotificationHistory() {
  const [pageable, setPageable] = useState<Pageable>(initialPageable());

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);
  const [response, setResponse] = useState<Page<NotificationRecord> | null>(initialResponse());

  const getNotificationHistory = async () => {
    setLoading(true);
    setError(false);

    try {
      const result = await NotificationHistoryService.getNotificationHistory(
        pageable
      );
      setResponse(result);
    } catch (e) {
      setError(true);
    } finally {
      setLoading(false);
    }
  };

  return {
    pageable,
    setPageable,
    loading,
    error,
    response,
    getNotificationHistory,
  };
}

export default useGetNotificationHistory;
