package com.burns.spring;

import com.burns.spring.repository.MemberRepository;
import com.burns.spring.repository.MemoryMemberRepository;
import com.burns.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig
{

    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }

}
