public class User {
    String fname;
    String mname;
    String lname;
    String gender;
    String phoneNumber;
    String email;
    String password;
    String confirmPassword;

    User(String fname,
            String mname,
            String lname,
            String gender,
            String phoneNumber,
            String email,
            String password) {
        this.fname = fname;
        this.mname = mname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMname() {
        return mname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
