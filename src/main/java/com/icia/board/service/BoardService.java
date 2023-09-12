package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardDTO detail(Long id) {
        return boardRepository.detail(id);
    }

//    public boolean save(BoardDTO boardDTO) {
//        int result = boardRepository.save(boardDTO);
//        if (result > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardRepository.list();
    }


    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }


    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(BoardDTO boardDTO) {
        boardRepository.delete(boardDTO);
    }
}
