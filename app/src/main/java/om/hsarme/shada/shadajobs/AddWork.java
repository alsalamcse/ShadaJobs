package om.hsarme.shada.shadajobs;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddWork extends AppCompatActivity {
    private EditText work1, location, company, age;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        work1=(EditText)findViewById(R.id.work1);
        location=(EditText)findViewById(R.id.work);
        company=(EditText)findViewById(R.id.company);
        age=(EditText)findViewById(R.id.company);
        add=(Button)findViewById(R.id.add);

    }


    public void dataHandler(){
        String stWork=work.getText().toString();
        String stLocation=location.getText().toString();
        String stCompany=company.getText().toString();
        String stAge=age.getText().toString();

        double dAge=Double.parseDouble(stAge);

        Work w=new Work

    }
}
