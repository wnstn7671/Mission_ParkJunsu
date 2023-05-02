package com.ll.gramgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableJpaAuditing // @EntityListeners(AuditingEntityListener.class) 가 작동하도록 허용
public class GramgramApplication {

    public static void main(String[] args) {
   SpringApplication.run(GramgramApplication.class, args);
    }

}
/*

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final int CREATE_POST_INTERVAL_MINUTES = 30;

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        LocalDateTime now = LocalDateTime.now();
        if (postRepository.findFirstByCreatedTimeAfterOrderByCreatedTimeDesc(now.minusMinutes(CREATE_POST_INTERVAL_MINUTES)).isPresent()) {
            throw new RuntimeException("Cannot create post within " + CREATE_POST_INTERVAL_MINUTES + " minutes of previous post creation.");
        }
        post.setCreatedTime(now);
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }
}


 */