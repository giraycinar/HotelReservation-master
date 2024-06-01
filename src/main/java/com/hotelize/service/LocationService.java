package com.hotelize.service;

import com.hotelize.domain.Location;
import com.hotelize.repository.LocationRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService extends ServiceManager<Location, String> {

    private final LocationRepository locationRepository;
    private final MongoOperations mongoOperations;

    public LocationService(LocationRepository locationRepository, MongoOperations mongoOperations) {
        super(locationRepository);
        this.locationRepository = locationRepository;
        this.mongoOperations = mongoOperations;
    }



    private List<String> getOnlyIdOfLocations(List<Location> locationList){
        return locationList.stream().map(Location::getId).collect(Collectors.toList());
    }

    /**
     * It will list all the locations matching with the given filters.
     * @param country Country filter. It would be filtered with the filters(containing+IgnoreCase)
     * @param city City filter. It would be filtered with the filters(containing+IgnoreCase)
     * @param address Address filter. It would be filtered with the filters(containing+IgnoreCase)
     * @return List of Location Ids that match conditions
     */
    public List<String> findAllIdsByFilters(String country, String city, String address) {
        return getOnlyIdOfLocations(findLocationByCriteria(country, city, address));
    }

    public List<Location> findLocationByCriteria(String country, String city, String address) {
        Query query = new Query();
        if (country != null) {
            query.addCriteria(Criteria.where("country").is(country));
        }
        if (city != null) {
            query.addCriteria(Criteria.where("city").is(city));
        }
        if (address != null) {
            query.addCriteria(Criteria.where("address").is(address));
        }
        return mongoOperations.find(query, Location.class);
    }

    public Location add(Location location) {
        return locationRepository.save(location);
    }
}
