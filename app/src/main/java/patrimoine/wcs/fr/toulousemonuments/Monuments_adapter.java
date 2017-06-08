package patrimoine.wcs.fr.toulousemonuments;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.Query;

/**
 * Created by apprenti on 08/06/17.
 */

public class Monuments_adapter extends Firebaseadapter <MonumentModel>{

    ImageView monuments;


    public Monuments_adapter(Query ref, Activity activity, int layout) {
        super(ref, MonumentModel.class, layout, activity);

    }


}
