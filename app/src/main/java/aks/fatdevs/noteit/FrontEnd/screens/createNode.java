package aks.fatdevs.noteit.FrontEnd.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Calendar;
import aks.fatdevs.noteit.FrontEnd.screens.animations.floatingActionAnimation;
import aks.fatdevs.noteit.R;
import aks.fatdevs.noteit.Repository.Repository;

public class createNode extends AppCompatActivity {
    private FloatingActionButton dropDownOne;
    private FloatingActionButton camerFab;
    private FloatingActionButton galleryFab;
    private FloatingActionButton alarmFab;
    private FloatingActionButton saveButton;
    private EditText NodeTitle;
    private EditText NodeBody;
    private String imageUri;
    private String CurrentTime;
    private int img_req_code_camera = 101;
    private int img_req_code = 12;
    private boolean isRotate = false;
    private StringBuffer ParaBuffer = new StringBuffer();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_node_main);
        init();
        FloatingButtonAnimation();
        saveButton.setOnClickListener(v -> {
            clicked(1);
            startActivity(new Intent(getApplicationContext(), showLiveNodes.class));
        });
        camerFab.setOnClickListener(v -> startCameraAndReturnAImage());
        galleryFab.setOnClickListener(v -> openGalleryAndSelectAnImage());
        alarmFab.setOnClickListener(v -> setAlarmClockForTodo());
    }
    private void setAlarmClockForTodo() {

    }
    private void openGalleryAndSelectAnImage() {

    }
    private void startCameraAndReturnAImage() {

    }
    private void clicked(int i) {
        String title = NodeTitle.getText().toString();
        ParaBuffer.append(NodeBody.getText().toString());
        if(i == 1){
            if( title == null ){
                Toast.makeText(this, "Title Not Valid", Toast.LENGTH_SHORT).show();
                return;
            }
        }Repository.importData(title, ParaBuffer, Calendar.getInstance().getTime().toString(), imageUri);
        showLiveNodes.adapter.notifyDataSetChanged();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        clicked(0);
        startActivity(new Intent(getApplicationContext(), showLiveNodes.class));
    }
    private void init() {
        dropDownOne= findViewById(R.id.floatingActionButton4);
        camerFab= findViewById(R.id.camerFab);
        galleryFab= findViewById(R.id.galleryFab);
        alarmFab= findViewById(R.id.alarmFab);
        NodeTitle = findViewById(R.id.title_node);
        NodeBody = findViewById(R.id.paragraph);
        saveButton = findViewById(R.id.saveButton);
    }
    private void FloatingButtonAnimation() {
        floatingActionAnimation.init(galleryFab);
        floatingActionAnimation.init(camerFab);
        floatingActionAnimation.init(alarmFab);
        dropDownOne.setOnClickListener(v -> {
            isRotate = floatingActionAnimation.rotateFloatingAction(v, !isRotate);
            if(isRotate){
                floatingActionAnimation.showIn(camerFab);
                floatingActionAnimation.showIn(galleryFab);
                floatingActionAnimation.showIn(alarmFab);

            }else{
                floatingActionAnimation.showOut(camerFab);
                floatingActionAnimation.showOut(galleryFab);
                floatingActionAnimation.showOut(alarmFab);
            }
        });
    }
}