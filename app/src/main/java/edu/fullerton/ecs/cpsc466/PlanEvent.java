package edu.fullerton.ecs.cpsc466;

import android.content.Intent;
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




public class PlanEvent extends AppCompatActivity implements OnClickListener, TextView.OnEditorActionListener {


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

        titleEditText.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_ACTION_UNSPECIFIED) {

        }
        return true;
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
