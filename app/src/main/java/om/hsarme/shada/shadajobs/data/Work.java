package om.hsarme.shada.shadajobs.data;

import java.io.Serializable;

/**
 * Created by user on 26/11/2017.
 */

public class Work implements Serializable{//todo
    private String job;
    private String location;
    private String company;
    private int age;
    private String email;
    private String phone;
    private String keyId;
    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //    public Work(String name, String location, String company, String age, String email, int phone){
//        this.name=name;
//        this.location=location;
//        this.company=company;
//        this.age=age;
//        this.email=email;
//        this.phone=phone;
//    }
    public Work(){}

//    public Work(String name, String location, String company, String age, String email, int phone,String keyId) {
//        this.name = name;
//        this.location = location;
//        this.company = company;
//        this.age=age;
//        this.email=email;
//        this.phone=phone;
//        this.keyId=keyId;
//    }



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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }


    public String toString(){
        return "Work{"+"job:"+job+","+"Location:"+location+","+
                "Company:"+company+","+"Age"+age+","+"Email:"+email+","+
                "Phone:"+phone+"}";
    }

}
