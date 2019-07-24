package com.example.mvvm_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm_example.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button button;
    ActivityMainBinding binding;
    User usuario= new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil. setContentView(this,R.layout.activity_main);
        usuario.setName("JOHN2");
        binding.setUser(usuario);
        binding.setHandler(new EventHandler(this));

        button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        usuario.setName("Blue eyes white Dragon");
    }
}
