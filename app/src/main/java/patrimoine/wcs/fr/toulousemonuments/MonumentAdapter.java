package patrimoine.wcs.fr.toulousemonuments;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import patrimoine.wcs.fr.toulousemonuments.models.Record;

/**
 * Created by apprenti on 11/05/17.
 */

public class MonumentAdapter extends BaseAdapter {

    public static final double TOKMPERHOUR = 3.6;
    public static final double KELVIN = 273.15;
    private Context context; //context
    private ArrayList<Record> items; //data source of the list adapter

    //public constructor
    public MonumentAdapter(Context context, ArrayList<Record> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.record_item, parent, false);
        }

        // get current item to be displayed
        Record currentRecordItem = (Record) getItem(position);

        // get the TextView for item name and item description
        TextView textViewForecastHour = (TextView)
                convertView.findViewById(R.id.textViewListRecord);
        ImageView imageViewListRecord = (ImageView) convertView.findViewById(R.id.imageViewListRecord);

        //sets the text for item name and item description from the current item object

        textViewForecastHour.setText(currentRecordItem.getFields().getNom());

        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(currentRecordItem.getFields().getNomCdt() + ".jpg", AssetManager.ACCESS_BUFFER);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageViewListRecord.setImageBitmap(bitmap);
            /*Glide.with(getContext())
                    .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                    .asBitmap()
                    .load(bitmap)
                    .into(imageViewDescriptionMain);*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        // returns the view for the current row
        return convertView;
    }


}
