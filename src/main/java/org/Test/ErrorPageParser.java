package org.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ErrorPageParser {

    public static class ErrorInfo {
        private String createdTime;
        private String errorMessage;

        public ErrorInfo(String createdTime, String errorMessage) {
            this.createdTime = createdTime;
            this.errorMessage = errorMessage;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return "ErrorInfo{" +
                    "createdTime='" + createdTime + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }
    }

    public static ErrorInfo parseErrorPage(String html) {
        Document doc = Jsoup.parse(html);
        Elements divs = doc.getElementsByTag("div");

        String createdTime = divs.get(0).text();
        String errorMessage = divs.get(2).text();

        return new ErrorInfo(createdTime, errorMessage);
    }

    public static void main(String[] args) {
        String html = "<html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p><div id='created'>Wed Jul 10 21:02:35 CST 2024</div><div>There was an unexpected error (type=Internal Server Error, status=500).</div><div>创建人不能为空！</div></body></html>";

        ErrorInfo errorInfo = parseErrorPage(html);
        System.out.println(errorInfo);
    }
}
