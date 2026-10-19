package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DictionaryServlet", urlPatterns = {"/translate"})
public class DictionaryServlet extends HttpServlet {
    private static final Map<String, String> DICTIONARY = Map.of(
            "hello", "Xin chào",
            "how", "Thế nào",
            "book", "Quyển sách",
            "computer", "Máy tính",
            "student", "Sinh viên"
    );

    private static String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String word = request.getParameter("word");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='vi'><head><meta charset='UTF-8'><title>Kết quả tra cứu</title></head>");
            out.println("<body style='font-family:Arial,sans-serif;text-align:center;margin-top:100px'>");

            if (word == null || word.trim().isEmpty()) {
                out.println("<h2 style='color:orange'>Vui lòng nhập từ khóa hợp lệ!</h2>");
            } else {
                String cleaned = word.trim();
                String meaning = DICTIONARY.get(cleaned.toLowerCase(java.util.Locale.ROOT));
                if (meaning != null) {
                    out.println("<h2 style='color:#1b2a7a'>Từ khóa: " + escapeHtml(cleaned) + "</h2>");
                    out.println("<h3 style='color:#27ae60'>Nghĩa tiếng Việt: " + meaning + "</h3>");
                } else {
                    out.println("<h2 style='color:red'>Không tìm thấy từ: " + escapeHtml(cleaned) + "</h2>");
                }
            }
            out.println("<p><a href='index.jsp'>Quay lại</a></p>");
            out.println("</body></html>");
        }
    }
}
