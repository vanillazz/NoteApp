package com.ikuzo.project.ikuzonoteapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.ikuzo.project.ikuzonoteapp.R;

import static com.ikuzo.project.ikuzonoteapp.DatabaseContract.NoteColumns.DATE;
import static com.ikuzo.project.ikuzonoteapp.DatabaseContract.NoteColumns.DESCRIPTION;
import static com.ikuzo.project.ikuzonoteapp.DatabaseContract.NoteColumns.TITLE;
import static com.ikuzo.project.ikuzonoteapp.DatabaseContract.getColumnString;

/**
 * Created by Vanillazz on 18/02/2018.
 */

public class IkuzoNotesAdapter extends CursorAdapter {
    public IkuzoNotesAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_ikuzo_note, viewGroup, false);
    }

    @Override
    public Cursor getCursor() {
        return super.getCursor();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        if (cursor != null){
            TextView tvTitle = (TextView)view.findViewById(R.id.tv_item_title);
            TextView tvDate = (TextView)view.findViewById(R.id.tv_item_date);
            TextView tvDescription = (TextView)view.findViewById(R.id.tv_item_description);

            tvTitle.setText(getColumnString(cursor,TITLE));
            tvDescription.setText(getColumnString(cursor,DESCRIPTION));
            tvDate.setText(getColumnString(cursor,DATE));
        }
    }
}
