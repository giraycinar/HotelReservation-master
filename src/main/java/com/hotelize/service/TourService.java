package com.hotelize.service;

import com.hotelize.domain.Tour;
import com.hotelize.domain.Tour;
import com.hotelize.repository.TourRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService extends ServiceManager<Tour, String> {

    private final TourRepository tourRepository;
    private final MongoOperations tourMongoOperations;

    public TourService(TourRepository tourRepository,MongoOperations tourMongoOperations) {
        super(tourRepository);
        this.tourRepository = tourRepository;
        this.tourMongoOperations = tourMongoOperations;
    }

    public List<Tour> findTourByCriteria(String name, Boolean isActive) {
        Query query = new Query();
        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name));
        }
        if (isActive != null) {
            query.addCriteria(Criteria.where("isActive").is(isActive));
        }
        return tourMongoOperations.find(query, Tour.class);
    }

    private List<String> getOnlyIdOfTour(List<Tour> tourList){
        return tourList.stream().map(Tour::getId).collect(Collectors.toList());
    }

    /**
     * Finds tours based on the given filters.
     * @param name Tour name filter. It would be filtered with the filters(containing+IgnoreCase)
     * @param isActive Tour isActive filter. It would be filtered with the filters(containing+IgnoreCase)
     * @return List of tours that match the conditions
     */
    public List<String> findAllIdsByFilters(String name, Boolean isActive) {
        return getOnlyIdOfTour(findTourByCriteria(name,isActive));
    }

    public Tour add(Tour tour) {
        return tourRepository.save(tour);
    }
}
