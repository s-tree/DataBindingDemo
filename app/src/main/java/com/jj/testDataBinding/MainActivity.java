package com.jj.testDataBinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jj.testDataBinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    User user = new User();
    ActivityMainBinding binding;
    ActivityMainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ActivityMainViewModel();
        viewModel.onClickListener = this;
        viewModel.setUser(user);
        user.setName("hello");
        binding.setModel(viewModel);
    }

    @Override
    public void onClick(View v) {
        String name = binding.userNameInput.getText().toString();
        user.setName(name);
        binding.notifyPropertyChanged(BR.model);
    }
}
