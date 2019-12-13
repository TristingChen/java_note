package com.cjl.java.cjl_java.repository;

import com.cjl.java.cjl_java.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository //用于标识UserRepositoryimpl 类是一个可注入的bean 。
public class UserRepositoryImpl implements UserRepository{

    private static AtomicLong counterId = new AtomicLong();
    //模拟数据存储
    private final ConcurrentHashMap<Long,User> userConcurrentMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id =user.getId();
        if (id==null){
            id=counterId.incrementAndGet();
            user.setId(id);
        }
        this.userConcurrentMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userConcurrentMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userConcurrentMap.get(id);
    }

    @Override
    public List<User> userList() {
        return new ArrayList<User>(this.userConcurrentMap.values());
    }
}
