package com.codedefnotfound.userregistration.service;

import com.codedefnotfound.userregistration.model.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

@Service
public class ActivationService {

    @Autowired
    private JavaMailSender emailSender;

    private STGroupFile templateGroup = new STGroupFile("resources/main/templates/mail/activation.stg");

    public void sendMail(NewUser newUser) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@codedefnotfound.com");
        message.setTo(newUser.getEmail());
        message.setSubject(
                buildSubject(newUser)
        );
        message.setText(
                buildBody(newUser)
        );

        emailSender.send(message);
    }

    public void sendOtp(NewUser newUser) {

    }

    private String buildSubject(NewUser newUser) {
        ST template = templateGroup.getInstanceOf("subject");
        template.add("username", newUser.getUsername());

        return template.render();
    }

    private String buildBody(NewUser newUser) {
        ST template = templateGroup.getInstanceOf("body");
        template.add("username", newUser.getUsername());

        return template.render();
    }
}
