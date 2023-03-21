package Changzin.SpringApiPractice.repository;

import Changzin.SpringApiPractice.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Member save(Long id, Member member) {
        member.setId(id);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public Optional<Member> findByEmail(String Email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(Email))
                .findAny();
    }
    @Override
    public List<Member> findALL() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Member updateById(Long id, Member member) {
        Member findmember = findById(id).get();
        member.setId(findmember.getId());
        deleteById(findmember.getId());
        return save(member.getId(), member);
    }

    @Override
    public Member updateByEmail(String email, Member member) {
        Member findmember = findByEmail(email).get();
        member.setId(findmember.getId());
        deleteById(findmember.getId());
        return save(member.getId(), member);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public void deleteByEmail(String email) {
        store.remove(findByEmail(email).get().getId());
    }

    public void clearStore(){
        this.store.clear();
        return;
    }
}
