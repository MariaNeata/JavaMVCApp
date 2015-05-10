package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Location;

import java.util.List;

/**
 * Created by MN on 5/8/2015.
 */
public interface LocationService {
    Location findOne(Integer idLocation);

    List<Location> findAll();

    Location create(Location location);

    Location update(Location location);

    void delete(Integer idLocation);
}
