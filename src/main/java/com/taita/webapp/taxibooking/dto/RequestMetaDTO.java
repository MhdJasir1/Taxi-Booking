package com.taita.webapp.taxibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMetaDTO {
    private int adminUserId;
    private String username;
}
