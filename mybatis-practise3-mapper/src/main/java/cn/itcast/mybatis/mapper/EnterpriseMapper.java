package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.Enterprise;

public interface EnterpriseMapper {
    Enterprise selectOneById(Integer id);

    Enterprise selectEnterpriseAndUsersById(Integer id);

    Enterprise selectEnterpriseAndUsersByIdStep(Integer id);
}
