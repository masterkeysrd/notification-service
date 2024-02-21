import AppBar from "@mui/material/AppBar";
import Button from "@mui/material/Button";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Container } from "@mui/system";
import { Outlet } from "react-router";
import { Link } from "react-router-dom";

function RootRoute() {
  return (
    <>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Notification Service
          </Typography>
          <Button color="inherit" component={Link} to="/send-message">Send Message</Button>
          <Button color="inherit" component={Link} to="/notification-history">Notification History</Button>
        </Toolbar>
      </AppBar>

      <Container>
        <Outlet />
      </Container>
    </>
  );
}

export default RootRoute;
