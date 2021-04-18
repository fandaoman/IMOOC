package com.baidu.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.baidu.common.Commons;
import com.baidu.message.SendMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FDM
 * @Date: 2021/4/17 1:05
 * @Version 1.0
 */
@RestController
public class SendMessageController {

    @PostMapping("/send/message")
    public SendSmsResponse sendMessage(String phoneNumber, String code) {
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = SendMessage.sendSms(phoneNumber, code, Commons.TEMPLATE_CODE);
        } catch (Exception e){
            e.printStackTrace();
        }
        return sendSmsResponse;
    }

}
