package Changzin.SpringApiPractice.repository;


import Changzin.SpringApiPractice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // Create
    Member save(Member member);
    Member save(Long id, Member member);
    // Read
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String Email);
    List<Member> findALL();

    // Update
    Member updateById(Long id, Member member);
    Member updateByEmail(String email, Member member);

    // Delete
    void deleteById(Long id);
    void deleteByEmail(String Email);

    void clearStore();
}
