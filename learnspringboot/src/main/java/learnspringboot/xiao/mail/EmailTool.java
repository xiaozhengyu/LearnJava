package learnspringboot.xiao.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author xzy
 * @date 2019-11-19 15:17
 * 说明：发送邮件
 */
@Component
public class EmailTool {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail() {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("xzy1415841836@163.com");
            helper.setTo("zhengyupython@qq.com");
            helper.setSubject("标题：发送Html内容");

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(stringBuffer.toString(), true);

            /**
             * 附件
             */
            FileSystemResource fileSystemResource = new FileSystemResource(new File("D:\\Pictures\\卡通动漫\\2019年11月8日 (8).jpg"));
            helper.addAttachment("附加图片.jpg",fileSystemResource);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
