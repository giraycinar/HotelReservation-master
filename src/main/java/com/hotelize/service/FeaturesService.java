package com.hotelize.service;

import com.hotelize.domain.Features;
import com.hotelize.domain.Features;
import com.hotelize.repository.FeaturesRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeaturesService extends ServiceManager<Features, String> {
    private final FeaturesRepository featuresRepository;
    Hotel_FeaturesService hotel_featuresService;
    private final MongoOperations featureMongoOperations;

    public FeaturesService(FeaturesRepository featuresRepository, MongoOperations featureMongoOperations) {
        super(featuresRepository);
        this.featuresRepository = featuresRepository;
        this.featureMongoOperations = featureMongoOperations;
    }

    private List<String> getOnlyIdOfFeatures(List<Features> FeaturesList){
        return FeaturesList.stream().map(Features::getId).collect(Collectors.toList());
    }

    /**
     * Finds features based on the given filters.
     * @param name Feature name filter. It would be filtered with the filters(containing+IgnoreCase)
     * @param count Feature count filter. It would be filtered with the filters(containing+IgnoreCase)
     * @param isActive Feature isActive filter. It would be filtered with the filters(containing+IgnoreCase)
     * @return List of features that match the conditions
     */
    public List<String> findAllIdsByFilters(String name, Integer count, Boolean isActive) {
        return getOnlyIdOfFeatures(findFeaturesByCriteria(name, count, isActive));
    }
    public List<Features> findFeaturesByCriteria(String name, Integer count, Boolean isActive) {
        Query query = new Query();
        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name));
        }
        if (count != null) {
            query.addCriteria(Criteria.where("count").is(count));
        }
        if (isActive != null) {
            query.addCriteria(Criteria.where("isActive").is(isActive));
        }
        return featureMongoOperations.find(query, Features.class);
    }

    public Features add(Features features) {

        return featuresRepository.save(features);
    }
}
