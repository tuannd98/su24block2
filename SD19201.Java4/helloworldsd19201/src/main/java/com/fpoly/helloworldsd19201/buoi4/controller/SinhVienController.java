package com.fpoly.helloworldsd19201.buoi4.controller;

import com.fpoly.helloworldsd19201.buoi4.entity.SinhVien;
import com.fpoly.helloworldsd19201.buoi4.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", // Get
        "/sinh-vien/view-add", // Get
        "/sinh-vien/view-update", // Get
        "/sinh-vien/delete", // Get
        "/sinh-vien/detail", // Get
        "/sinh-vien/add", // Post
        "/sinh-vien/update" // Post
})
public class SinhVienController extends HttpServlet {
    SinhVienService svService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-add")) {
            viewAdd(req, resp);
        } else if(uri.contains("view-update")) {

        } else if(uri.contains("delete")) {

        } else if(uri.contains("detail")) {

        }
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/buoi4/add.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SinhVien> danhSach = svService.getAll();
        req.setAttribute("danhSach", danhSach);
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSinhVien(req, resp);
        } else if(uri.contains("update")) {

        }
    }

    private void addSinhVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String maSinhVien = req.getParameter("maSinhVien");
        String ten = req.getParameter("ten");
        int tuoi = Integer.valueOf(req.getParameter("tuoi"));
        boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        SinhVien sv = new SinhVien(maSinhVien, ten, tuoi, gioiTinh);
        svService.addSinhVien(sv);
        resp.sendRedirect("/sinh-vien/hien-thi");
    }
}
