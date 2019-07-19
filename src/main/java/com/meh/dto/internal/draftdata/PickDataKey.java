package com.meh.dto.internal.draftdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickDataKey {
    private String drafId;
    private int pack;
    private int pick;
}
