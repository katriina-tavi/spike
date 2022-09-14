package org.song.spike.sso.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageDTO<T> implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private T entity;
}
