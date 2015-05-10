package ro.teamnet.zth.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.dao.JobDao;
import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.service.JobServiceImpl;

import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/jobs")
public class JobController {
    JobServiceImpl job = new JobServiceImpl();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Job> getAllJobs() {
        return job.findAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Job getOneJob(@PathVariable(value = "id") String id) {

        return job.findOne(Integer.parseInt(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOneJob(@PathVariable("id") String id) {
        job.delete(Integer.parseInt(id));
    }


    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Job addNewJob(@RequestBody Job j) {

        return job.create(j);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    Job updateJob(@RequestBody Job j) {

        return job.update(j);

    }
}
