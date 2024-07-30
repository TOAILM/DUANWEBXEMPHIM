package com.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.model.Videos;
import com.utils.JpaUtils;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.VideoDAO;
import com.entity.clipEntity;
import com.model.Videos;

@WebServlet({ "/adminVideoManage/index", "/adminVideoManage/create", "/adminVideoManage/update",
		"/adminVideoManage/delete", "/adminVideoManage/edit/*", "/adminVideoManage/delete/*", "/adminVideoManage/reset",
		"/adminVideoManage/import", "/adminVideoManage/export" })
public class adminVideoManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		Videos video = null;
		if (uri.contains("edit")) {
			if (req.getParameter("id") != null) {
				VideoDAO dao = new VideoDAO();
				video = dao.findById(req.getParameter("id"));
				req.setAttribute("video", video);
			}
		} else if (uri.contains("delete")) {
			if (req.getParameter("id") != null) {
				VideoDAO dao = new VideoDAO();
				dao.remove(req.getParameter("id"));
				req.setAttribute("message", "Xóa thành công");
			}
			video = null;
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/adminVideoManage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI().toString();
		req.setCharacterEncoding("utf-8");
		Videos video = new Videos();
		if (uri.contains("create")) {
			create(req, resp);
		} else if (uri.contains("update")) {
			update(req, resp);
		} else if (uri.contains("delete")) {
			delete(req, resp);
		} else if (uri.contains("reset")) {
			req.setAttribute("video", new Videos());
		} else if (uri.contains("import")) {
			importExcel(req, resp);
		} else if (uri.contains("export")) {
			exportExcel(req, resp);
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/adminVideoManage.jsp").forward(req, resp);
	}

	protected void importExcel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		resp.setHeader("Content-Disposition", "attachment; filename=videos.xlsx");

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Videos");

			EntityManager em = JpaUtils.getEntityManager();
			List<Videos> videos = findAllVideos(em);

			// Tạo dòng tiêu đề
			Row headerRow = sheet.createRow(0);
			String[] columns = { "ID", "Title", "Poster", "Description", "Active", "Premium", "Views", "Link" };
			for (int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
			}

			// Điền dữ liệu vào các dòng
			int rowNum = 1;
			for (Videos video : videos) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(video.getId());
				row.createCell(1).setCellValue(video.getTitle());
				row.createCell(2).setCellValue(video.getPoster());
				row.createCell(3).setCellValue(video.getDescription());
				row.createCell(4).setCellValue(video.getActive());
				row.createCell(5).setCellValue(video.getPremium());
				row.createCell(6).setCellValue(video.getViews());
				row.createCell(7).setCellValue(video.getLink());
			}

			// Đường dẫn tệp Excel
			String excelFilePath = "D:/videos.xlsx";

			// Ghi Workbook vào tệp Excel
			try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
				workbook.write(outputStream);
			}

			// Gửi tệp Excel đến phản hồi
			try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					resp.getOutputStream().write(buffer, 0, bytesRead);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void exportExcel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String excelFilePath = "D:/videos.xlsx";
		// Đường dẫn này phải thay đổi theo đường dẫn trong file excel của bạn

		try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				Workbook workbook = new XSSFWorkbook(inputStream)) {

			EntityManager entityManager = JpaUtils.getEntityManager();
			// Đoạn này sẽ được thay đổi theo JPA của bạn, đảm bảo rằng phương thức
			// JpaUtils.getEntityManager() trả về EntityManager đúng

			entityManager.getTransaction().begin();

			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);
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
//				String activeValue = row.getCell(4).getStringCellValue().trim();
//				boolean isActive = activeValue.equalsIgnoreCase("TRUE") || activeValue.equals("1");
//				video.setActive(isActive);
				video.setPremium(row.getCell(5).getBooleanCellValue());
//				String premiumValue = row.getCell(5).getStringCellValue().trim();
//				boolean isPremium = activeValue.equalsIgnoreCase("TRUE") || activeValue.equals("1");
//				video.setActive(isPremium);
				video.setViews((int) row.getCell(6).getNumericCellValue());
//				Cell cell = row.getCell(6);
//				 if (cell.getCellType() == CellType.STRING) {
//				        try {
//				            video.setViews(Integer.parseInt(cell.getStringCellValue()));
//				        } catch (NumberFormatException e) {
//				            // Xử lý ngoại lệ nếu giá trị không thể chuyển đổi sang số
//				        }
//				    } else if (cell.getCellType() == CellType.NUMERIC) {
//				        video.setViews((int) cell.getNumericCellValue());
//				    }

				video.setLink(row.getCell(7).getStringCellValue());
				// Đoạn này sẽ được điều chỉnh tùy thuộc vào cấu trúc của database và file video
				// của bạn

				entityManager.persist(video);
			}

			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Data imported successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Videos video = new Videos();
			VideoDAO dao = new VideoDAO();
			BeanUtils.populate(video, req.getParameterMap());
			dao.create(video);
			req.setAttribute("message", "Create Success!");
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("error_id", "Error : " + ex.getMessage());
		}
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Videos video = new Videos();
			BeanUtils.populate(video, req.getParameterMap());

			// Kiểm tra nếu ID đã được thiết lập
			if (video.getId() != null) {
				VideoDAO dao = new VideoDAO();
				dao.update(video);
				req.setAttribute("message", "Update success!");
			} else {
				req.setAttribute("error_id", "Error: ID is not provided.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("error_id", "Error : " + ex.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Videos video = new Videos();
			BeanUtils.populate(video, req.getParameterMap());
			if (video.getId() != null) {
				VideoDAO dao = new VideoDAO();
				dao.remove(video.getId());
			}
			req.setAttribute("message", "Delete success!");
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("error_id", "Error : " + ex.getMessage());
		}
	}

	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> items = dao.findAll();
			req.setAttribute("items", items);
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("error_id", "Error : " + ex.getMessage());
		}
	}

	private List<Videos> findAllVideos(EntityManager em) {
		String jpql = "Select o from Videos o";
		TypedQuery<Videos> query = em.createQuery(jpql, Videos.class);
		List<Videos> list = query.getResultList();
		return list;
	}
}
