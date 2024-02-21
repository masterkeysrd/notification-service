import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableFooter,
  TableHead,
  TablePagination,
  TableRow,
} from "@mui/material";
import { NotificationRecord, Page, Pageable } from "../types";

export type NotificationHistoryTableProps = {
  loading: boolean;
  error: boolean;
  response: Page<NotificationRecord> | null;
  pageable: Pageable;
  onPageableChange: (pageable: Pageable) => void;
};

function NotificationHistoryTable({
  loading,
  error,
  response,
  pageable,
  onPageableChange,
}: NotificationHistoryTableProps) {
  const handleChangePage = (_: unknown, newPage: number) => {
    onPageableChange({ ...pageable, page: newPage });
  };

  const handleChangeRowsPerPage = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    onPageableChange({ ...pageable, size: parseInt(event.target.value, 10) });
  };

  return (
    <TableContainer>
      <Table>
        <TableHeaders />
        <TableBody>
          <TableAlerts loading={loading} error={error} />
          <TableContent records={response?.content || []} />
        </TableBody>
        <TableFooter>
          <TablePaginator
            count={response?.totalElements || 0}
            page={pageable.page}
            rowsPerPage={pageable.size}
            onPageChange={handleChangePage}
            onRowsPerPageChange={handleChangeRowsPerPage}
          />
        </TableFooter>
      </Table>
    </TableContainer>
  );
}

function TableHeaders() {
  return (
    <TableHead>
      <TableRow>
        <TableCell>ID</TableCell>
        <TableCell>User ID</TableCell>
        <TableCell>Channel</TableCell>
        <TableCell>Category</TableCell>
        <TableCell>Destination</TableCell>
        <TableCell>Message</TableCell>
        <TableCell>Status</TableCell>
        <TableCell>Date</TableCell>
      </TableRow>
    </TableHead>
  );
}

function TableContent({ records }: { records: NotificationRecord[] }) {
  return (
    <>
      {records.map((record) => (
        <TableRow key={record.id}>
          <TableCell>{record.id}</TableCell>
          <TableCell>{record.userId}</TableCell>
          <TableCell>{record.channel}</TableCell>
          <TableCell>{record.categoryName}</TableCell>
          <TableCell>{record.destination}</TableCell>
          <TableCell>{record.message}</TableCell>
          <TableCell>{record.status}</TableCell>
          <TableCell>{new Date(record.timestamp).toLocaleString()}</TableCell>
        </TableRow>
      ))}
    </>
  );
}

function TableAlerts({ loading, error }: { loading: boolean; error: boolean }) {
  return (
    <>
      {loading && (
        <TableRow>
          <TableCell colSpan={8}>Loading...</TableCell>
        </TableRow>
      )}

      {error && (
        <TableRow>
          <TableCell colSpan={8}>Error: {error}</TableCell>
        </TableRow>
      )}
    </>
  );
}

function TablePaginator({
  count,
  page,
  rowsPerPage,
  onPageChange,
  onRowsPerPageChange,
}: {
  count: number;
  page: number;
  rowsPerPage: number;
  onPageChange: (event: unknown, newPage: number) => void;
  onRowsPerPageChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
}) {
  return (
    <TableRow>
      <TablePagination
        count={count}
        page={page}
        rowsPerPage={rowsPerPage}
        onPageChange={onPageChange}
        onRowsPerPageChange={onRowsPerPageChange}
      />
    </TableRow>
  );
}

export default NotificationHistoryTable;
