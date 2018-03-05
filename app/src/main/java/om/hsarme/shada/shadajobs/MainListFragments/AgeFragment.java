package om.hsarme.shada.shadajobs.MainListFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import om.hsarme.shada.shadajobs.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgeFragment extends Fragment{
        //implements  View.OnClickListener{
    private TextView age1;
    private EditText age;
    private Button save;

    public AgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_age, container, false);
        age1=(TextView)view.findViewById(R.id.age1);
        age = (EditText) view.findViewById(R.id.age);
        save=(Button)view.findViewById(R.id.save);
        //save.setOnClickListener(this);

        return view;
    }

   // @Override
    //public void onClick(View view) {
     //   if (view==save)
     //       Intent i =new Intent(getContext(),)
    //}
}
