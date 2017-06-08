package patrimoine.wcs.fr.toulousemonuments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MonumentListActivity extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    ListView listViewToulouse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_list);
        listViewToulouse= (ListView)findViewById(R.id.listViewToulouse);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
