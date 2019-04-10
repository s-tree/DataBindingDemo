package com.jj.testDataBinding.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jj.testDataBinding.R;
import com.jj.testDataBinding.adapters.ListAdapter;
import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.databinding.LayoutActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{
    private ListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;
    private LayoutActivityListBinding listBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = DataBindingUtil.setContentView(this, R.layout.layout_activity_list);
        listAdapter = new ListAdapter(initDatas(),this);
        listBinding.recyclerView.setAdapter(listAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        listBinding.recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<User> initDatas(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("李雷",15));
        userList.add(new User("张三",17));
        userList.add(new User("李四",18));
        userList.add(new User("王玉",13));
        userList.add(new User("赵六",17));
        userList.add(new User("收到",20));
        userList.add(new User("辅导费",21));
        userList.add(new User("地方放",32));
        userList.add(new User("得到",25));
        userList.add(new User("李雷",15));
        userList.add(new User("张三",17));
        userList.add(new User("李四",18));
        userList.add(new User("王玉",13));
        userList.add(new User("赵六",17));
        userList.add(new User("收到",20));
        userList.add(new User("辅导费",21));
        userList.add(new User("地方放",32));
        userList.add(new User("得到",25));
        return userList;
    }

    @Override
    public void onClick(View v) {
        User user = (User) v.getTag();
        Log.w("ListActivity","name = " + user.getName() + " age = " + user.getAge());
    }
}
