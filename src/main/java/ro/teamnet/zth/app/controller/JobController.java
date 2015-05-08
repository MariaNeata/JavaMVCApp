package ro.teamnet.zth.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.teamnet.zth.app.dao.JobDao;
import ro.teamnet.zth.app.domain.Job;

import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/jobs")
public class JobController {
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Job> getAllJobs() {
        JobDao job=new JobDao();
        return job.getAllJobs();
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public
    @ResponseBody
    Job getOneJob(@RequestParam(value = "id") String id) {
        JobDao job=new JobDao();
        return job.getJobById(Integer.parseInt(id));
    }
}
