package com.example.pay.service;

import com.example.pay.dto.ReserveListDto;
import com.example.pay.dto.RoomListDto;
import com.example.pay.mappers.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomMapper roomMapper;

    public void setRoomAdd(RoomListDto roomListDto) {
        roomMapper.setRoomAdd(roomListDto);
    }

    public List<RoomListDto> getRoomList() {
        return roomMapper.getRoomList();
    }

    public RoomListDto getReserveRequest(String roomName) {
        return roomMapper.getReserveRequest(roomName);
    }

    public void setReserveList(ReserveListDto reserveListDto) {
        reserveListDto.setId(1);
        reserveListDto.setSettlementState(1);

        roomMapper.setReserveList(reserveListDto);
    }

    public List<ReserveListDto> getReserveList() {
        return roomMapper.getReserveList();
    }
}
