package org.exampleUtils01.htmlUtils;



import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;


import org.xhtmlrenderer.resource.XMLResource;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 *
 * @author zhangyf
 * @date 2025/6/6 14:44
 */

public class HtmlToObjectUtils {

    //获取HTML
    @Test
    public void testGet() throws Exception {
        //1.创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2. 创建HttpGet请求，并进行相关设置
        HttpGet httpGet = new HttpGet("https://test-agent.charmtrvl.com/tpl/ticket/outTicketCenter/outTicketCtrl/tkOrder/tkOrderDtPrint.html");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Mobile Safari/537.36 Edg/85.0.564.68");

        //3.发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4.判断响应状态码并获取响应数据
        if (response.getCode() == 200) { //200表示响应成功
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(html);
        }

        //5.关闭资源
        httpClient.close();
        response.close();
    }

    @Test
    public void test() {
        try {
            buildImage();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    private static void buildImage( ) throws UnsupportedEncodingException {
        //填充后的html
        // 使用符合 XHTML 规范的 HTML
        String html = getTemplate();
       // String template = getTemplate();
        // 预解析 HTML 为 Document 对象
        Document document = XMLResource.load(
                new ByteArrayInputStream(html.getBytes("UTF-8"))
        ).getDocument();

        //绘图构建器
        Java2DRenderer builder = new Java2DRenderer(document,800,-1);
        BufferedImage image = builder.getImage();
        // 保存图片到文件
        try (OutputStream os = Files.newOutputStream(Paths.get("E:/zhangyf/Downloads/ttt2.jpg"))) {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTemplate( ) {
        String str = "";
        str += "<html>";
        str += "<meta charset='utf-8'/><meta charset='text/html;charset=utf-8' />";
        str += "<table border='1' cellspacing='0' cellpadding='5'";
        str += "       style='border-collapse:collapse;width:100%;margin-bottom:20px;sans-serif;font-size:14px;'>";
        str += "  <tr>";
        str += "    <td style='font-weight:bold;text-align:center;'>航程</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>航班号</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>起飞时间</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>到达时间</td>";
        str += "  </tr>";
        str += "  <tr>";
        str += "    <td style='text-align:center;'>KUL--&gt;BKI</td>";
        str += "    <td style='text-align:center;'>AK5114</td>";
        str += "    <td style='text-align:center;'>2025-06-05 17:20</td>";
        str += "    <td style='text-align:center;'>2025-06-05 19:55</td>";
        str += "  </tr>";
        str += "</table>";
        str += "<table border='1' cellspacing='0' cellpadding='5'";
        str += "       style='border-collapse:collapse;width:100%;margin-bottom:20px;sans-serif;font-size:14px;'>";
        str += "  <tr>";
        str += "    <td style='font-weight:bold;text-align:center;'>乘机人</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>性别</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>PNR</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>大编码</td>";
        str += "    <td style='font-weight:bold;text-align:center;'>票号</td>";
        str += "  </tr>";
        str += "  <tr>";
        str += "    <td style='text-align:center;'>KHAN/MUSHTAQ</td>";
        str += "    <td style='text-align:center;'>M</td>";
        str += "    <td style='text-align:center;'>55517PA</td>";
        str += "    <td style='text-align:center;'></td>";
        str += "    <td style='text-align:center;'></td>";
        str += "  </tr>";
        str += "</table>";
        str += "</html>";



        System.out.println(str);


        return str;

    }

}
