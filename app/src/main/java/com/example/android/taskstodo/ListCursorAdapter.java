package com.example.android.taskstodo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.taskstodo.data.TaskContract;

public class ListCursorAdapter extends CursorAdapter {

    public ListCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView taskTextView = (TextView) view.findViewById(R.id.task);

        int taskColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TASK);

        String task = cursor.getString(taskColumnIndex);

        taskTextView.setText(task);
    }
}
