package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void save(BoardDTO boardDTO) throws IOException {
        /*
            - 파일 있다
                1. fileAttached=1 board_table에 저장 후 id값 받아오기
                2. 파일원본 이름 가져오기
                3. 저장용 이름 만들기
                4. 파일 저장용 폴더에 저장 처리
                5. board_file_table에 관련 정보 저장

            - 파일 없다
                fileAttached=0 나머지는 기존방식과 동일
         */
        if (boardDTO.getBoardFile().get(0).isEmpty()) { // 파일인덱스의 0번이 비어있는가를 확인
            // 파일 없다
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        } else {
            // 파일 있다
            boardDTO.setFileAttached(1);
            // 게시글 저장 후 id 값 활용을 위한 리턴 받음
            BoardDTO saveBoard = boardRepository.save(boardDTO);
            // 파일이 여러개 있으니 반복문으로 파일 하나씩 꺼내서 저장 처리
            for (MultipartFile boardFile : boardDTO.getBoardFile()) {
                // 파일만 따로 가져오기
                // MultipartFile boardFile = boardDTO.getBoardFile()
                // 파일 이름 가져오기
                String originalFilename = boardFile.getOriginalFilename();
                System.out.println("originalFilename = " + originalFilename);
                // 저장용 이름 만들기
                System.out.println(System.currentTimeMillis());
                String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
                System.out.println("storedFileName = " + storedFileName);
                // baordFileDTO
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFileName(originalFilename);
                boardFileDTO.setStoredFileName(storedFileName);
                boardFileDTO.setBoardId(saveBoard.getId());
                // 파일 저장용 폴더에 파일 저정 처리
                String savePath = "D:\\spring_img\\" + storedFileName;
                boardFile.transferTo(new File(savePath));
                // board_file_table 저장 처리
                boardRepository.saveFile(boardFileDTO);
            }
        }
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

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.fildFile(id);
    }
}
