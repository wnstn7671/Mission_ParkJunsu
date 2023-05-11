package com.ll.gramgram.base.initData;

import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import com.ll.gramgram.boundedContext.likeablePerson.service.LikeablePersonService;
import com.ll.gramgram.boundedContext.member.entity.Member;
import com.ll.gramgram.boundedContext.member.service.MemberService;
import com.ll.gramgram.standard.util.Ut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Configuration
@Profile({"dev", "test"})
public class NotProd {
    @Value("${custom.security.oauth2.client.registration.kakao.devUserOauthId}")
    private String kakaoDevUserOAuthId;

    @Value("${custom.security.oauth2.client.registration.naver.devUserOauthId}")
    private String naverDevUserOAuthId;

    @Value("${custom.security.oauth2.client.registration.google.devUserOauthId}")
    private String googleDevUserOAuthId;

    @Value("${custom.security.oauth2.client.registration.facebook.devUserOauthId}")
    private String facebookDevUserOAuthId;

    @Bean
    CommandLineRunner initData(
            MemberService memberService,
            InstaMemberService instaMemberService,
            LikeablePersonService likeablePersonService
    ) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) throws Exception {
                Member memberAdmin = memberService.join("admin", "1234").getData();
                Member memberUser1 = memberService.join("user1", "1234").getData();
                Member memberUser2 = memberService.join("user2", "1234").getData();
                Member memberUser3 = memberService.join("user3", "1234").getData();
                Member memberUser4 = memberService.join("user4", "1234").getData();
                Member memberUser5 = memberService.join("user5", "1234").getData();

                Member memberUser6ByKakao = memberService.whenSocialLogin("KAKAO", "KAKAO__2733146708").getData();
                Member memberUser7ByGoogle = memberService.whenSocialLogin("GOOGLE", "GOOGLE__118023669136115689012").getData();
                Member memberUser8ByNaver = memberService.whenSocialLogin("NAVER", "NAVER__aViIttzUU5aqIiTSzclnPu97-WfTv8HlNHTa8IXkNgU").getData();
                Member memberUser9ByFacebook = memberService.whenSocialLogin("FACEBOOK", "FACEBOOK__3399782486904608").getData();

                instaMemberService.connect(memberUser2, "insta_user2", "M");
                instaMemberService.connect(memberUser3, "insta_user3", "W");
                instaMemberService.connect(memberUser4, "insta_user4", "M");
                instaMemberService.connect(memberUser5, "insta_user5", "W");
                instaMemberService.connect(memberUser6ByKakao, "insta_user6", "M");
                instaMemberService.connect(memberUser7ByGoogle, "insta_user7", "W");
                instaMemberService.connect(memberUser8ByNaver, "insta_user8", "M");
                instaMemberService.connect(memberUser9ByFacebook, "insta_user9", "W");


                // 원활한 테스트와 개발을 위해서 자동으로 만들어지는 호감이 삭제, 수정이 가능하도록 쿨타임해제
                LikeablePerson likeablePersonToInstaUser4 = likeablePersonService.like(memberUser3, "insta_user4", 1).getData();
                Ut.reflection.setFieldValue(likeablePersonToInstaUser4, "modifyUnlockDate", LocalDateTime.now().minusSeconds(1));
                LikeablePerson likeablePersonToInstaUser100 = likeablePersonService.like(memberUser3, "insta_user100", 2).getData();
                Ut.reflection.setFieldValue(likeablePersonToInstaUser100, "modifyUnlockDate", LocalDateTime.now().minusSeconds(1));

                likeablePersonService.like(memberUser3, "insta_user_abcd", 2).getData();


                LikeablePerson likeablePersonToInstaUser5 = likeablePersonService.like(memberUser2, "insta_user5", 2).getData();	                likeablePersonService.like(memberUser2, "insta_user5", 2).getData();


                LikeablePerson likeablePersonToInstaUser4_2 = likeablePersonService.like(memberUser2, "insta_user4", 2).getData();	                likeablePersonService.like(memberUser2, "insta_user4", 2).getData();
                LikeablePerson likeablePersonToInstaUser4_3 = likeablePersonService.like(memberUser5, "insta_user4", 3).getData();	                likeablePersonService.like(memberUser5, "insta_user4", 3).getData();
                LikeablePerson likeablePersonToInstaUser4_4 = likeablePersonService.like(memberUser6ByKakao, "insta_user4", 2).getData();	                likeablePersonService.like(memberUser6ByKakao, "insta_user4", 2).getData();
                LikeablePerson likeablePersonToInstaUser4_5 = likeablePersonService.like(memberUser7ByGoogle, "insta_user4", 1).getData();	                likeablePersonService.like(memberUser7ByGoogle, "insta_user4", 1).getData();
                LikeablePerson likeablePersonToInstaUser4_6 = likeablePersonService.like(memberUser8ByNaver, "insta_user4", 2).getData();	                likeablePersonService.like(memberUser8ByNaver, "insta_user4", 2).getData();
                LikeablePerson likeablePersonToInstaUser4_7 = likeablePersonService.like(memberUser9ByFacebook, "insta_user4", 3).getData();	                likeablePersonService.like(memberUser9ByFacebook, "insta_user4", 3).getData();

                likeablePersonService.like(memberUser2, "insta_user6", 2).getData();
                likeablePersonService.like(memberUser3, "insta_user6", 3).getData();
                likeablePersonService.like(memberUser6ByKakao, "insta_user6", 2).getData();
                likeablePersonService.like(memberUser7ByGoogle, "insta_user6", 1).getData();

                likeablePersonService.like(memberUser2, "insta_user7", 2).getData();
                likeablePersonService.like(memberUser3, "insta_user7", 3).getData();
                likeablePersonService.like(memberUser6ByKakao, "insta_user7", 2).getData();

                likeablePersonService.like(memberUser2, "insta_user8", 2).getData();
                likeablePersonService.like(memberUser3, "insta_user8", 3).getData();

                likeablePersonService.like(memberUser2, "insta_user9", 2).getData();
            }
        };
    }
}
