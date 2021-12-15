package com.olzyinnovation.payoneerdemo.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.olzyinnovation.payoneerdemo.R;
import com.olzyinnovation.payoneerdemo.api.ApiClient.ApiClient;
import com.olzyinnovation.payoneerdemo.api.ApiClient.ApiInterface;
import com.olzyinnovation.payoneerdemo.api.paymentOptions.Applicable;
import com.olzyinnovation.payoneerdemo.api.paymentOptions.Networks;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentProcessPage extends AppCompatActivity {
    private RecyclerView paymentsRecView;
    private PaymentRecyclerViewAdapter adapter = new PaymentRecyclerViewAdapter(PaymentProcessPage.this);
    ApiInterface apiInterface;
    List<Applicable> applicableList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_process_page);

        Toolbar toolbar = findViewById(R.id.tbToolbar);
        setSupportActionBar(toolbar);

        paymentsRecView = findViewById(R.id.rvPaymentOptionsRecyclerView);
        paymentsRecView.setLayoutManager(new GridLayoutManager(this, 2));
        paymentsRecView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        fetchData();
    }


//    Fetch Payment Options List

    public void fetchData() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getNetworks().enqueue(new Callback<Networks>() {


            @Override
            public void onResponse(Call<Networks> call, Response<Networks> response) {
                if (response.isSuccessful()) {

                    applicableList = (List<Applicable>) response.body().getNetworkOptions();


                    for (int i = 0; i < applicableList.size(); i++) {
                        adapter = new PaymentRecyclerViewAdapter(PaymentProcessPage.this);

                        adapter.setPayments((ArrayList<Applicable>) applicableList);

                    }
                    paymentsRecView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Networks> call, Throwable t) {

            }
        });

    }


}