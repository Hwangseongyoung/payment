package com.example.pay.controller;

import com.example.pay.dto.CheckRoomDto;
import com.example.pay.service.CheckRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckRoomController {

    @Autowired
    CheckRoomService checkRoomService;

    @GetMapping("/checkRoomList")
    public String getCheckRoomList() {
        return "/checkRoom.html";
    }

    @GetMapping("/getRoomList")
    @ResponseBody
    public Map<String, Object> getRoomList() {
        Map<String, Object> map = new HashMap<>();
        map.put("roomList", checkRoomService.getAllRoomList());
        return map;
    }

    @PostMapping("/checkRoom")
    @ResponseBody
    public Map<String, Object> CheckRoom(@ModelAttribute CheckRoomDto checkRoomDto) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(checkRoomService.getCheckRoom(checkRoomDto));
        map.put("checkRoomList", checkRoomService.getCheckRoom(checkRoomDto));
        return map;
    }
}
