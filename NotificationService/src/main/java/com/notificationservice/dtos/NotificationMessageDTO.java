package com.notificationservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessageDTO {
    private String subject;
    private String from;
    private String to;
    private Long number;
    private String body;
}
