package patrimoine.wcs.fr.toulousemonuments;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.octo.android.robospice.GsonGoogleHttpClientSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.ArrayList;

import patrimoine.wcs.fr.toulousemonuments.models.MonumentModel;
import patrimoine.wcs.fr.toulousemonuments.models.Record;

public class MainActivity extends AppCompatActivity {

    private SpiceManager mSpiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpiceManager = new SpiceManager(GsonGoogleHttpClientSpiceService.class);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mSpiceManager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSpiceManager.shouldStop();
    }

    private void performRequest(String user) {

        MonumentRequest monumentRequest = new MonumentRequest();
        mSpiceManager.execute(monumentRequest, new MonumentRequestListener());
    }

    private class MonumentRequestListener implements RequestListener<MonumentModel> {

        @Override
        public void onRequestFailure(SpiceException e) {
            //update your UI
            //Log.d(TAG, e.getMessage());
        }

        @Override
        public void onRequestSuccess(MonumentModel monumentModel) {

            /*ArrayList<Record> results = new ArrayList<>(monumentModel.getRecords());
            mWeatherAdapter = new WeatherAdapter(MainActivity.this, results);
            mListViewWeather.setAdapter(mWeatherAdapter);
            Log.d(TAG, forecastWeatherModel.getCity().getName());*/

        }
    }
}
