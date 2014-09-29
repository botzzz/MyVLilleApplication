package com.vlille.buissartt.myvlilleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.vlille.buissartt.myvlilleapplication.beans.StationVLille;
import com.vlille.buissartt.myvlilleapplication.provider.StationVLilleListProvider;
import com.vlille.buissartt.myvlilleapplication.utils.StationVLilleAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class MyActivity extends Activity {

    // private ListViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ListView listView = (ListView) findViewById(R.id.stationsList);
        StationVLilleListProvider provider = new StationVLilleListProvider();
        List<StationVLille> stations = null;
        try {
            stations = provider.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("exception", e.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("exception", e.toString());
        }
        StationVLilleAdapter adapter = new StationVLilleAdapter(this, R.layout.station_adapter, stations);
        Log.i("first station", String.valueOf(stations.size()));
        Log.i("info", adapter.toString());
        System.out.println(listView);
        Log.i("info", listView.toString());
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
