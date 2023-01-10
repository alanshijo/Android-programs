package my.android.griditems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridActivity extends BaseAdapter {
    private Context mContext;
    private final String[] appname;
    private final int[] applogo;
    public GridActivity(Context context, String[] appname, int[] applogo) {
        mContext = context;
        this.appname = appname;
        this.applogo = applogo;
    }
    @Override
    public int getCount() {
        return appname.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.row_data, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.text_view);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.image_view);
            textViewAndroid.setText(appname[i]);
            imageViewAndroid.setImageResource(applogo[i]);
        } else {
            gridViewAndroid = (View) view;
        }

        return gridViewAndroid;
    }
}
