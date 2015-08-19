package com.sap.johnshopkins.sapparinventory;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.EMDKResults;
import com.symbol.emdk.EMDKManager.EMDKListener;
import com.symbol.emdk.EMDKManager.FEATURE_TYPE;
import com.symbol.emdk.barcode.BarcodeManager;
import com.symbol.emdk.barcode.BarcodeManager.ConnectionState;
import com.symbol.emdk.barcode.BarcodeManager.ScannerConnectionListener;
import com.symbol.emdk.barcode.ScanDataCollection;
import com.symbol.emdk.barcode.Scanner;
import com.symbol.emdk.barcode.ScannerConfig;
import com.symbol.emdk.barcode.ScannerException;
import com.symbol.emdk.barcode.ScannerInfo;
import com.symbol.emdk.barcode.ScannerResults;
import com.symbol.emdk.barcode.ScanDataCollection.ScanData;
import com.symbol.emdk.barcode.Scanner.DataListener;
import com.symbol.emdk.barcode.Scanner.StatusListener;
import com.symbol.emdk.barcode.Scanner.TriggerType;
import com.symbol.emdk.barcode.StatusData.ScannerStates;
import com.symbol.emdk.barcode.StatusData;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends Activity {





    private Spinner spinnerJHEDIDs = null;

    private int triggerIndex = 0;


    private String [] triggerStrings = {"lkrishn1", "dphelps1", "bking1", "mgeier1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button_count;
        Button button_load_templates;
        Button button_refresh_templates;
        Button button_refresh_jhedids;
        Button button_test_connect;
        Button button_exit;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        spinnerJHEDIDs  = (Spinner)findViewById(R.id.spinnerJHEDIDs);
//        addSpinnerJHEDIDsListener();


            // Locate the buttons in activity_main.xml
        button_count = (Button) findViewById(R.id.btn_count);
        button_load_templates = (Button) findViewById(R.id.btn_load_templates);
        button_refresh_templates = (Button) findViewById(R.id.btn_refresh_template_list);
        button_refresh_jhedids = (Button) findViewById(R.id.btn_refresh_JHEDIDs);
        button_test_connect = (Button) findViewById(R.id.btn_test_connectivity);
        button_exit = (Button) findViewById(R.id.btn_exit);


            // Capture button clicks
        button_count.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {

                    // Start NewActivity.class
                    Intent myIntent = new Intent(MainActivity.this,
                            ChooseTemplateMenuActivity.class);
                    startActivity(myIntent);
                }
            });
        // Capture button clicks
        button_load_templates.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        LoadTemplateActivity.class);
                startActivity(myIntent);
            }
        });
        // Capture button clicks
        button_refresh_jhedids.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
 /*               Intent myIntent = new Intent(MainActivity.this,
                        CountTemplate.class);
                startActivity(myIntent);*/
            }
        });
        // Capture button clicks
        button_refresh_templates.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
  /*              Intent myIntent = new Intent(MainActivity.this,
                        CountTemplate.class);
                startActivity(myIntent);*/
            }
        });

        // Capture button clicks
        button_test_connect.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
  /*              Intent myIntent = new Intent(MainActivity.this,
                        CountTemplate.class);
                startActivity(myIntent);*/
            }
        });

        // Capture button clicks
        button_exit.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
  /*              Intent myIntent = new Intent(MainActivity.this,
                        CountTemplate.class);
                startActivity(myIntent);*/
            }
        });
//        populateJHEDIDs();
    }



 /*   private void addSpinnerJHEDIDsListener() {

        spinnerJHEDIDs.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long arg3) {


                triggerIndex = position;
                //             setTrigger();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
    private void populateJHEDIDs() {

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, triggerStrings);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerJHEDIDs.setAdapter(spinnerAdapter);
        spinnerJHEDIDs.setSelection(triggerIndex);
    }*/

 /*   private void setTrigger() {

        if (scanner == null) {
            initScanner();
        }

        if (scanner != null) {
            switch (triggerIndex) {
                case 0: // Selected "HARD"
                    scanner.triggerType = TriggerType.HARD;
                    break;
                case 1: // Selected "SOFT"
                    scanner.triggerType = TriggerType.SOFT_ALWAYS;
                    break;
            }
        }
    }

*/

}