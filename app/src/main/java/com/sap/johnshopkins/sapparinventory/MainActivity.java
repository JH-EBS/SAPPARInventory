package com.sap.johnshopkins.sapparinventory;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
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


public class MainActivity extends ActionBarActivity {
    private Spinner spinnerJHEDIDs = null;

    private int triggerIndex = 0;


    private String [] triggerStrings = {"lkrishn1", "dphelps1", "bking1", "mgeier1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerJHEDIDs  = (Spinner)findViewById(R.id.spinnerJHEDIDs);
        addSpinnerJHEDIDsListener();

        populateJHEDIDs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /*
     @Override
  public boolean onOptionsItemSelected(MenuItem item) {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         int id = item.getItemId();

         //noinspection SimplifiableIfStatement
         if (id == R.id.menu_about) {
             return true;
         }



         //<item android:id="@+id/menu_logon_off"
         //<item android:id="@+id/menu_count"
        // <item android:id="@+id/menu_download_items"
        // <item android:id="@+id/menu_test_connect"
         //<item android:id="@+id/menu_help"
         //<item android:id="@+id/menu_exit"
         //<item android:id="@+id/menu_about"






         return super.onOptionsItemSelected(item);
     }*/
    private void addSpinnerJHEDIDsListener() {

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
    }

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
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
     // Handle item selection
     switch (item.getItemId()) {
         case R.id.menu_download_items:
             // Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(getApplicationContext(), DownloadItemsActivity.class));
             return true;
         case R.id.menu_about:
             // Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(getApplicationContext(), AboutActivity.class));
             return true;

         default:
             return super.onOptionsItemSelected(item);
     }
 }
}