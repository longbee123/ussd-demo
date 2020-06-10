package com.example.ussd.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ussd
 *
 * @author longtcs
 * @created_at 09/06/2020 - 15:43
 * @created_by longtcs
 * @since 09/06/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagesRequest {
    private String sessionId;
    private String phoneNumber;
    private String text;
    private String serviceCode;
}
