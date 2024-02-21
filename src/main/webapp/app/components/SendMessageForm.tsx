import { FormEvent, useEffect } from "react";
import { Category } from "../types";
import {
  Alert,
  Box,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
  Typography,
} from "@mui/material";

export type SendMessageFormProps = {
  categories: Category[];
  loading: boolean;
  success: boolean;
  error: boolean;
  result: string;
  getCategories: () => void;
  sendMessage: (category: string, message: string) => void;
};

function SendMessageForm({
  categories,
  loading,
  success,
  error,
  result,
  getCategories,
  sendMessage,
}: SendMessageFormProps) {
  useEffect(() => {
    getCategories();
  }, []);

  const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const form = new FormData(event.currentTarget);
    const category = form.get("category") as string;
    const message = form.get("message") as string;

    sendMessage(category, message);
  };

  return (
    <Box m={2}>
      <Typography variant="h4" gutterBottom>
        Send Message
      </Typography>
      {success && (
        <Alert variant="filled" severity="success">
          {result}
        </Alert>
      )}
      {error && (
        <Alert variant="filled" severity="error">
          Failed to send message
        </Alert>
      )}
      <form onSubmit={handleSubmit}>
        <FormControl fullWidth margin="normal" required>
          <InputLabel id="category-label">Category</InputLabel>
          <Select labelId="category-label" name="category">
            {categories.map((category) => (
              <MenuItem key={category.id} value={category.id}>
                {category.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <TextField
          label="Message"
          name="message"
          multiline
          rows={4}
          required
          margin="normal"
          fullWidth
        />
        <Box mt={2}>
          <Button
            type="submit"
            variant="contained"
            color="primary"
            disabled={loading}
          >
            {loading ? "Sending..." : "Send Message"}
          </Button>
        </Box>
      </form>
    </Box>
  );
}

export default SendMessageForm;
