package om.hsarme.shada.shadajobs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener
{
    private Button worker,employer;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        worker=(Button)findViewById(R.id.worker);
        employer=(Button)findViewById(R.id.employer);
        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();
    }

    @Override
    public void onClick(View view)
    {
      if (worker==view){
         signIn("work@work.wrk","work12345");
      }
      if (employer==view){
          Intent i=new Intent(getBaseContext(),LogInEmployer.class);
          startActivity(i);
      }
    }
    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogIn.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LogIn.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}
