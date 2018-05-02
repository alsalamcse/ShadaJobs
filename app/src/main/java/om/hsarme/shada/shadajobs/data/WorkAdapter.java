package om.hsarme.shada.shadajobs.data;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import om.hsarme.shada.shadajobs.R;

/**
 * Created by user on 05/03/2018.
 */

public class WorkAdapter extends ArrayAdapter<Work> {

    public WorkAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    /**
     * todo מספר סידורי של הנתון (עצם) ממקור הנתונים
     *
     * @param position    the index of one data item from the data source . statrting from zero
     * @param convertView todo הממשק שיכטל להציג אוסף נתונים לדוגמה LISTVIEW
     * @param parent      listView
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //
        View view=LayoutInflater.from(getContext()).inflate(R.layout.work_item,parent,false);



        TextView itmJob = (TextView) view.findViewById(R.id.itmJob);
        TextView itmLocation = (TextView) view.findViewById(R.id.itmLocation);
        TextView itmCompany = (TextView) view.findViewById(R.id.itmCompany);
        TextView itmAge = (TextView) view.findViewById(R.id.itmAge);
        TextView itmEmail = (TextView) view.findViewById(R.id.itmEmail);
        TextView itmPhone = (TextView) view.findViewById(R.id.itmPhone);


        Work work = getItem(position);
        itmJob.setText(work.getJob());
        itmLocation.setText(work.getLocation() + "");
        itmCompany.setText(work.getCompany() + "");
        itmAge.setText(work.getAge() +"");
        itmEmail.setText(work.getEmail()+"");
        itmPhone.setText(work.getPhone());



        return view;

    }
}