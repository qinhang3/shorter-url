package com.github.data;

import com.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hang on 16/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UrlDAOTest {

    @Autowired
    private UrlDAO urlDAO;

    @Test
    public void insert(){
        UrlDO urlDO = new UrlDO("http://www.tmall.com");
        urlDAO.save(urlDO);
    }

    @Test
    public void find(){
        System.out.println(urlDAO.findById(1L));
        Pageable pageable = new PageRequest(1,2);
        Page<UrlDO> page = urlDAO.findAll(pageable);
        System.out.println("totalElements = "+page.getTotalElements());
        List<UrlDO> urls = page.getContent();
        System.out.println(urls);
        Page<UrlDO> findByUrl = urlDAO.findByUrl("http://www.tmall.com", pageable);
        System.out.println(findByUrl.getContent());
    }
}
