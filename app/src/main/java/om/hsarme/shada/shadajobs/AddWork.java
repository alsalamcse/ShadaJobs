package om.hsarme.shada.shadajobs;

import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import om.hsarme.shada.shadajobs.data.Work;

public class AddWork extends AppCompatActivity  {
    private EditText etName, etLocation, etCompany, etAge, etPhone, etEmail;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        etName=(EditText)findViewById(R.id.etName);
        etLocation=(EditText)findViewById(R.id.etLocation);
        etCompany=(EditText)findViewById(R.id.etCompany);
        etAge=(EditText)findViewById(R.id.etAge);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etEmail=(EditText)findViewById(R.id.etEmail);
        add=(Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });

    }
    //get data from the feilds
    public void dataHandler() {
        String stName = etName.getText().toString();
        String stLocation = etLocation.getText().toString();
        String stCompany = etCompany.getText().toString();
        String stAge = etAge.getText().toString();
        String stPhone= etPhone.getText().toString();
        String stEmail= etEmail.getText().toString();

        //data manipulation
        double age = Double.parseDouble(stAge);
        double phone= Double.parseDouble(stPhone);

        //building data object
        Work work = new Work();
        work.setName(stName);
        work.setLocation(stLocation);
        work.setCompany(stCompany);
        work.setAge(stAge);

        // to get user email... user info
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');





        // building data reference = data path = data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הנתונים שלנו
        //todo  קישור הינו לשורש של המסד הנתונים

        reference= FirebaseDatabase.getInstance().getReference();
        // saving data on the firebase database
        reference.child("mylist").push().setValue(work)
                // add completeListener
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(AddWork.this, "Add Work Successful", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(AddWork.this, "Add Work failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
    }

}
