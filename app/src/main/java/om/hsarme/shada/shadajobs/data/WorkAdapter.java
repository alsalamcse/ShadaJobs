package om.hsarme.shada.shadajobs.data;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by user on 05/03/2018.
 */

public class WorkAdapter extends ArrayAdapter<Work>{

    public WorkAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


}
