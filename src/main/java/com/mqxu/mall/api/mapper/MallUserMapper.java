package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author mqxu
 * @description: MallUserMapper
 */
public interface MallUserMapper {

    /**
     * 根据主键删除记录
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增用户
     *
     * @param mallUser 入参
     * @return 受影响的记录行数
     */
    int insert(MallUser mallUser);

    /**
     * 选择性保存数据——新增用户
     *
     * @param mallUser 入参
     * @return 受影响的记录行数
     */
    int insertSelective(MallUser mallUser);

    /**
     * 根据主键查询记录
     *
     * @param id 主键
     * @return MallUser
     */
    MallUser selectByPrimaryKey(Long id);

    /**
     * 选择性更新
     *
     * @param mallUser 入参
     * @return int
     */
    int updateByPrimaryKeySelective(MallUser mallUser);

    /**
     * 更新用户信息
     *
     * @param mallUser 入参
     * @return int
     */
    int updateByPrimaryKey(MallUser mallUser);

    /**
     * 根据登录名查询用户
     *
     * @param loginName 登录名
     * @return 用户对象
     */
    MallUser selectByLoginName(String loginName);

    /**
     * 根据登录名和密码查询用户
     *
     * @param loginName 登录名
     * @param password  密码
     * @return 用户对象
     */
    MallUser selectByLoginNameAndPasswd(@Param("loginName") String loginName, @Param("password") String password);

}




