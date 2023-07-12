package org.swmaestro.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.swmaestro.demo.model.Member;
import org.swmaestro.demo.util.Sha512Encryptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@Slf4j
class MemberMapperTest {

    @Mock
    private MemberMapper memberMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    @DisplayName("Member 등록")
//    void create() {
//
//    }

    @Test
    @DisplayName("Member 1명 정보 조회")
    void read() {

        // given
        String testId = "test";
        Member givenMember = memberMapper.read(testId);
        Member testMember = getTestMember();
        given(givenMember).willReturn(testMember);

        // when
        Member whenMember = memberMapper.read(testId);

        log.info("testMember={}", testMember);
        log.info("whenMember={}", whenMember);

        // then
        then(memberMapper).should().read(testId);
        assertThat(whenMember.getId()).isEqualTo(testId);
        assertThat(whenMember.getPassword()).isEqualTo(testMember.getPassword());
        assertThat(whenMember.getName()).isEqualTo(testMember.getName());
        assertThat(whenMember.getEmail()).isEqualTo(testMember.getEmail());
        assertThat(whenMember.getPhone()).isEqualTo(testMember.getPhone());
    }

    @Test
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