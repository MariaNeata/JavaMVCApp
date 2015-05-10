package ro.teamnet.zth.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Location;
import ro.teamnet.zth.app.service.LocationServiceImpl;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/locations")
public class LocationController {
    private LocationServiceImpl location = new LocationServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Location> getAllLocations() {
        return location.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Location getOneLocation(@PathVariable("id") int id) {

        return location.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Location addNewLocation(@RequestBody Location l) {
        return location.create(l);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    Location updateLocation(@RequestBody Location l) {
        return location.update(l);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable("id") String id)
    {
        location.delete(Integer.parseInt(id));
    }

}