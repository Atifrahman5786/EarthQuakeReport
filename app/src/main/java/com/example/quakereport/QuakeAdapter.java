package com.example.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<EarthQuake> {


    public QuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuake){
        super(context, 0, earthQuake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_layout, parent, false
            );
        }
        final EarthQuake currentQuake = getItem(position);

        DecimalFormat magFormat = new DecimalFormat("0.0");
        TextView txtMagnitude = listItemView.findViewById(R.id.txtMagnitude);
        Double magnitude = currentQuake.getMagnitude();
        txtMagnitude.setText(String.valueOf(magFormat.format(magnitude)));

        String location = currentQuake.getLocation();
        String locationOffset, primaryLocation;
        if(location.contains("of")){
            String[] parts = location.split("of");
            locationOffset = parts[0] + "of";
            primaryLocation = parts[1];

        }
        else{
            locationOffset = "Near the";
            primaryLocation = location;
        }

        TextView txtLocOffset = listItemView.findViewById(R.id.txtLocOffset);
        txtLocOffset.setText(locationOffset);

        TextView txtPrimaryLocation = listItemView.findViewById(R.id.txtPrimaryLocation);
        txtPrimaryLocation.setText(primaryLocation);

        TextView txtDate = listItemView.findViewById(R.id.txtDate);
        Long timeinMilliseconds =  currentQuake.getDate();
        Date dateObject = new Date(timeinMilliseconds);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, d MMM yyyy");
        String dateTodisplay = dateFormatter.format(dateObject);
        txtDate.setText(dateTodisplay);

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormat.format(dateObject);
        TextView txtTime = listItemView.findViewById(R.id.txtTime);
        txtTime.setText(timeToDisplay);

        GradientDrawable magnitudeCircle = (GradientDrawable) txtMagnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
        }

    }

