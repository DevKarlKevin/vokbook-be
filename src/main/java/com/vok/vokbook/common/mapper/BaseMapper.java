package com.vok.vokbook.common.mapper;

import java.util.List;

public interface BaseMapper<M, DTO> {

    DTO toDTO(M model);

    List<DTO> toDTO(List<M> model);
}
