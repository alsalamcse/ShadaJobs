package om.hsarme.shada.shadajobs.MainListFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import om.hsarme.shada.shadajobs.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {
    private ImageView imageView;
    private EditText city;



    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_location, container, false);
        imageView=(ImageView)view.findViewById(R.id.imageView);
        city=(EditText)view.findViewById(R.id.city);


        return view;
    }

}
