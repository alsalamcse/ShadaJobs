package om.hsarme.shada.shadajobs.data;

/**
 * Created by user on 26/11/2017.
 */

public class Work {
    private String name;
    private String location;
    private String company;
    private int age;
    private String email;
    private int phone;
    private String keyId;
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
        return "Work{"+"name:"+name+","+"Location:"+location+","+
                "Company:"+company+","+"Age"+age+","+"Email:"+email+","+
                "Phone:"+phone+"}";
    }

}
