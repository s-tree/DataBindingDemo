package com.jj.testDataBinding.repositorys;

import com.jj.testDataBinding.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    public static List<User> getCacheUsers() {
        return initDatas();
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
