package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Job;

import java.util.List;

/**
 * Created by MN on 5/8/2015.
 */
public interface JobService {
    Job findOne(Integer idJob);

    List<Job> findAll();

    Job create(Job job);

    Job update(Job job);

    void delete(Integer idJob);
}
