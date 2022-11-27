package day02.practise16.demo.service.impl;

import day02.practise16.demo.mapper.AccountMapper;
import day02.practise16.demo.pojo.Account;
import day02.practise16.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
        accountMapper.save(account);
    }

    public void update(Account account){
        accountMapper.update(account);
    }

    public void delete(Integer id) {
        accountMapper.delete(id);
    }

    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
