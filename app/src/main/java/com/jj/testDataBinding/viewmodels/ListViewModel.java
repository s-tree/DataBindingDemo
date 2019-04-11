package com.jj.testDataBinding.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.repositorys.UserRepository;

import java.util.List;

/**
 * AndroidViewModel 会和Activity 绑定生命周期
 * 监听到Activity 销毁时会同时销毁自身
 *
 * MutableLiveData 继承自 LiveData
 * 可以被观察，在被销毁时会自动销毁观察者
 *
 * 因此  MutableLiveData + AndroidViewModel 不会造成内存泄露
 *
 * 但是如果 MutableLiveData 是一个静态变量，这种机制就无效，所以只能以内部变量存在于 AndroidViewModel 中
 */
public class ListViewModel extends AndroidViewModel {
    private MutableLiveData<List<User>> cacheUsers = new MutableLiveData<>();

    public ListViewModel(Application application) {
        super(application);
    }

    public MutableLiveData<List<User>> getUserData() {
        if(cacheUsers.getValue() == null || cacheUsers.getValue().isEmpty()){
            cacheUsers.setValue(UserRepository.getCacheUsers());
        }
        return cacheUsers;
    }

    public void addUser(User user){
        cacheUsers.getValue().add(0,user);
        cacheUsers.postValue(cacheUsers.getValue());
    }
}
