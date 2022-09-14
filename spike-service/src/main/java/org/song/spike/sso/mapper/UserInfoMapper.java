package org.song.spike.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.song.spike.sso.entity.SysUser;
import org.song.spike.sso.entity.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
