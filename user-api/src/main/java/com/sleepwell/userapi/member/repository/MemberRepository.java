package com.sleepwell.userapi.member.repository;

import com.sleepwell.userapi.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long guestId);

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
}
