package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.JobDao;
import ro.teamnet.zth.app.domain.Job;

import java.util.List;

/**
 * Created by MN on 5/10/2015.
 */
public class JobServiceImpl implements JobService {

    private JobDao jobDao = new JobDao();

    @Override
    public Job findOne(Integer idJob) {
        return jobDao.getJobById(idJob);
    }

    @Override
    public List<Job> findAll() {
        return jobDao.getAllJobs();
    }

    @Override
    public Job create(Job job) {
        return jobDao.insertJob(job);
    }

    @Override
    public Job update(Job job) {
        return jobDao.updateJob(job);
    }

    @Override
    public void delete(Integer idJob) {
        Job job = jobDao.getJobById(idJob);
        jobDao.deleteJob(job);
    }

}
