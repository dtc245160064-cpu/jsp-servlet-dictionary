# JSP Servlet Dictionary

Bài thực hành từ điển Anh–Việt đơn giản bằng JSP, Servlet, Maven và Tomcat 10.1+.

## Chức năng

- Nhập từ tiếng Anh vào form tại `index.jsp`.
- Gửi POST tới endpoint `/translate`.
- Tra cứu trong Map: hello, how, book, computer, student.
- Hiển thị nghĩa tiếng Việt hoặc thông báo không tìm thấy từ.

## Chạy dự án

Yêu cầu Java 17+, Maven và Apache Tomcat 10.1+.

```bash
mvn clean package
```

Chép `target/jsp-servlet-dictionary.war` vào thư mục `webapps` của Tomcat, khởi động Tomcat, sau đó truy cập:

http://localhost:8080/jsp-servlet-dictionary/

## Cấu trúc

- `pom.xml`: cấu hình Maven WAR và Jakarta Servlet/JSP.
- `src/main/java/com/codegym/DictionaryServlet.java`: xử lý tra cứu.
- `src/main/webapp/index.jsp`: form từ điển.
- `src/main/webapp/WEB-INF/web.xml`: cấu hình web.
