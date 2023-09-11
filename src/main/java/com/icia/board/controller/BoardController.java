package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/save")
    public String save() {
        return "boardSave";
    }

    @PostMapping("/board/save")
//    public String save(@ModelAttribute BoardDTO boardDTO) {
//        boolean result = boardService.save(boardDTO);
//        if (result) {
//            System.out.println("글작성 성공");
//            return "redirect:/list";
//        } else {
//            System.out.println("글작성 실패");
//            return "boardSave";
//        }
//    }
    public String string(@ModelAttribute BoardDTO boardDTO){
        boardService.save(boardDTO);
        return "redirect:/board/list";
    }


    @GetMapping("/board/list")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.list();
        System.out.println("boardDTOList : " + boardDTOList);
        model.addAttribute("boardList", boardDTOList);
        return "boardList";
    }

    @GetMapping("/board")
    public String detial(@RequestParam("id") int id, Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        System.out.println("boardTitle" + id);
        model.addAttribute("board", boardDTO);
        return "boardDetail";
    }

//    @GetMapping("/board/update")
//    public String update(){
//
//    }

}
