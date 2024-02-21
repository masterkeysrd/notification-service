import React from "react";
import { Box, TextField } from "@mui/material";

function SendMessagePage() {
  return (
    <Box>
      <h1>Send Message</h1>
      <form>
        <TextField multiline rows={4} label="Message" />
      </form>
    </Box>
  );
}

export default SendMessagePage;
