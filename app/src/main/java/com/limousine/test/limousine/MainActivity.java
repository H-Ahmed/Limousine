package com.limousine.test.limousine;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.limousine.test.limousine.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // create Binding variable
    ActivityMainBinding mBinding;

    private static final String NUMBER_OF_PASSENGERS = "numberOfPassenger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set Data to Binding variable
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // get number of passenger
        String numberOfPassengerString = mBinding.numberOfPassengerEditView.getText().toString();

        //convert numberOfPassengerString to int
        final int numberOfPassenger = Integer.parseInt(numberOfPassengerString);

        // to select car and driver
        mBinding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOfPassenger <= 0){
                    Toast.makeText(MainActivity.this, R.string.less_than_0_passenger, Toast.LENGTH_SHORT).show();
                }else {
                    // start Selection Activity and send number of Passengers to it
                    Intent intent = new Intent(MainActivity.this, SelectionsActivity.class);
                    intent.putExtra(NUMBER_OF_PASSENGERS, numberOfPassenger);
                    startActivity(intent);
                }
            }
        });

    }
}
