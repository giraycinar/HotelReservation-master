package com.hotelize.service;

import com.hotelize.domain.Tags;
import com.hotelize.domain.Tags;
import com.hotelize.repository.TagsRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService extends ServiceManager<Tags, String> {

    private final TagsRepository tagsRepository;
    private final MongoOperations tagsMongoOperations;

    public TagsService(TagsRepository tagsRepository,MongoOperations tagsMongoOperations) {
        super(tagsRepository);
        this.tagsRepository = tagsRepository;
        this.tagsMongoOperations = tagsMongoOperations;
    }

    public Tags findTagsByTagId(String id){
        return tagsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tags not found")); // TODO TAGS EXCEPTION EKLENMELI
    }


    public List<Tags> findTagsByCriteria(String name) {
        Query query = new Query();
        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name));
        }
        return tagsMongoOperations.find(query, Tags.class);
    }
    private List<String> getOnlyIdOfTags(List<Tags> tagsList){
        return tagsList.stream().map(Tags::getId).collect(Collectors.toList());
    }

    /**
     * Finds tags based on the given filters.
     * @param name Tag name filter. It would be filtered with the filters(containing+IgnoreCase)
     * @return List of tags that match the conditions
     */
    public List<String> findAllIdsByFilters(String name) {
        return getOnlyIdOfTags(findTagsByCriteria(name));
    }

    public Tags add(Tags tags) {
        return tagsRepository.save(tags);
    }
}
