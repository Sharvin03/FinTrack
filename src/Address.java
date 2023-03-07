public class Address {
    private String street;
    private String district;
    private String postcode;
    private String state;

    // constuctor can be overloaded (repeated but with different parameters)
    public Address(String street, String district, String postcode, String state) {
        this.street = street;
        this.district = district;
        this.postcode = postcode;
        this.state = state;
    }
    public String getStreet() {
        return this.street;
    }
    public String getDistrict() {
        return this.district;
    }
    public String getPostcode() {
        return this.postcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}

