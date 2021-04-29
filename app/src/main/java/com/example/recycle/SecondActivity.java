package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView iv_imageCar;
    TextView tv_car;
    TextView tv_carDetails;
    Button b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        iv_imageCar = findViewById(R.id.iv_carPhoto);
        tv_car = findViewById(R.id.tv_carName);
        tv_carDetails = findViewById(R.id.tv_carDetail);
        b_back = findViewById(R.id.b_back);

        Bundle bundle = getIntent().getExtras();
        tv_car.setText(bundle.getString("name"));
        tv_carDetails.setText(bundle.getString("details"));
        iv_imageCar.setImageResource(bundle.getInt("photos"));

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(a);
                finish();
            }
        });
    }
}