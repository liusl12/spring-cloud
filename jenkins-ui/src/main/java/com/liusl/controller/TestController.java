package com.liusl.controller;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * created by l1 on 2017/12/5.
 */
@RestController
@RequestMapping(value = "/jenkins",method = RequestMethod.GET)
public class TestController {
    @Autowired
    private JenkinsServer jenkinsServer;

    @RequestMapping(value = "/getJobs")
    public Map<String,Job> getJobs() throws IOException {
        Map<String,Job> jobs = jenkinsServer.getJobs();
        return jobs;
    }

}
