public class UserService
{
    private String username = null;
    private boolean authenticated = false;

    public UserService() {}

    public boolean userExists(String username)
    {
        return true;
    }

    public boolean authenticated()
    {
        return this.authenticated;
    }

    public void auth(String user)
    {
        if (userExists(user))
        {
            this.username = user;
            this.authenticated = true;
        }
        else
        {
            throw new RuntimeException("Attempt to auth user which does not exist");
        }
    }

    public void deauth()
    {
        this.username = null;
        this.authenticated = false;
    }
}
