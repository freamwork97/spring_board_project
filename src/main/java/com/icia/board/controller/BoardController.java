package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@RequestMapping("/board")
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "boardPages/boardSave";
    }

    @PostMapping("/save")
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
    public String string(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board/";
    }


    @GetMapping("/")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.list();
        System.out.println("boardDTOList : " + boardDTOList);
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }

    @GetMapping
    public String detial(@RequestParam("id") Long id, Model model) {
        //조회수 처리
        boardService.updateHits(id);
        //데이터 가져오기
        BoardDTO boardDTO = boardService.detail(id);
        System.out.println("boardTitle" + id);
        System.out.println("boardDTO : "+boardDTO);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardDetail";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id,Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);

        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        BoardDTO dto = boardService.detail(boardDTO.getId());
        model.addAttribute("board",dto);
        return "boardPages/boardDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id,Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);

        return "boardPages/deleteCheck";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute BoardDTO boardDTO) {
        boardService.delete(boardDTO);
        return "redirect:/board/";
    }

}
