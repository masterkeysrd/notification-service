import { useState } from "react";
import MessageService from "../services/MessageService";

function useSendMessage() {
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(false);
  const [result, setResult] = useState<string | null>(null);

  const sendMessage = async (category: string, message: string) => {
    setLoading(true);
    try {
      const response = await MessageService.sendMessage(category, message);
      setSuccess(true);
      setResult(response.message);
    } catch (e) {
      setError(true);
    } finally {
      setLoading(false);
    }
  };

  return { loading, success, error, result, sendMessage };
}

export default useSendMessage;
