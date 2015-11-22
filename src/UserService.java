public class UserService {
    private String username = null;
    private boolean authenticated = false;

    public UserService() {
    }

    public boolean userExists(String username) {
        return true;
    }

    public boolean authenticated() {
        return authenticated;
    }

    public void auth(String user) {
        if (userExists(user)) {
            username = user;
            authenticated = true;
        } else {
            throw new RuntimeException("Attempt to auth user which does not exist");
        }
    }

    public void register(String username) {

    }

    public String getAuthedUser() {
        return username;
    }

    public void deauth() {
        username = null;
        authenticated = false;
    }
}
