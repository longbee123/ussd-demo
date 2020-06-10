package com.example.ussd.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ussd
 *
 * @author longtcs
 * @created_at 09/06/2020 - 16:35
 * @created_by longtcs
 * @since 09/06/2020
 */
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponse {
    private String status;
    private String menu;

    @Override
    public String toString() {
        return status+" "+menu;

    }
}
