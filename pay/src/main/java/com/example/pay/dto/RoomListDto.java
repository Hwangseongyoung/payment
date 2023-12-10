package com.example.pay.dto;

public class RoomListDto {
    private int roomNum;
    private String roomName;
    private int roomPrice;
    private int roomMaxPerson;
    private int roomMinPerson;

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomMaxPerson() {
        return roomMaxPerson;
    }

    public void setRoomMaxPerson(int roomMaxPerson) {
        this.roomMaxPerson = roomMaxPerson;
    }

    public int getRoomMinPerson() {
        return roomMinPerson;
    }

    public void setRoomMinPerson(int roomMinPerson) {
        this.roomMinPerson = roomMinPerson;
    }

    @Override
    public String toString() {
        return "RoomListDto{" +
                "roomNum=" + roomNum +
                ", roomName='" + roomName + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomMaxPerson=" + roomMaxPerson +
                ", roomMinPerson=" + roomMinPerson +
                '}';
    }
}
