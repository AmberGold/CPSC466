package edu.fullerton.ecs.cpsc466;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.UiSettings;



public class PlanEvent extends AppCompatActivity implements OnClickListener, TextView.OnEditorActionListener, OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;

    EditText titleEditText;

    Button saveButton;
    Button deleteButton;
    Button backButton;

    private static final String MAP_VIEW_BUNDLE_KEY = "@string/google_android_map_api_key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_event);

        titleEditText = (EditText) findViewById(R.id.title);

        saveButton = (Button) findViewById(R.id.saveButton);
        backButton = (Button) findViewById(R.id.backButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        titleEditText.setOnEditorActionListener(this);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        googleMap.setMinZoomPreference(12);
        googleMap.setIndoorEnabled(true);
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);

        MarkerOptions markerOptions = new MarkerOptions();
        googleMap.addMarker(markerOptions);

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.saveButton:
                if(titleEditText.getText() != null)
                    savePlan();
                break;
            case R.id.backButton: //send back to listview of plans
                intentToListView();
                break;
            case R.id.deleteButton:
                deletePlan();
                intentToListView();
                break;
        }
    }

    private void savePlan() {

    }

    private void intentToListView() {
        Intent intent = new Intent(this,PlanList.class);
        startActivity(intent);
    }

    private void deletePlan() {

    }
}
