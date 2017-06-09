package patrimoine.wcs.fr.toulousemonuments;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;

import patrimoine.wcs.fr.toulousemonuments.models.Fields;
import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;


public class DescriptionFragment extends BaseFragment {

    private DatabaseReference mDatabaseReference;

    TextView textViewTitle;
    ImageView imageViewDescriptionMain;
    TextView textViewDescription;
    TextView textViewScore;
    ImageButton mImageButtonRating;


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

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(currentFields.getNomCdt()).child(getContext().getString(R.string.score));
        textViewTitle = (TextView) getActivity().findViewById(R.id.textViewTitle);
        imageViewDescriptionMain = (ImageView) getActivity().findViewById(R.id.imageViewDescriptionMain);
        textViewDescription = (TextView) getActivity().findViewById(R.id.textViewDescription);
        textViewScore = (TextView) getActivity().findViewById(R.id.textViewScore);
        mImageButtonRating = (ImageButton) getActivity().findViewById(R.id.imageButtonRating);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Integer.class) != null) {
                    textViewScore.setText(String.valueOf(dataSnapshot.getValue(Integer.class)));
                }
                else{
                    textViewScore.setText(String.valueOf(0));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mImageButtonRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference.runTransaction(new Transaction.Handler() {
                    @Override
                    public Transaction.Result doTransaction(MutableData mutableData) {
                        if (mutableData.getValue() == null){
                            mutableData.setValue(1);
                            return Transaction.success(mutableData);
                        }
                        int value = mutableData.getValue(Integer.class);
                        mutableData.setValue(value + 1);
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {

                    }
                });
            }
        });

        textViewTitle.setText(currentFields.getNom());
        textViewDescription.setText(currentFields.getDescriptif());


        try {
            AssetManager assetManager = getActivity().getAssets();
            InputStream inputStream = assetManager.open(currentFields.getNomCdt() + ".jpg", AssetManager.ACCESS_BUFFER);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageViewDescriptionMain.setImageBitmap(bitmap);
            /*Glide.with(getContext())
                    .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                    .asBitmap()
                    .load(bitmap)
                    .into(imageViewDescriptionMain);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
