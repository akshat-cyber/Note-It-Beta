package aks.fatdevs.noteit.FrontEnd.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import aks.fatdevs.noteit.R;

public class noNodeScreen extends AppCompatActivity {
private FloatingActionButton imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_node_create);
        imageView = findViewById(R.id.floatingActionButton2);
        imageView.setOnClickListener(v -> startActivity(new Intent(this, createNode.class)));

    }
}
