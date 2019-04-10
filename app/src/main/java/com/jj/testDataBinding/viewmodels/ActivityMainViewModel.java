package com.jj.testDataBinding.viewmodels;

import com.jj.testDataBinding.data.User;

public class ActivityMainViewModel {

    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name){
        user.setName(name);
    }
}
