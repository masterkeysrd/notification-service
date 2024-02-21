import { Box } from "@mui/material";
import useGetCategories from "../hooks/useGetCategories";
import useSendMessage from "../hooks/useSendMessage";
import SendMessageForm from "../components/SendMessageForm";

function SendMessagePage() {
  const { categories, getCategories } = useGetCategories();
  const { loading, success, error, result, sendMessage } = useSendMessage();

  const handleSendMessage = (category: string, message: string) => {
    sendMessage(category, message);
  };

  return (
    <Box m={2}>
      <SendMessageForm
        categories={categories}
        loading={loading}
        success={success}
        error={error}
        result={result || ""}
        getCategories={getCategories}
        sendMessage={handleSendMessage}
      />
    </Box>
  );
}

export default SendMessagePage;
