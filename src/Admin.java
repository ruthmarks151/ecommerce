public class Admin extends User{
    private String pass;

    public Admin(String name, String password) {
        super(name);
        // Save password in plaintext because why not
        pass = password;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
