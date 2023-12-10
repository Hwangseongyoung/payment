package com.example.pay.mappers;

import com.example.pay.dto.ReserveListDto;
import com.example.pay.dto.RoomListDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Insert("insert into room_list values(null, #{roomName}, #{roomPrice}, #{roomMaxPerson}, #{roomMinPerson})")
    public void setRoomAdd(RoomListDto roomListDto);

    @Select("select * from room_list")
    public List<RoomListDto> getRoomList();

    @Select("select * from room_list where room_name = #{roomName}")
    public RoomListDto getReserveRequest(String roomName);

    @Insert("insert into reserve_list values(#{id}, #{orderNum}, #{checkin}, #{checkout}, #{person}, #{reserveEmail}, #{reserveName}, #{reserveTell}, #{payMoney}, #{roomName}, now(), #{settlementState})")
    public void setReserveList(ReserveListDto reserveListDto);

    @Select("select * from reserve_list")
    public List<ReserveListDto> getReserveList();
}
