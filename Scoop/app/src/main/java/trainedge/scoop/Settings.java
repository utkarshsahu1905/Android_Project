
package trainedge.scoop;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class Settings extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    public static final String TAG = "Settings";
    private Switch notif;
    private SharedPreferences pref;
    private ArrayAdapter<CharSequence> adapter;
    private ArrayAdapter<CharSequence> adapter1;
    private Spinner spinner;
    private Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pref = getSharedPreferences("setting_pref", MODE_PRIVATE);

        notif = (Switch) findViewById(R.id.notif);
        notif.setOnCheckedChangeListener(this);


        spinner = (Spinner) findViewById(R.id.theme);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.theme, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        spinner1 = (Spinner) findViewById(R.id.quality);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.quality, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);


        updateUI();


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor editor = pref.edit();
        if (buttonView.getId() == R.id.notif) {
            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            editor.putBoolean("notif_option", isChecked);
            editor.apply();
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }

    private void updateUI() {
        boolean notifi = pref.getBoolean("notif_option", false);
        notif.setChecked(notifi);

        spinner.setSelection(pref.getInt("themepos", 0));
        spinner1.setSelection(pref.getInt("qualitypos", 0));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences.Editor edit = pref.edit();
        switch (parent.getId()) {
            case R.id.theme:
                edit.putInt("themepos", position);
                edit.putString("theme", String.valueOf(adapter.getItem(position)));
                break;
            case R.id.quality:
                edit.putInt("qualitypos", position);
                edit.putString("theme", String.valueOf(adapter.getItem(position)));
                break;


        }
        edit.apply();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //FirebaseAuth.getInstance().signOut();
    //intent to login activity
    //finish();

}


