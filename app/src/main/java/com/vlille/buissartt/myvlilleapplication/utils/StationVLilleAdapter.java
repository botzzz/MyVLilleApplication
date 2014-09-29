package com.vlille.buissartt.myvlilleapplication.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vlille.buissartt.myvlilleapplication.R;
import com.vlille.buissartt.myvlilleapplication.beans.StationVLille;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buissartt on 29/09/2014.
 */
public class StationVLilleAdapter extends ArrayAdapter<StationVLille> {
    public StationVLilleAdapter(Context context, int resource, List<StationVLille> stations) {
        super(context, resource , stations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        StationVLille station = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.station_adapter, null);
        }
        // Lookup view for data population
        TextView stationName = (TextView) convertView.findViewById(R.id.nom);
        TextView stationLon = (TextView) convertView.findViewById(R.id.lon);
        TextView stationLat = (TextView) convertView.findViewById(R.id.lat);
        TextView stationAdress = (TextView) convertView.findViewById(R.id.adress);
        TextView stationBikesLeft = (TextView) convertView.findViewById(R.id.bikesLeft);
        TextView stationAttachs = (TextView) convertView.findViewById(R.id.attachs);


        // Populate the data into the template view using the data object
        stationName.setText(station.getName());
        stationLat.setText(String.valueOf(station.getLat()));
        stationLon.setText(String.valueOf(station.getLon()));
        stationAdress.setText(String.valueOf(station.getAdress()));
        stationBikesLeft.setText(String.valueOf(station.getBikesLeft()));
        stationAttachs.setText(String.valueOf(station.getAttachs()));
        // Return the completed view to render on screen
        return convertView;
    }

}
