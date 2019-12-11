package com.test.jose.testcase8.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.test.jose.testcase8.R;
import com.test.jose.testcase8.model.AnalyticsDataList;
import com.test.jose.testcase8.model.DatasetsList;
import com.test.jose.testcase8.model.Purchases;
import com.test.jose.testcase8.model.Session_Infos;
import com.test.jose.testcase8.network.GetDataService;
import com.test.jose.testcase8.network.DataInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    List<DatasetsList> datasetList;
    GetDataService service;

    ArrayList<String> countryList = new ArrayList<String>();
    ArrayList<String> stateList = new ArrayList<String>();
    ArrayList<String> manufacturerList = new ArrayList<String>();List<Session_Infos> sessionList ;
    List<Purchases> purchaseList ;

    //spinners
    Spinner spinnerManufacturer, spinnerCategory, spinnerCountry, spinnerState;
    //cost textview
    TextView txtCostManufacturer, txtCostCategory, txtCostCountry, txtCostState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerManufacturer = findViewById(R.id.spinnerManufacturer);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerState = findViewById(R.id.spinnerState);

        txtCostManufacturer = findViewById(R.id.txtCostManufacturer);
        txtCostCategory = findViewById(R.id.txtCostCategory);
        txtCostCountry = findViewById(R.id.txtCostCountry);
        txtCostState = findViewById(R.id.txtCostState);

        /*Create handle for the RetrofitInstance interface*/
        service = DataInstance.getRetrofitInstance().create(GetDataService.class);

        generateBuildingList();
        generateAnalyticList();
    }

    private void generateAnalyticList() {
        Call<List<AnalyticsDataList>> call = service.getAnalytics();
        call.enqueue(new Callback<List<AnalyticsDataList>>() {
            @Override
            public void onResponse(Call<List<AnalyticsDataList>> call, Response<List<AnalyticsDataList>> response) {
                List<AnalyticsDataList> analyticsDataLists = response.body();
                for (int i = 0; i < analyticsDataLists.size(); i++) {
                    String manufacturerName = analyticsDataLists.get(i).getManufacturer();
                    if (!manufacturerList.contains(manufacturerName)) {
                        manufacturerList.add(manufacturerName);
                        Log.e("manufacturerName", manufacturerName);
                    }

                    }
                funSpinnerAdapterManufacturer();
            }

            @Override
            public void onFailure(Call<List<AnalyticsDataList>> call, Throwable t) {

            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateBuildingList() {
        Call<List<DatasetsList>> call = service.getbuildings();
        call.enqueue(new Callback<List<DatasetsList>>() {

            @Override
            public void onResponse(Call<List<DatasetsList>> call, Response<List<DatasetsList>> response) {
                //generateDataList(response.body());
                datasetList = response.body();
                // Log.e("buildingname size", datasetList.size() + "");
                for (int i = 0; i < datasetList.size(); i++) {
                    //Log.e("buildingname", datasetList.get(i).getBuilding_name());
                    String countryName = datasetList.get(i).getCountry();
                    String stateName = datasetList.get(i).getState();

                    if (!stateList.contains(stateName)) {
                        stateList.add(stateName);
                        Log.e("stateName", stateName);
                    }
                    if (!countryList.contains(countryName)) {
                        countryList.add(countryName);
                        Log.e("Countryname", countryName);
                    }
                }

                funSpinnerAdapter();
                funSpinnerAdapterCountry();

            }

            @Override
            public void onFailure(Call<List<DatasetsList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void funSpinnerAdapterManufacturer() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, manufacturerList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerManufacturer.setAdapter(arrayAdapter);
        spinnerManufacturer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String manufacturerNameSelected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), manufacturerNameSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void funSpinnerAdapterCountry() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countryList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(arrayAdapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String counrtyNameSelected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), counrtyNameSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void funSpinnerAdapter() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stateList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(arrayAdapter);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String statenameselected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), statenameselected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
