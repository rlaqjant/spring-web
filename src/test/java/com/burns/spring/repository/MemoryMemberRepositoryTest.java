package com.burns.spring.repository;

import com.burns.spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest
{
 MemoryMemberRepository repository = new MemoryMemberRepository();

 @AfterEach
 public void afterEach()
 {
  repository.clearStore();
 }

 @Test
 public void save()
 {
  Member member = new Member();
  member.setName("user1");

  repository.save(member);

  Member result = repository.findById(member.getId()).get();
  assertThat(member).isEqualTo(result);
 }

 @Test
 public void findByName()
 {
  Member member1 = new Member();
  member1.setName("member1");
  repository.save(member1);

  Member member2 = new Member();
  member2.setName("member2");
  repository.save(member2);

  Member result = repository.findByName("member2").get();

  assertThat(result).isEqualTo(member2);

 }

 @Test
 public void findAll()
 {
  Member member1 = new Member();
  member1.setName("member1");
  repository.save(member1);

  Member member2 = new Member();
  member2.setName("member2");
  repository.save(member2);

  Member member3 = new Member();
  member3.setName("member3");
  repository.save(member3);

  List<Member> result = repository.findAll();

  assertThat(result.size()).isEqualTo(3);

 }

}
