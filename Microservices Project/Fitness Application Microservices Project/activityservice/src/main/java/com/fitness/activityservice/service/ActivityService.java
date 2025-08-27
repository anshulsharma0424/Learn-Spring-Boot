package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.entity.Activity;
import com.fitness.activityservice.mapper.ActivityMapper;
import com.fitness.activityservice.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = activityMapper.toActivityEntity(request);
        Activity savedActivity = activityRepository.save(activity);
        return activityMapper.toActivityResponse(savedActivity);
    }
}
