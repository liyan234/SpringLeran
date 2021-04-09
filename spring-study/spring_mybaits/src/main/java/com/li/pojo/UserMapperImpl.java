package com.li.pojo;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    // 我们原先的都是用sqlSession 现在都是用sqlSessionTemplate
    private SqlSessionTemplate sessionTemplate;



    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<User> selectUser() {
        UserMapper mapper = sessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
