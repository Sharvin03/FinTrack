public class Name {

    private String fname;
    private String lname;
    private String mname;

    public Name(String fname, String mname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
    }

    public Name() {

    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }
}


