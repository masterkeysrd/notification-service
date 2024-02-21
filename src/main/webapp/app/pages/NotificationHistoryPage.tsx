import { useEffect } from "react";
import { Box, Typography } from "@mui/material";
import { Pageable } from "../types";
import useGetNotificationHistory from "../hooks/useGetNotificationHistory";
import NotificationHistoryTable from "../components/NotificationHistoryTable";

function NotificationHistoryPage() {
  const {
    loading,
    error,
    response,
    pageable,
    setPageable,
    getNotificationHistory,
  } = useGetNotificationHistory();

  useEffect(() => {
    getNotificationHistory();
  }, [pageable]);

  const onPageableChange = (pageable: Pageable) => {
    setPageable(pageable);
  };

  return (
    <Box mt={3}>
      <Typography variant="h4" gutterBottom>
        History
      </Typography>
      <NotificationHistoryTable
        loading={loading}
        error={error}
        response={response}
        pageable={pageable}
        onPageableChange={onPageableChange}
      />
    </Box>
  );
}

export default NotificationHistoryPage;
