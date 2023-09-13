package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;
import com.icia.board.service.CommentService;
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
    @Autowired
    private CommentService commentService;

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


    @GetMapping("/list")
    public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       Model model) {
        List<BoardDTO> boardDTOList = boardService.list();
        System.out.println("boardDTOList : " + boardDTOList);
        model.addAttribute("boardList", boardDTOList);

        PageDTO pageDTO = boardService.pageNumber(page);
        model.addAttribute("paging", pageDTO);
        return "boardPages/boardList";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q") String q,
                         @RequestParam("type") String type,
                         Model model) {
        List<BoardDTO> boardDTOList = boardService.searchList(q, type);
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }


    @GetMapping
    public String detial(@RequestParam("id") Long id, Model model) {
        //조회수 처리
        boardService.updateHits(id);
        //데이터 가져오기
        BoardDTO boardDTO = boardService.detail(id);
//        System.out.println("boardTitle" + id);
//        System.out.println("boardDTO : "+boardDTO);
        model.addAttribute("board", boardDTO);
        // 첨부된 파일이 있다면 파일 가져오기
        if (boardDTO.getFileAttached() == 1) {
            List<BoardFileDTO> boardFileDTOList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileDTOList);
        }

        List<CommentDTO> commentDTOList = commentService.list(id);
        if (commentDTOList.size() == 0) {
            model.addAttribute("commentList", null);
        } else {
            model.addAttribute("commentList", commentDTOList);
        }

        return "boardPages/boardDetail";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);

        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        BoardDTO dto = boardService.detail(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardPages/boardDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);

        return "boardPages/deleteCheck";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute BoardDTO boardDTO) {
        boardService.delete(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/sample")
    public String sampleData() {
        for (int i = 1; i <= 20; i++) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardWriter("aa");
            boardDTO.setBoardTitle("title" + i);
            boardDTO.setBoardContents("contents" + i);
            boardDTO.setBoardPass("pass" + i);
            boardService.sampleData(boardDTO);
        }
        return "redirect:/board/list";
    }

}
