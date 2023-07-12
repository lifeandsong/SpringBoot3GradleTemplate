package org.swmaestro.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.swmaestro.demo.mapper.MemberMapper;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.util.Sha512Encryptor;

class MemberServiceTest {

    @Mock
    private MemberMapper memberMapper;

    @Spy
    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void create() {
//    }

    @Test
    @DisplayName("회원 1명의 정보 조회 테스트")
    void read() {

        String testId = "test";

        // given
        Member givenMember = memberMapper.read(testId);
        Member testMember = getTestMember();
        given(givenMember).willReturn(testMember);

        // when
        Member whenMember = memberService.read(testId);

        // then
        then(memberMapper).should().read(testId);
        then(memberService).should().read(testId);

        Assertions.assertThat(whenMember.getId()).isEqualTo(testMember.getId());
        Assertions.assertThat(whenMember.getPassword()).isEqualTo(testMember.getPassword());
        Assertions.assertThat(whenMember.getName()).isEqualTo(testMember.getName());
        Assertions.assertThat(whenMember.getEmail()).isEqualTo(testMember.getEmail());
        Assertions.assertThat(whenMember.getPhone()).isEqualTo(testMember.getPhone());
    }

//    @Test
//    void list() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }

    private Member getTestMember() {
        Sha512Encryptor sha512 = new Sha512Encryptor();
        String password = sha512.encrypt("test1234");

        Member member = new Member();
        member.setId("test");
        member.setPassword(password);
        member.setName("테스터");
        member.setEmail("test@company.com");
        member.setPhone("010-2345-6789");
        return member;
    }

}