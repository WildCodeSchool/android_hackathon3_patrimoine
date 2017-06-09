package patrimoine.wcs.fr.toulousemonuments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {

    ImageView imageViewTitreLogo;
    TextView textViewDescription;
    ImageView imageViewValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        imageViewTitreLogo = (ImageView) findViewById(R.id.imageViewTitreLogo);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        imageViewValidation = (ImageView) findViewById(R.id.imageViewValidation);

        imageViewValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Introduction.this,MainActivity.class);
                Introduction.this.startActivity(mainIntent);
                Introduction.this.finish();
            }
        });


    }


}
