package com.incidences.incidencesapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IMainInterface;
import com.incidences.incidencesapp.models.IncidencesEntity;
import com.incidences.incidencesapp.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IMainInterface.View {
    private IMainInterface.Presenter mainPresenter;
    private final String TAG = "MainActivity";
    private IncidencesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = findViewById(R.id.maintoolbar);
        setSupportActionBar(t);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.list_incidences);
        mainPresenter = new MainPresenter(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> mainPresenter.onClickFloatingButton());
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<IncidencesEntity> items = new ArrayList<>();

        adapter = new IncidencesAdapter(items, getApplicationContext());
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "recyclerview item clicked");
                int position = recyclerView.getChildAdapterPosition(v);
                mainPresenter.onClickItem(adapter.getItem(position).getId());
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                        mainPresenter.onSwipe(position);
                        break;
                }

            }

        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                mainPresenter.onClickAbout();
                break;
            case R.id.search:
                mainPresenter.onClickSearch();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Button back pressed");
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "Inside onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Inside onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Inside onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Inside onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Inside OnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Inside OnStart");
        super.onStart();
    }

    @Override
    public void startFormActivity() {
        Log.d(TAG, "Inside startFormActivity to launch FormActivity");
        Intent i = new Intent(getApplicationContext(), FormActivity.class);
        startActivity(i);
    }

    @Override
    public void startAboutActivity() {
        Log.d(TAG, "Inside startAboutActivity to launch AboutActivity");
        Intent i = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(i);
    }

    @Override
    public void startSearchActivity() {
        Log.d(TAG, "Inside startSearchActivity to launch SearchActivity");
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(i);

    }

    @Override
    public void onItemClicked(String id) {
        Intent i = new Intent(MainActivity.this, FormActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    @Override
    public void swiped(int position) {
        if (adapter.removeItem(position)) {
            Toast.makeText(getApplicationContext(), R.string.remove_succesfully, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.cant_remove, Toast.LENGTH_SHORT).show();
        }
    }

}