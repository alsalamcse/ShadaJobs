package om.hsarme.shada.shadajobs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpEmployer extends AppCompatActivity implements View.OnClickListener {
    private EditText etName, etEmail2, etPass2;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_employer);
        etName = (EditText) findViewById(R.id.etName);
        etEmail2 = (EditText) findViewById(R.id.etEmail2);
        etPass2 = (EditText) findViewById(R.id.etPass2);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
    }

    private void dataHandler() {
        String email = etEmail2.getText().toString();
        String stName = etName.getText().toString();
        String passw = etPass2.getText().toString();
        boolean isOk = true;//to check id all feilds are filled correct!!!!
        if (email.length() == 0 || email.indexOf('@') < 1) {
            etEmail2.setError("Wrong Email");
            isOk = false;
        }
        if (isOk) {
            creatAcount(email, passw);
        }
    }

    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUpEmployer.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpEmployer.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), EmployerList.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpEmployer.this, "Authentication Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
        FirebaseAuth.getInstance().signOut();
    }


    @Override
    public void onClick(View view) {
        if (view == btnSave) {
            dataHandler();
            Intent i1= new Intent(getBaseContext(), EmployerList.class);
            startActivity(i1);
        }
    }
}
