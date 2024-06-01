package com.hotelize.service;

import com.hotelize.domain.Hotel_Tags;
import com.hotelize.domain.Tags;
import com.hotelize.repository.Hotel_TagsRepository;
import com.hotelize.repository.TagsRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Hotel_TagsService extends ServiceManager<Hotel_Tags, String> {
    private final Hotel_TagsRepository hotelTagsRepository;
    TagsService tagsService;


    public Hotel_TagsService(Hotel_TagsRepository hotelTagsRepository) {
        super(hotelTagsRepository);
        this.hotelTagsRepository = hotelTagsRepository;
    }

    public List<Tags> findAllTagsByHotelId(String hotelId){
        return hotelTagsRepository.findAllByHotelId(hotelId)
                .stream()
                .filter(x-> x.getHotelId().equals(hotelId))
                .map(Hotel_Tags::getTagId).
                toList()
                .stream()
                .map(x-> tagsService.findTagsByTagId(x))
                .collect(Collectors.toList());

    }
    public List<String> findHotelIdsByTagIds(List<String> tagIds){
        return hotelTagsRepository
                .findAllByTagIdIn(tagIds)
                .stream()
                .map(Hotel_Tags::getHotelId)
                .collect(Collectors.toList());
    }
}
