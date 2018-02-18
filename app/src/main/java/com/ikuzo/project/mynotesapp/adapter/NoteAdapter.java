package com.ikuzo.project.mynotesapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.ikuzo.project.mynotesapp.CustomOnItemClickListener;
import com.ikuzo.project.mynotesapp.FormAddUpdateActivity;
import com.ikuzo.project.mynotesapp.R;
import com.ikuzo.project.mynotesapp.entity.Note;

import java.util.LinkedList;

import static com.ikuzo.project.mynotesapp.db.DatabaseContract.CONTENT_URI;

/**
 * Created by Vanillazz on 08/02/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewholder> {
    private Cursor listNotes;
    private Activity activity;

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

//    public LinkedList<Note> getListNotes() {
//        return listNotes;
//    }

    public void setListNotes(Cursor listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public NoteViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewholder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewholder holder, int position) {
        final Note note = getItem(position);


        holder.tvTitle.setText(note.getTitle());
        holder.tvDate.setText(note.getDate());
        holder.tvDescription.setText(note.getDescription());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {

                Intent intent = new Intent(activity, FormAddUpdateActivity.class);
                Uri uri = Uri.parse(CONTENT_URI + "/" + note.getId());
                intent.setData(uri);
                activity.startActivityForResult(intent, FormAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {

        if (listNotes == null) return 0;
        return listNotes.getCount();
    }

    private Note getItem(int position) {
        if (!listNotes.moveToPosition(position)) {
            throw new IllegalStateException("Position invalid");
        }
        return new Note(listNotes);
    }

    public class NoteViewholder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvDate;
        CardView cvNote;

        public NoteViewholder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_item_description);
            tvDate = (TextView) itemView.findViewById(R.id.tv_item_date);
            cvNote = (CardView) itemView.findViewById(R.id.cv_item_note);
        }
    }
}