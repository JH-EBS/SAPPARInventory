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
import java.util.logging.Logger;

import org.ksoap2.*;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportBasicAuth;

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
import android.widget.Toast;

public class MainActivity extends Activity {

   /* private final String NAMESPACE = "http://www.w3schools.com/webservices/";
    private final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
    private final String SOAP_ACTION = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";
    private final String METHOD_NAME = "CelsiusToFahrenheit";
    private String TAG = "PGGURU";
    private static String celcius;
    private static String fahren;*/


   private final String NAMESPACE = "http://jhu.edu/scmmmi060801/WirelessPARJHED/";
//    private final String URL = "https://dvpi.erp.johnshopkins.edu/XISOAPAdapter/MessageServlet?channel=:WirelessPARJHEDWebService_BUSS:SOAP_WirelessPARJHEDWebService&amp;version=3.0&amp;Sender.Service=x&amp;Interface=x%5Ex";
private final String URL = "http://d241xpi.hosts.jhmi.edu:50000/XISOAPAdapter/MessageServlet?channel=:WirelessPARJHEDWebService_BUSS:SOAP_WirelessPARJHEDWebService&amp;version=3.0&amp;Sender.Service=x&amp;Interface=x%5Ex";

//    private final String URL = "http://d241xpi.hosts.jhmi.edu:50000/XISOAPAdapter/MessageServlet";
//
    private final String SOAP_ACTION = "http://jhu.edu/scmmmi060801/WirelessPARJHED/mi_WirelessPARJHED";
//    private final String SOAP_ACTION = "http://sap.com/xi/WebService/soap1.1/mi_WirelessPARJHED";
//    http://sap.com/xi/WebService/soap1.1
    private final String METHOD_NAME = "mi_WirelessPARJHED";
    private final String LOGIN_ID = "ddigreg4";
    private final String PASS = "55#crabs";
    private String TAG = "PGGURU";
    private static String currstatus;
    private static String responsefromWS;


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
        final TextView text_status;


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
        text_status = (TextView) findViewById(R.id.txt_menu_status);

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


//                AsyncCallWS task = new AsyncCallWS();
//                                //Call execute
//                                task.execute();

                getJHEDIDs("ddigreg4");
                // Start NewActivity.class
 /*               Intent myIntent = new Intent(MainActivity.this,
                        CountTemplate.class);
                startActivity(myIntent);*/
text_status.setText (responsefromWS);








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
 public void getJHEDIDs(String ReqJHEDID) {
//Create request
     SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
     //Property which holds input parameters
     PropertyInfo JHEDIDPI = new PropertyInfo();
     //Set Name
     JHEDIDPI.setName("JHEDID");
//Set Value
     JHEDIDPI.setValue(ReqJHEDID);
//Set dataType
     JHEDIDPI.setType(String.class);
//Add the property to request object
     request.addProperty(JHEDIDPI);
//Create envelope
     SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
     envelope.dotNet = true;
//Set output SOAP object
     envelope.setOutputSoapObject(request);
     //Create HTTP call object

     try {
//Invole web service
         HttpTransportBasicAuth androidHttpTransport = new HttpTransportBasicAuth (URL, LOGIN_ID, PASS);
         androidHttpTransport.debug = true;
         androidHttpTransport.setXmlVersionTag("<!--?xml version=\"1.0\" encoding= \"UTF-8\" ?-->");
         androidHttpTransport.call(SOAP_ACTION, envelope);
         //Get the response
         SoapObject response = (SoapObject)envelope.bodyIn;
//                 envelope.getResponse();
         //Assign it to fahren static variable
         if(response != null) {
             responsefromWS = response.getProperty(0).toString();
         }
         else
         {
             Toast.makeText(getApplicationContext(), "No Response",Toast.LENGTH_LONG).show();
         }
     } catch (Exception e) {

         e.printStackTrace();    }
 }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
//
//        TextView text_status;
//        setContentView(R.layout.activity_main);
//        text_status = (TextView) findViewById(R.id.txt_menu_status);
//







        @Override
        protected Void doInBackground(String... params) {
            //Log.i(TAG, "doInBackground");
            currstatus = "doInBackground";
            getJHEDIDs("ddigreg4");
            return null;        }
        @Override
        protected void onPostExecute(Void result) {
            currstatus = "doPostExecute";
            //Log.i(TAG, "onPostExecute");
            currstatus = responsefromWS;
            //tv.setText(fahren + "° F");
        }
        @Override
        protected void onPreExecute() {
            currstatus = "doPreExecute-Getting data...";
//            Log.i(TAG, "onPreExecute");
//            tv.setText("Calculating...");
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            currstatus = "doProgressUpdate";
           // Log.i(TAG, "onProgressUpdate");
        }
    }
}