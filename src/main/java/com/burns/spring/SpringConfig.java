package com.burns.spring;

import com.burns.spring.repository.JDBCMemberRepository;
import com.burns.spring.repository.MemberRepository;
import com.burns.spring.repository.MemoryMemberRepository;
import com.burns.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        //return new MemoryMemberRepository();
        return new JDBCMemberRepository(dataSource);
    }

}
