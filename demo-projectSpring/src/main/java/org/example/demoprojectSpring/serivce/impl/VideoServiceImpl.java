package org.example.demoprojectSpring.serivce.impl;

import org.example.demoprojectSpring.domain.Video;
import org.example.demoprojectSpring.mapper.VideoMapper;
import org.example.demoprojectSpring.serivce.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
