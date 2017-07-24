package com.bookaholicc.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bookaholicc.CustomUI.HelviticaLight;
import com.bookaholicc.Model.PriceInfo;
import com.bookaholicc.R;

import java.util.List;

/**
 * Created by nandhu on 24/7/17.
 *
 */

public class DurationSpinner  extends ArrayAdapter<PriceInfo> {

    private final String TAG = "CART_ADAPTER";
    private Context mContext = null;

    private List<PriceInfo> mList ;

    public DurationSpinner(Context context, int resource, List<PriceInfo> objects) {
        super(context, resource, objects);
        this.mContext  = context;
        this.mList = objects;
        Log.d(TAG, "DurationSpinner: ");
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.simple_spinner,parent,false);
        }
        PriceInfo current = mList.get(position);
        if (current != null){
//            HelviticaLight mStandarNAme = (HelviticaLight) row.findViewById(R.id.class_name_spinner);
//            if (mStandarNAme != null){
//                mStandarNAme.setText(current.getName());
//
//            }
        }

        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.simple_spinner, parent, false);

            return row;
        } return row;
    }
//        StandardModel current = mList.get(position);
//        if (current != null){
//            HelviticaLight mStandarNAme = (HelviticaLight) row.findViewById(R.id.class_name_spinner);
//            if (mStandarNAme != null){
//                mStandarNAme.setText(current.getName());

//            }
//        }


//    }
}
