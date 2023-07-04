package day2023_03_19.practise21.service;

import day2023_03_19.practise21.pojo.Account;

import java.util.List;

public interface AccountService {

    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);

}
