package Helper;

public class UserInfo {

    private String clientName;
    private String address;
    private String phone;
    private String username;
    private String password;

    public UserInfo(String clientName, String phone, String username, String password) {
        this.clientName = clientName;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}