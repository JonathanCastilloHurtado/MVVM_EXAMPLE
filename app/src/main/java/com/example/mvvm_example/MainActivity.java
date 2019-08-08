package com.example.mvvm_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mvvm_example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private UserVM viewModel = new UserVM();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //default_text = Click the button bellow in order to start the Api\'s request
        viewModel.response.set(getResources().getString(R.string.default_text));
        viewModel.isVisible.set(View.GONE);
        binding.setViewModel(viewModel);

    }

}
