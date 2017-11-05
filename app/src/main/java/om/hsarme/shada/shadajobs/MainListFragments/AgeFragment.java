package om.hsarme.shada.shadajobs.MainListFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import om.hsarme.shada.shadajobs.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgeFragment extends Fragment {
    private ListView age1;
    private EditText age2;


    public AgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_age, container, false);
        age1=(ListView)view.findViewById(R.id.age1);
        age2=(EditText)view.findViewById(R.id.age2);




        return view;
    }

}
