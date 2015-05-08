package ro.teamnet.zth.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Location;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/locations")
public class LocationController {
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllLocations() {
        return "All Locations";
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public
    @ResponseBody
    Location getOneLocation(@RequestParam(value = "id") String id) {
        LocationDao location=new LocationDao();
        return location.getLocationById(Integer.parseInt(id));
    }
}
