package om.hsarme.shada.shadajobs.data;

/**
 * Created by user on 26/11/2017.
 */

public class Work {
    private String name, location, company, age;
    private boolean isTaken;
    private String keyId;

    public Work(String name, String location, String company, String age){
        this.name=name;
        this.location=location;
        this.company=company;
        isTaken=false;
    }
    public Work(){}
    public Work(String name, String location, String company, String age,boolean isTaken,String keyId) {
        this.name = name;
        this.location = location;
        this.company = company;
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
}
