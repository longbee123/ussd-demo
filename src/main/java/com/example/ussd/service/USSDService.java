package com.example.ussd.service;

import com.example.ussd.constants.USSDActive;
import com.example.ussd.request.MenuResponse;
import com.example.ussd.request.MessagesRequest;
import org.springframework.stereotype.Service;

/**
 * ussd
 *
 * @author longtcs
 * @created_at 09/06/2020 - 15:07
 * @created_by longtcs
 * @since 09/06/2020
 */
@Service
public class USSDService {
    private MenuResponse menuResponse;
    private String message;
    private String[] input;
    private int status;
    public String handleUSSDService(MessagesRequest messagesRequest){
        input = messagesRequest.getText().split("\\*");
        for(int i = 0; i < input.length ; i++){
            if(messagesRequest.getText().trim().isEmpty()){
                status = USSDActive.CHECK_MENU;
            }
            // check account after check menu
            if(status == USSDActive.CHECK_ACCOUNT) {
                checkAccount(i);
                continue;
            }
            // check menu
            if(status == USSDActive.CHECK_MENU) {
               checkMenu(i);
                continue;
            }
            // check draw
            if(status == USSDActive.CHECK_DRAW){
                checkDraw(i);
                continue;
            }

        }
            return  message;
    }

    private String showMenu(){
        menuResponse = new MenuResponse("CON" , "Xem số dư tài khoản \n 1. Nhập số tài khoản \n 2. Kết thúc");
        return menuResponse.toString();
    }
    private void checkAccount(int i){
        switch(input[i].trim()) {
            case "123123":
                menuResponse = new MenuResponse("CON" , "Số dư trong tài khoản còn 200.000 vnd \n 1. Rút tiền \n 2. Kết thúc \n 3. Quay lại");
                message = menuResponse.toString();
                status = 2;
                break;
            case "0":
                message = showMenu();
                status = 0;
                break;
            default:
                menuResponse = new MenuResponse("CON" , "Số dư tài khoản không đúng");
                message = menuResponse.toString();
                break;
        }
    }
    private void checkMenu(int i){
        switch(input[i].trim()) {
            case"1":
                menuResponse = new MenuResponse("CON" , "Vui lòng nhập số tài khoản \n 0. quay lại");
                message = menuResponse.toString();
                status = 1;
                break;
            case"2":
                menuResponse = new MenuResponse("END" , "Kết thúc");
                message = menuResponse.toString();
                return;
            default:
                message = showMenu();
                break;
        }
    }
    private void checkDraw(int i){
        switch(input[i].trim()){
            case "1":
                menuResponse = new MenuResponse("END" , "rút tiền thành công");
                message = menuResponse.toString();
                return;
            case "2":
                menuResponse = new MenuResponse("END" , "Kết thúc");
                message = menuResponse.toString();
                return;
            case "3":
                 menuResponse = new MenuResponse("CON" , "Vui lòng nhập số tài khoản \n 0. quay lại");
                 message = menuResponse.toString();
                 status = 1;
                 break;
        }
    }

}
