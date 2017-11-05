package om.hsarme.shada.shadajobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity implements View.OnClickListener
{
    private Button worker,employer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        worker=(Button)findViewById(R.id.worker);
        employer=(Button)findViewById(R.id.employer);
    }

    @Override
    public void onClick(View view)
    {
      if (worker==view){
          Intent i=new Intent(getBaseContext(),MainListActivity.class);
          startActivity(i);
      }
      if (employer==view){
          Intent i=new Intent(getBaseContext(),EmployerList.class);
          startActivity(i);
      }
    }
}
