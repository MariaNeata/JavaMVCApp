package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Location;

import java.util.List;

/**
 * Created by MN on 5/10/2015.
 */
public class LocationServiceImpl implements LocationService {
    private LocationDao locationDao = new LocationDao();

    @Override
    public Location findOne(Integer idLocation) {
        return locationDao.getLocationById(idLocation);
    }

    @Override
    public List<Location> findAll() {
        return locationDao.getAllLocations();
    }

    @Override
    public Location create(Location location) {
        return locationDao.insertLocation(location);
    }

    @Override
    public Location update(Location location) {
        return locationDao.updateLocation(location);
    }

    @Override
    public void delete(Integer idLocation) {
        Location location = locationDao.getLocationById(idLocation);
        locationDao.deleteLocation(location);
    }
}
