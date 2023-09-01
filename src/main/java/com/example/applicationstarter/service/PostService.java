package com.example.applicationstarter.service;

import com.example.applicationstarter.dao.entity.PostEntity;
import com.example.applicationstarter.dao.repository.PostRepository;
import com.example.applicationstarter.exception.NotFoundException;
import com.example.applicationstarter.mapper.CommentFactory;
import com.example.applicationstarter.mapper.PostMapper;
import com.example.applicationstarter.model.dto.PostDto;
import com.example.applicationstarter.model.dto.SaveCommentDto;
import com.example.applicationstarter.model.dto.SavePostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.applicationstarter.mapper.PostDetailFactory.buildPostDetailEntity;
import static com.example.applicationstarter.mapper.PostFactory.buildPostEntity;
import static com.example.applicationstarter.model.dto.constant.ExceptionConstants.POST_NOT_FOUND_CODE;
import static com.example.applicationstarter.model.dto.constant.ExceptionConstants.POST_NOT_FOUND_MESSAGE;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagService tagService;


    public void savePost(SavePostDto request) {
        var post = buildPostEntity(request);
        var postDetail = buildPostDetailEntity(post, request.getCreatedBy());

        if (!request.getTagIds().isEmpty()) {
            var tags = tagService.getTagsByIds(request.getTagIds());
            post.setTags(tags);
        }

        post.setDetail(postDetail);
        postRepository.save(post);
    }

    public void addCommentToPost(Long id, SaveCommentDto request) {
        var post = fetchPostIfExist(id);
        var comments = post.getComments();

        comments.add(CommentFactory.buildCommentEntity(post, request.getContent()));
        post.setComments(comments);

        postRepository.save(post);
    }

    public PostDto getPost(Long id) {
        var post = fetchPostIfExist(id);
        return PostMapper.mapEntityToDto(post);
    }

    private PostEntity fetchPostIfExist(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format(POST_NOT_FOUND_MESSAGE, id),
                                POST_NOT_FOUND_CODE));


    }
}