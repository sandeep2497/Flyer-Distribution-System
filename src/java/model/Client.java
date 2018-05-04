package model;

public class Client {
    int userId,streetnumber,agent;
    String name, agentname,lastname,streetName,city,province,postalcode,teloffice,telcell,email,company,companytype;
    //Constructor so we can update client in db
    public Client(int userId, int streetnumber, String name, String lastname, String streetName, String city, String province, String postalcode, String teloffice, String telcell, String email, String company, String companytype) {
        this.userId = userId;
        this.streetnumber = streetnumber;
        this.name = name;
        this.lastname = lastname;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
        this.teloffice = teloffice;
        this.telcell = telcell;
        this.email = email;
        this.company = company;
        this.companytype = companytype;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }
    
    public  Client(){
    }
    //All getters and setters
    public int getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(int streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTeloffice() {
        return teloffice;
    }

    public void setTeloffice(String teloffice) {
        this.teloffice = teloffice;
    }

    public String getTelcell() {
        return telcell;
    }

    public void setTelcell(String telcell) {
        this.telcell = telcell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }
   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
