package com.jj.testDataBinding.activitys;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.jj.testDataBinding.R;
import com.jj.testDataBinding.adapters.ListAdapter;
import com.jj.testDataBinding.callbacks.ListClickCallback;
import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.databinding.LayoutActivityListBinding;
import com.jj.testDataBinding.viewmodels.ListViewModel;

import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener,ListClickCallback{
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LayoutActivityListBinding listBinding;
    private ListViewModel listViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = DataBindingUtil.setContentView(this, R.layout.layout_activity_list);
        listBinding.setClickCallback(this);
        listAdapter = new ListAdapter(this);
        listBinding.recyclerView.setAdapter(listAdapter);
        listBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(this);
        listBinding.recyclerView.setLayoutManager(layoutManager);
        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        listViewModel.getUserData().observeForever(new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                listAdapter.setData(users);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        User user = (User) v.getTag();
        Log.w("ListActivity","name = " + user.getName() + " age = " + user.getAge());
    }

    @Override
    public void onAddUserClick() {
        String name = listBinding.nameInput.getText().toString();
        if(TextUtils.isEmpty(name)){
            Log.w("ListActivity","please input name");
            return;
        }
        String age = listBinding.ageInput.getText().toString();
        if(TextUtils.isEmpty(age)){
            Log.w("ListActivity","please input age");
            return;
        }
        User user = new User(name,Integer.parseInt(age));
        listViewModel.addUser(user);
//        listBinding.nameInput.setText("");
//        listBinding.ageInput.setText("");
    }
}
