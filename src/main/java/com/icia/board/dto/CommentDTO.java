package com.icia.board.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String commentWriter;
//    private commentContents;
    private Long boardId;
//    private Timestamp commentCreatedDate;
}