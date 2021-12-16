package com.olzyinnovation.payoneerdemo.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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
    List<Applicable> applicableList = new ArrayList<>();
    GridLayoutManager layoutManager;
    public static final String TAG = "PaymentProcessPage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_process_page);

        Toolbar toolbar = findViewById(R.id.tbToolbar);
        setSupportActionBar(toolbar);

        paymentsRecView = findViewById(R.id.rvPaymentOptionsRecyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        paymentsRecView.setLayoutManager(layoutManager);
//        paymentsRecView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new PaymentRecyclerViewAdapter((ArrayList<Applicable>) applicableList, this);
        paymentsRecView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        fetchData();
    }


//    Fetch Payment Options List

    private void fetchData() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getNetworks().enqueue(new Callback<Networks>() {


            @Override
            public void onResponse(Call<Networks> call, Response<Networks> response) {
                try {
                    int responseCode = response.code();
                    if (response.isSuccessful() && response.body() != null) {
                        for (int i = 0; i < 17; i++) {
                            applicableList.add(i, response.body().getNetworkOptions());
                            adapter.setPayments((ArrayList<Applicable>)applicableList);
                            adapter.notifyDataSetChanged();

                        }
                    } else if (responseCode == 404) {
                        Toast.makeText(PaymentProcessPage.this, "Something went wrong, Please try again later", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "404 API Error");
                    } else if (responseCode == 500) {
                        Toast.makeText(PaymentProcessPage.this, "Something went wrong, Please try again later", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "500 API Error");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Networks> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }


}