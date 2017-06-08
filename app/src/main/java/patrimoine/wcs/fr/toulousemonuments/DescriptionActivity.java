package patrimoine.wcs.fr.toulousemonuments;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.octo.android.robospice.GsonGoogleHttpClientSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.ArrayList;

import patrimoine.wcs.fr.toulousemonuments.models.Fields;
import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;
import patrimoine.wcs.fr.toulousemonuments.models.Record;

public class DescriptionActivity extends AppCompatActivity implements DesciptionFragment.OnFragmentInteractionListener {

    private TextView mTextViewTitle;
    private ImageView mImageViewDescriptionMain;
    private TextView mTextViewDescription;
    private TextView mTextviewScore;
    private ImageView mImageViewEtoile;
    private ImageView mImageViewEtoileScore;

    private SpiceManager mSpiceManager;
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mTextViewTitle = (TextView) findViewById(R.id.textViewLieu);
        mTextViewDescription = (TextView) findViewById(R.id.textViewDescription);
        mTextviewScore = (TextView) findViewById(R.id.textViewScore);
        mImageViewDescriptionMain = (ImageView) findViewById(R.id.imageViewDescriptionMain);
        mImageViewEtoile = (ImageView) findViewById(R.id.imageViewMonEtoile);
        mImageViewEtoileScore = (ImageView) findViewById(R.id.imageViewRating);

        mSpiceManager = new SpiceManager(GsonGoogleHttpClientSpiceService.class);


        Intent intentFromMainActivity = getIntent();
        mPosition = intentFromMainActivity.getIntExtra(MainActivity.POSITION, -1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSpiceManager.start(this);
        performRequest();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSpiceManager.shouldStop();
    }

    private void performRequest() {

        MonumentRequest monumentRequest = new MonumentRequest();
        mSpiceManager.execute(monumentRequest,MainActivity.CACHE, DurationInMillis.ONE_WEEK, new DescriptionActivity.MonumentRequestListener());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class MonumentRequestListener implements RequestListener<MonumentModel> {


        @Override
        public void onRequestFailure(SpiceException spiceException) {

        }

        @Override
        public void onRequestSuccess(MonumentModel monumentModel) {
            Fields currentFields = monumentModel.getRecords().get(mPosition).getFields();
            DesciptionFragment desciptionFragment = new DesciptionFragment();
            getFragmentManager().beginTransaction().add(R.id.framLayoutDescription, desciptionFragment).commit();
            /*mTextViewTitle.setText(currentFields.getNom());
            mTextViewDescription.setText(currentFields.getDescriptif());
            Glide.with(DescriptionActivity.this).load(R.drawable.button_googlemap).into(mImageViewDescriptionMain);*/
        }
    }
}



