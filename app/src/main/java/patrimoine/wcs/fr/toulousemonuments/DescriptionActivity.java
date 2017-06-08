package patrimoine.wcs.fr.toulousemonuments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intentFromMainActivity = getIntent();
        intentFromMainActivity.getIntExtra(MainActivity.POSITION, -1);
    }
}
