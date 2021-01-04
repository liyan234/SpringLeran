package net.xdclass.xd_class.dao;

import net.xdclass.xd_class.domain.User;
import net.xdclass.xd_class.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

     List<VideoOrder> queryVideoOrderList();

     List<User> queryUserList();
}
