package com.burns.spring.service;

import com.burns.spring.domain.Member;
import com.burns.spring.repository.MemberRepository;
import com.burns.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService
{

    /**
     * 회원가입
     * */
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    public Long join (Member member)
    {
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member)
    {
        //동명이인 금지
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }

}
