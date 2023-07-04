package day2023_03_19.practise25.service.impl;

import day2023_03_19.practise25.mapper.AccountDao;
import day2023_03_19.practise25.service.AccountService;
import day2023_03_19.practise25.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    public void transfer(String out,String in ,Double money) throws IOException {

            try {
                accountDao.outMoney(out,money);
                int i = 1/0;
                accountDao.inMoney(in,money);
            }finally {
                logService.log(out,in,money);
            }

    }

}
