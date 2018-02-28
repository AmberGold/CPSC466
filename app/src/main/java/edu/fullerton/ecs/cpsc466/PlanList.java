package edu.fullerton.ecs.cpsc466;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ListView;

public class PlanList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView titleTextView;
    private ListView tripPlanListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_list);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        tripPlanListView = (ListView) findViewById(R.id.tripPlanListView);

        tripPlanListView.setOnItemClickListener(this);

    }

    //show options bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_list_view_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_plan:
                Intent intent = new Intent(PlanList.this, PlanEvent.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // for when user clicks on plans
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, PlanEvent.class);
        intent.putExtra("index", i);
        startActivity(intent);
    }
}
