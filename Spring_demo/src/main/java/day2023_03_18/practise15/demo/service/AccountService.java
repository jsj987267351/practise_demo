package day2023_03_18.practise15.demo.service;

import day2023_03_18.practise15.demo.pojo.Account;

import java.util.List;

public interface AccountService {

    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);

}
