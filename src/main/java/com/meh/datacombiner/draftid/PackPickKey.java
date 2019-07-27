package com.meh.datacombiner.draftid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackPickKey {
    private String draftId;
    private int pack;
    private int pick;
}
