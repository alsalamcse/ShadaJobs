package om.hsarme.shada.shadajobs.MainListFragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.AbstractQueue;

import om.hsarme.shada.shadajobs.R;
import om.hsarme.shada.shadajobs.data.Work;
import om.hsarme.shada.shadajobs.data.WorkAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {
    private SearchView searchView;
    private WorkAdapter workAdapter;
    private ListView listView;


    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        searchView=(SearchView) view.findViewById(R.id.searchView);
        listView=(ListView)view.findViewById(R.id.listView);
        workAdapter=new WorkAdapter(getContext(),R.layout.work_item);
        listView.setAdapter(workAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String[] a={"SMS","Call"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("nnnn");
                    builder.setCancelable(true);
                builder.setSingleChoiceItems(a, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), a[i], Toast.LENGTH_SHORT).show();
                    }
                });
                    AlertDialog dialog=builder.create();
                    dialog.show();


            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                readAndListen(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return view;
    }


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

};


