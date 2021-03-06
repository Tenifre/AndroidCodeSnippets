package jp.tenifre.simplecustomlistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SampleListViewData> arrayList = new ArrayList<>();

        SampleListViewData sampleListViewData = new SampleListViewData();
        sampleListViewData.setTitle("タイトル");
        sampleListViewData.setDescription("説明文");

        arrayList.add(sampleListViewData);

        ListView listView = (ListView)findViewById(R.id.sampleListView);
        SampleListViewAdapter sampleListViewAdapter = new SampleListViewAdapter(this, 0, arrayList);
        listView.setAdapter(sampleListViewAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
