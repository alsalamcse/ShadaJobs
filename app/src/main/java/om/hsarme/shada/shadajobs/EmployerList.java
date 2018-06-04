package om.hsarme.shada.shadajobs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import om.hsarme.shada.shadajobs.data.Work;
import om.hsarme.shada.shadajobs.data.WorkAdapter;

import static java.security.AccessController.getContext;
import static om.hsarme.shada.shadajobs.R.id.listView;

public class EmployerList extends AppCompatActivity {

    private ListView lstTvWork;
    private TextView tvName, tvLocation, tvCompany, tvAge, tvEmail, tvPhone;

    private WorkAdapter workAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        tvName=(TextView)findViewById(R.id.tvName);
//        tvLocation=(TextView)findViewById(R.id.tvLocation);
//        tvCompany=(TextView)findViewById(R.id.tvCompany);
//        tvAge=(TextView)findViewById(R.id.etAge);
//        tvEmail=(TextView)findViewById(R.id.etEmail);
//        tvPhone=(TextView)findViewById(R.id.tvPhone);
        lstTvWork = (ListView) findViewById(R.id.lstTvWork);


        //todo בניית מתאם לרשימה
        workAdapter = new WorkAdapter(getBaseContext(), R.layout.work_item);
        // todo קביעת המתאם לרשימה
        lstTvWork.setAdapter(workAdapter);

        readAndListen();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(getBaseContext(), AddWork.class);
                startActivity(i);
            }
        });
    }


    // read and listen data from firebase
    private void readAndListen() {
        //to get user email... user info
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        //building data reference = data path = data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הנתונים שלנו
        //todo  קישור הינו לשורש של המסד הנתונים
        reference = FirebaseDatabase.getInstance().getReference();
        //listening to data change
        reference.child("mylist").orderByChild("email").equalTo(email)
                // todo בפעם הראשונה שמופעל המאזין מקבלים העתק לכל הניתונים תחת כתובת זו
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)//todo העתק מהניתונים שהורדנו
                    {
                        // todo מחיקת כל הניתונים מהמתאם
                        workAdapter.clear();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Work work = ds.getValue(Work.class);
                            Log.d("SL", work.toString());
                            // todo הוספת עצם למתאם
                            workAdapter.add(work);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

    {
        @Override
        public void onItemClick (AdapterView < ? > adapterView, View view,int i, long l){

        final String[] a = {"SMS", "Call", "DELETE"};
        final Work w = (Work) adapterView.getItemAtPosition(i);


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("nnnn");
        builder.setCancelable(true);
        builder.setSingleChoiceItems(a, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), a[i], Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    //intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    intent.setData(Uri.parse("sms:" + w.getPhone()));
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + w.getPhone()));
                    startActivity(intent);
                }
                if (i == 2) {


                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }
    });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()

    {
        @Override
        public boolean onQueryTextSubmit (String s){
        readAndListen(s);
        return true;
    }

        @Override
        public boolean onQueryTextChange (String s){
        return false;
    }
    }
        return view;
};


    private void readAndListen(String s) {
        {
            //to get user email... user info
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            String email = user.getEmail();
            email = email.replace('.', '*');
            //building data reference = data path = data address
            DatabaseReference reference;
            //todo לקבלת קישור למסד הנתונים שלנו
            //todo  קישור הינו לשורש של המסד הנתונים
            reference = FirebaseDatabase.getInstance().getReference();
            // String txt=searchView.getQuery().toString();
            //listening to data change
            reference.child("mylist").orderByChild("location").equalTo(s)
                    // todo בפעם הראשונה שמופעל המאזין מקבלים העתק לכל הניתונים תחת כתובת זו
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot)//todo העתק מהניתונים שהורדנו
                        {
                            // todo מחיקת כל הניתונים מהמתאם
                            workAdapter.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Work work = ds.getValue(Work.class);
                                Log.d("SL", work.toString());
                                // todo הוספת עצם למתאם
                                workAdapter.add(work);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }


    }





}
