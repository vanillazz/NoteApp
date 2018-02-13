package com.ikuzo.project.mynotesapp;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Vanillazz on 08/02/2018.
 */

public class CustomOnItemClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }


    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);

    }

    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }
}
