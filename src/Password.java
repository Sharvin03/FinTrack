public class Password {
    private String password;
    private String confirmPassword;

    public Password(String password,String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

}
