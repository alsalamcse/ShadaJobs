package om.hsarme.shada.shadajobs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private EditText etName,etAge,etPhone;
    private TextView tvName,tvAge,tvPhone;
    private Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName=(EditText)findViewById(R.id.etName);
        etAge=(EditText)findViewById(R.id.etAge);
        etPhone=(EditText)findViewById(R.id.etPhone);
        tvName=(TextView)findViewById(R.id.tvName);
        tvAge=(TextView)findViewById(R.id.tvAge);
        tvPhone=(TextView)findViewById(R.id.tvPhone);
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(this);
    }

    public void dataHandler(){
        String name=etName.getText().toString();
        String age=etAge.getText().toString();
        String phone=etPhone.getText().toString();
    }



    @Override
    public void onClick(View view) {
        if (view==send)
            dataHandler();
    }
}
