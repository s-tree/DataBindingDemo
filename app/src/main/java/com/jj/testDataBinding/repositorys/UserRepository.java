package com.jj.testDataBinding.repositorys;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.jj.testDataBinding.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    public static UserRepository getInstance(){
        if(instance == null){
            synchronized (UserRepository.class){
                if(instance == null){
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    /**
     * Model 只需要用 MutableLive 就可以了， ViewModel 用 MediatorLiveData 监听这个LiveData
     */
    MutableLiveData<List<User>> userList = new MutableLiveData<>();

    private UserRepository() {
        userList.setValue(initDatas());
    }

    public LiveData<List<User>> getCacheUsers() {
        return userList;
    }

    public void addUser(User user){
        List<User> datas = userList.getValue();
        datas.add(0,user);
        userList.setValue(datas);
    }

    private static List<User> initDatas(){
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
        userList.add(new User("李雷2",15));
        userList.add(new User("张三2",17));
        userList.add(new User("李四2",18));
        userList.add(new User("王玉2",13));
        userList.add(new User("赵六2",17));
        userList.add(new User("收到2",20));
        userList.add(new User("辅导费2",21));
        userList.add(new User("地方放2",32));
        userList.add(new User("得到2",25));
        return userList;
    }
}
