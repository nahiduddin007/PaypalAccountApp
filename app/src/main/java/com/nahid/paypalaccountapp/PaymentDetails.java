package com.nahid.paypalaccountapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
    TextView  tvId, tvAccount, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        tvId = findViewById(R.id.txtId);
        tvAccount= findViewById(R.id.txtAmount);
        tvStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();

        try {

            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetais"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    private void showDetails(JSONObject response, String paymentAmount)
    {
        try {
            tvId.setText(response.getString("id"));
            tvStatus.setText(response.getString("state"));
            tvAccount.setText("$"+paymentAmount);

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }




}
