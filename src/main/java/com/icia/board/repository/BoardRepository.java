package com.icia.board.repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    //    public int save(BoardDTO boardDTO) {
//        return sql.insert("Board.save", boardDTO);
//    }
    public BoardDTO save(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("Board.save", boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO);
        return boardDTO;
    }

    public List<BoardDTO> list() {
        return sql.selectList("Board.list");
    }

    public BoardDTO detail(Long id) {
        return sql.selectOne("Board.detail", id);
    }


    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }


    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void delete(BoardDTO boardDTO) {
        sql.delete("Board.delete", boardDTO);
    }

    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("Board.saveFile", boardFileDTO);
    }

    public BoardFileDTO fildFile(Long boardId) {
        return sql.selectOne("Board.findFile", boardId);
    }
}
