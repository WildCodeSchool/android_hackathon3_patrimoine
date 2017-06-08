package patrimoine.wcs.fr.toulousemonuments;

import android.app.Fragment;

import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;

/**
 * Created by apprenti on 08/06/17.
 */

public abstract class BaseFragment extends Fragment {

    private MonumentModel mMonument;
    private int mPosition;


    public void setmMonument(MonumentModel mMonument) {
        this.mMonument = mMonument;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }
}
