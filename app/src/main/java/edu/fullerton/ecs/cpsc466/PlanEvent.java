package edu.fullerton.ecs.cpsc466;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;




public class PlanEvent extends AppCompatActivity implements OnClickListener {

    private SharedPreferences savedValues;

    EditText titleEditText;

    Button saveButton;
    Button deleteButton;
    Button backButton;

    TextView textViewStart;
    TextView textViewSecond;
    TextView textViewThird;
    TextView textViewFourth;
    TextView textViewFifth;
    TextView textViewEnd;

    Spinner startLocation;
    Spinner secondLocation;
    Spinner thirdLocation;
    Spinner fourthLocation;
    Spinner fifthLocation;
    Spinner endLocation;

    private String titleString = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_event);

        titleEditText = (EditText) findViewById(R.id.title);

        saveButton = (Button) findViewById(R.id.saveButton);
        backButton = (Button) findViewById(R.id.backButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        textViewStart = (TextView) findViewById(R.id.textViewStart);
        textViewSecond = (TextView) findViewById(R.id.textViewSecond);
        textViewThird = (TextView) findViewById(R.id.textViewThird);
        textViewFourth = (TextView) findViewById(R.id.textViewFourth);
        textViewFifth = (TextView) findViewById(R.id.textViewFifth);
        textViewEnd = (TextView) findViewById(R.id.textViewEnd);

        startLocation = (Spinner) findViewById(R.id.startLocation);
        secondLocation = (Spinner) findViewById(R.id.secondLocation);
        thirdLocation = (Spinner) findViewById(R.id.thirdLocation);
        fourthLocation = (Spinner) findViewById(R.id.fourthLocation);
        fifthLocation = (Spinner) findViewById(R.id.fifthLocation);
        endLocation = (Spinner) findViewById(R.id.endLocation);

        saveButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    // If app closes, saves the value of the title string
    @Override
    protected void onResume() {
        titleString = savedValues.getString("titleString", "");

        titleEditText.setText(titleString);

        super.onResume();
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
        titleString = titleEditText.getText().toString();

    }

    private void intentToListView() {
        Intent intent = new Intent(this,PlanList.class);
        startActivity(intent);
    }

    private void deletePlan() {

    }
}
