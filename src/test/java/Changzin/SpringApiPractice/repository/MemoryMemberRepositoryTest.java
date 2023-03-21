package Changzin.SpringApiPractice.repository;

import Changzin.SpringApiPractice.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        //when
        memberRepository.save(member1);
        //then
        Member findmember = memberRepository.findById(member1.getId()).get();
        assertThat(findmember).isEqualTo(member1);
    }
    @Test
    void findById() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        //when
        memberRepository.save(member1);
        //then
        Member findmember = memberRepository.findById(member1.getId()).get();
        assertThat(findmember).isEqualTo(member1);
    }

    @Test
    void findByEmail() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        //when
        memberRepository.save(member1);
        //then
        Member findmember = memberRepository.findByEmail(member1.getEmail()).get();
        assertThat(findmember).isEqualTo(member1);
    }

    @Test
    void findALL() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        Member member2 = new Member();
        member2.setEmail("abc@naver.com");
        member2.setPassword("1234");
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        //then
        assertThat(memberRepository.findALL().size()).isEqualTo(2);
    }

    @Test
    void updateById() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        Member member2 = new Member();
        member2.setEmail("bcd@naver.com");
        member2.setPassword("2345");
        memberRepository.save(member1);
        Long findid = member1.getId();
        //when
        memberRepository.updateById(member1.getId(), member2);
        //then
        Member Result = memberRepository.findById(findid).get();
        assertThat(Result).isEqualTo(member2);
    }

    @Test
    void updateByEmail() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        Member member2 = new Member();
        member2.setEmail("bcd@naver.com");
        member2.setPassword("2345");
        memberRepository.save(member1);
        //when
        memberRepository.updateByEmail(member1.getEmail(), member2);
        //then
        Member Result = memberRepository.findByEmail(member2.getEmail()).get();
        assertThat(Result).isEqualTo(member2);
    }

    @Test
    void deleteById() {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        Member member2 = new Member();
        member2.setEmail("bcd@naver.com");
        member2.setPassword("2345");
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        Long findId = member1.getId();
        memberRepository.deleteById(member1.getId());
        //then
        assertThat(memberRepository.findById(findId).isPresent()).isEqualTo(false);
    }

    @Test
    void deleteByEmail() {
        Member member1 = new Member();
        member1.setEmail("abc@naver.com");
        member1.setPassword("1234");
        Member member2 = new Member();
        member2.setEmail("bcd@naver.com");
        member2.setPassword("2345");
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        String findEmail = member1.getEmail();
        memberRepository.deleteByEmail(member1.getEmail());
        //then
        assertThat(memberRepository.findByEmail(findEmail).isPresent()).isEqualTo(false);
    }
}