package com.jj.testDataBinding;

import android.view.View;

public class ActivityMainViewModel {

    public User user;
    public View.OnClickListener onClickListener;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
