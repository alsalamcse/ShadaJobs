package om.hsarme.shada.shadajobs;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import om.hsarme.shada.shadajobs.data.Work;

public class AddWork extends AppCompatActivity {
    private EditText name, location, company, age;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        name=(EditText)findViewById(R.id.work);
        location=(EditText)findViewById(R.id.location);
        company=(EditText)findViewById(R.id.company);
        age=(EditText)findViewById(R.id.company);
        add=(Button)findViewById(R.id.add);

    }


    public void dataHandler(){
        String stName=name.getText().toString();
        String stLocation=location.getText().toString();
        String stCompany=company.getText().toString();
        String stAge=age.getText().toString();

        double dAge=Double.parseDouble(stAge);

        Work work=new Work();
        work.setName(stName);
        work.setLocation(stLocation);
        work.setCompany(stCompany);
        work.setAge(stAge);

    }
}
