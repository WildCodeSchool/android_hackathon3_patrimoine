package patrimoine.wcs.fr.toulousemonuments;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import patrimoine.wcs.fr.toulousemonuments.models.Fields;
import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;


public class DescriptionFragment extends BaseFragment {

    private DatabaseReference mDatabaseReference;
    private int mScore;


    public DescriptionFragment(int position, MonumentModel model) {
        super(position, model);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container == null){
            return null;
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desciption, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Fields currentFields = mMonumentModel.getRecords().get(mPosition).getFields();
        TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(telephonyManager.getDeviceId());
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mScore = (int) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.textViewTitle);
        ImageView imageViewDescriptionMain = (ImageView) getActivity().findViewById(R.id.imageViewDescriptionMain);
        TextView textViewDescription = (TextView) getActivity().findViewById(R.id.textViewDescription);
        ImageButton imageButton = (ImageButton) getActivity().findViewById(R.id.imageButtonRating);

        textViewTitle.setText(currentFields.getNom());
        textViewDescription.setText(currentFields.getDescriptif());

        AssetManager assetManager = getActivity().getAssets();
        try {
            Glide.with(getContext())
                    .load(assetManager.open(currentFields.getNomCdt()))
                    .into(imageViewDescriptionMain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
