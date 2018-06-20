package com.example.android.taskstodo;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.taskstodo.data.TaskContract;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int TASK_LOADER=0;
    ListCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fab = (Button)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        ListView taskListView = (ListView) findViewById(R.id.list);

        View emptyView = findViewById(R.id.empty_view);
        taskListView.setEmptyView(emptyView);
        mCursorAdapter=new ListCursorAdapter(this,null);
        taskListView.setAdapter(mCursorAdapter);
        getLoaderManager().initLoader(TASK_LOADER,null,this);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                Uri currentPetUri = ContentUris.withAppendedId(TaskContract.TaskEntry.CONTENT_URI, id);
                intent.setData(currentPetUri);
                startActivity(intent);

            }
        });

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        //Define a projection of columns we care abt
        String[] projection={TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COLUMN_TASK};

        return new CursorLoader(this, TaskContract.TaskEntry.CONTENT_URI,projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
