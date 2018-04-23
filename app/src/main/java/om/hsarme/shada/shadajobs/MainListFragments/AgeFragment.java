package om.hsarme.shada.shadajobs.MainListFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import om.hsarme.shada.shadajobs.R;
import om.hsarme.shada.shadajobs.data.Work;
import om.hsarme.shada.shadajobs.data.WorkAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgeFragment extends Fragment{
        //implements  View.OnClickListener{
    private SearchView searchView;
    private EditText age;
    private WorkAdapter workAdapter;

    public AgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_age, container, false);
        searchView=(SearchView) view.findViewById(R.id.searchView);
        age = (EditText) view.findViewById(R.id.age);

        return view;
    }
    private void readAndListen() {
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
            //listening to data change
            reference.child(email).child("mylist").orderByChild("location").startAt(Integer.parseInt(age.getText().toString())
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
