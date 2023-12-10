package com.example.pay.controller;

import com.example.pay.dto.CheckRoomDto;
import com.example.pay.dto.RequestSettleDto;
import com.example.pay.dto.ReserveListDto;
import com.example.pay.dto.RoomListDto;
import com.example.pay.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoomAddController {

    @Autowired
    RoomService roomService;

    @GetMapping("/roomAdd")
    public String getRoomAdd() {
        return "/roomAdd.html";
    }

    @PostMapping("/roomAdd")
    public String setRoomAdd(@ModelAttribute RoomListDto roomListDto) {
        roomService.setRoomAdd(roomListDto);
        return "redirect:/roomList";
    }

    @GetMapping("/roomList")
    public String getRoomList() {
        return "/roomList.html";
    }

    @GetMapping("/showRoomList")
    @ResponseBody
    public Map<String, Object> getCheckRoom() {
        Map<String, Object> map = new HashMap<>();
        List<RoomListDto> list = roomService.getRoomList();
        map.put("roomList", list);
        return map;
    }

    @GetMapping("/reserve")
    public String getRoomReserve() {
        return "/reserve.html";
    }

    @PostMapping("/reserve")
    public ModelAndView reserveRequest(@ModelAttribute CheckRoomDto checkRoomDto, ModelAndView mv) {
        RoomListDto rd = roomService.getReserveRequest(checkRoomDto.getRoomName());
        mv.addObject("roomList", rd);
        mv.addObject("reserveRequest", checkRoomDto);
        mv.setViewName("/reserve");
        return mv;
    }

    @GetMapping("/reserveList")
    public String getReserveList(Model model) {
        model.addAttribute("reserveList", roomService.getReserveList());
        return "/reserveList.html";
    }

    @PostMapping("/requestSettle")
    @ResponseBody
    public Map<String, Object> requestSettle(@ModelAttribute RequestSettleDto requestSettleDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("rs", requestSettleDto);
        return map;
    }

    @PostMapping("/settlement")
    @ResponseBody
    public Map<String, Object> setReserveList(@ModelAttribute ReserveListDto reserveListDto) {
        Map<String, Object> map = new HashMap<>();
        if(reserveListDto != null) {
            roomService.setReserveList(reserveListDto);
            map.put("msg", "success");
        }else {
            map.put("msg", "failure");
        }
        return map;
    }
}
