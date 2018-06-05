package om.hsarme.shada.shadajobs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class UpdateWork extends AppCompatActivity  {
    private EditText etJob, etLocation, etCompany, etAge, etPhone, etEmail;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        etJob=(EditText)findViewById(R.id.etJob);
        etLocation=(EditText)findViewById(R.id.etLocation);
        etCompany=(EditText)findViewById(R.id.etCompany);
        etAge=(EditText)findViewById(R.id.etAge);
        etPhone=(EditText)findViewById(R.id.etPhone);
        add=(Button)findViewById(R.id.add);
        // este5raj intent elle wesel mn lshashe elle abel"employeerList"
        Intent i =getIntent();
        final Work w = (Work) i.getExtras().get("work");
        etJob.setText(w.getJob());
        etLocation.setText(w.getLocation());
        etCompany.setText(w.getCompany());
        etAge.setText(w.getAge()+"");
        etPhone.setText(w.getPhone()+"");

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dataHandler(w.getKeyId());
                Intent i1= new Intent(getBaseContext(), EmployerList.class);
                startActivity(i1);
            }
        });

    }
    //get data from the feilds
    public void dataHandler(String KeyId) {
        String stJob = etJob.getText().toString();
        String stLocation = etLocation.getText().toString();
        String stCompany = etCompany.getText().toString();
        String stAge = etAge.getText().toString();
        String stPhone= etPhone.getText().toString();



        //building data object
       Work work= new Work();
        work.setKeyId(KeyId);
        work.setJob(stJob);
        work.setLocation(stLocation);
        work.setCompany(stCompany);
        work.setAge(Integer.parseInt(stAge));

        // to get user email... user info
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');

        work.setEmail(email);




        // building data reference = data path = data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הנתונים שלנו
        //todo  קישור הינו לשורש של המסד הנתונים

        reference= FirebaseDatabase.getInstance().getReference();
        // saving data on the firebase database

        reference.child("mylist").child(KeyId).setValue(work)
                // add completeListener
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(UpdateWork.this, "Add Work Successful", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(UpdateWork.this, "Add Work failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
    }

}
