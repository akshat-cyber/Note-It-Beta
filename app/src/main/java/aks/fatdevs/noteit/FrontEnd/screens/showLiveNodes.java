package aks.fatdevs.noteit.FrontEnd.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import aks.fatdevs.noteit.DataAndModels.Model;
import aks.fatdevs.noteit.FrontEnd.screens.Adaptor.dataBinderAdapterr;
import aks.fatdevs.noteit.R;
import aks.fatdevs.noteit.Repository.Repository;

public class showLiveNodes extends AppCompatActivity {
    private SearchView searchView;
    private RecyclerView recyclerView;
    public static dataBinderAdapterr adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Model> data = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_node_data);
        searchView = findViewById(R.id.searchView);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recycler);
        data = new Repository(this).getData();
        Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();
        adapter = new dataBinderAdapterr(data);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        if( data.size() == 0){
            startActivity(new Intent(getApplicationContext(), noNodeScreen.class));
        }
        floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), createNode.class));
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
