package com.connectSmart.cm.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class message {

    private String content;
    @Builder.Default
    private MessageType type=MessageType.blue;
}
