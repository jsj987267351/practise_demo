package day2023_03_19.practise23.demo.service.impl;

import day2023_03_19.practise23.demo.dao.ResourcesDao;
import day2023_03_19.practise23.demo.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    private ResourcesDao resourcesDao;

    public boolean openURL(String url, String password) {
        return resourcesDao.readResources(url,password);
    }
}
