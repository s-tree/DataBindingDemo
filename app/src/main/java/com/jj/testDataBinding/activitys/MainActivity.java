package com.jj.testDataBinding.activitys;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jj.testDataBinding.R;
import com.jj.testDataBinding.callbacks.MainClickCallback;
import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.databinding.ActivityMainBinding;
import com.jj.testDataBinding.viewmodels.ActivityMainViewModel;

public class MainActivity extends AppCompatActivity implements MainClickCallback{
    User user = new User();
    ActivityMainBinding binding;
    ActivityMainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ActivityMainViewModel();
        viewModel.setUser(user);
        user.setName("hello");
        binding.setMainClick(this);
        binding.setModel(viewModel);
    }

    @Override
    public void setNameClick() {
        String name = binding.userNameInput.getText().toString();
        user.setName(name);
        binding.setModel(viewModel);
    }

    @Override
    public void startListActivityClick() {
        startActivity(new Intent(MainActivity.this,ListActivity.class));
    }
}
