package om.hsarme.shada.shadajobs.data;

/**
 * Created by user on 26/11/2017.
 */

public class Work {
    private String name;
    private String location;
    private String company;
    private String age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private String email;
    private int phone;
    private boolean isTaken;
    private String keyId;

    public Work(String name, String location, String company, String age, String email, int phone){
        this.name=name;
        this.location=location;
        this.company=company;
        this.age=age;
        this.email=email;
        this.phone=phone;
        isTaken=false;
    }
    public Work(){}
    public Work(String name, String location, String company, String age, String email, int phone, boolean isTaken,String keyId) {
        this.name = name;
        this.location = location;
        this.company = company;
        this.age=age;
        this.email=email;
        this.phone=phone;
        this.isTaken = isTaken;
        this.keyId=keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String toString(){
        return "Work{"+"name:"+name+","+"Location:"+location+","+
                "Company:"+company+","+"Age"+age+","+"Email:"+email+","+
                "Phone:"+phone+"}";
    }

}
