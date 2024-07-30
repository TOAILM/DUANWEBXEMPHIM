package com.Servlet;
//package ô sử lại

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Videos;
import com.utils.JpaUtils;
//cái này của tui của ô đổi lại nha
import java.io.File;
import java.io.FileInputStream;
//thư viện ô sủa lại theo file pom bên ô nha
import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet("")
//link ô sửa lại
public class codeExcel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void excelToDatabase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String excelFilePath = "nhớ đổi";
//đường dẫn này ô thay đổi theo đường dẫn trong file excel của ô

		try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				Workbook workbook = new XSSFWorkbook(inputStream)) {

			EntityManager entityManager = JpaUtils.getEntityManager();
//Câu này đổi lại theo JPA của ô và câu getEntityManager() của ô là gì nhứo thay
			entityManager.getTransaction().begin();

			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				String videoId = row.getCell(0).getStringCellValue();

				// Kiểm tra xem video có tồn tại trong cơ sở dữ liệu không
				Videos existingVideo = entityManager.find(Videos.class, videoId);
				if (existingVideo != null) {
					// Bỏ qua bản ghi nếu video đã tồn tại trong cơ sở dữ liệu
					continue;
				}

				Videos video = new Videos();
				video.setId(row.getCell(0).getStringCellValue());
				video.setTitle(row.getCell(1).getStringCellValue());
				video.setPoster(row.getCell(2).getStringCellValue());
				video.setDescription(row.getCell(3).getStringCellValue());
				video.setActive(row.getCell(4).getBooleanCellValue());
				video.setPremium(row.getCell(5).getBooleanCellValue());
				video.setViews((int) row.getCell(6).getNumericCellValue());
				video.setLink(row.getCell(7).getStringCellValue());
//Mấy cái row này ô nhớ đổi lại theo database và file vidoe của ô
				entityManager.persist(video);
			}

			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Data imported successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
