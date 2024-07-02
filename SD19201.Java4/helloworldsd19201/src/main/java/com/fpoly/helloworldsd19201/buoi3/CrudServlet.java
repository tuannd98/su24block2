package com.fpoly.helloworldsd19201.buoi3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CrudServlet", value = {
        "/crud/trang-chu",
        "/crud/them",
        "/crud/chi-tiet",
        "/crud/xoa"
})
public class CrudServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("trang-chu")) {
            this.trangChu(request, response);
        } else if(uri.contains("xoa")) {
            System.out.println("ban dang xoa cai gi day");
        }
    }

    private void trangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi3/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usr = req.getParameter("usr");
        String quocGia = req.getParameter("quocGia");
        String gioiTinh = req.getParameter("gioiTinh");
        boolean docThan = req.getParameter("docThan") != null;

        req.setAttribute("usr", usr);
        req.setAttribute("quocGia", quocGia);
        req.setAttribute("gioiTinh", gioiTinh);
        req.setAttribute("docThan", docThan);

        req.getRequestDispatcher("/buoi3/ket-qua.jsp").forward(req, resp);
    }
}
