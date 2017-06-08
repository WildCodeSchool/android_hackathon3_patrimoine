package patrimoine.wcs.fr.toulousemonuments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import patrimoine.wcs.fr.toulousemonuments.models.Fields;
import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;


public class CommentFragment extends BaseFragment {


    public CommentFragment(int position, MonumentModel model) {
        super(position, model);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }
}
