package com.jonet.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jonet.demo.entity.BatchEntity;
import com.jonet.demo.entity.DataRows;
import com.jonet.demo.repository.BatchRepository;
import com.jonet.demo.repository.DataRowRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {
	private final BatchRepository batchRepository;
	private final DataRowRepository dataRowRepository;

	public void importExcel(MultipartFile file) {
		BatchEntity batch = batchRepository.save(BatchEntity.builder()
				.batchCode("BATCH_" + UUID.randomUUID().toString()).importedBy("ADMIN").status("PENDING").build());
		List<DataRows> dataRows = new ArrayList<DataRows>();
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue; // Bỏ qua dòng rỗng

				// Đọc dữ liệu từng ô (Cần check null để tránh NullPointerException)
				Cell employeeCell = row.getCell(0);
				Cell nameCell = row.getCell(1);
				Cell departmentCell = row.getCell(2);
				Cell salaryCell = row.getCell(3);

				// Map vào object DataRows (hoặc Entity tương ứng của bạn)
				DataRows dataRow = DataRows.builder().batch(batch).fullName(nameCell.getStringCellValue())
						.department(departmentCell.getStringCellValue())
						.employeeCode(employeeCell.getStringCellValue())
						.salary(BigDecimal.valueOf(salaryCell.getNumericCellValue())).build();

				dataRows.add(dataRow);
			}
			dataRowRepository.saveAll(dataRows);
		} catch (IOException e) {
			batch.setStatus("FAILED");
		    batchRepository.save(batch);
		    e.printStackTrace();
		}
	}
	
	public void exportExcel(HttpServletResponse response, String fileName, UUID id) {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");// Nói với browser
																										// rằng đây là
																										// file .xlsx
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName); // Yêu cầu browser tự động tải
																						// file về thay vì hiển thị trên
																						// trang web, và đặt tên file.
		try {
			Workbook workbook = new XSSFWorkbook(); // tạo một excel
			Sheet sheet = workbook.createSheet("Employee"); //tạo một trang tính trong file excel
			Row rowTitle = sheet.createRow(0); //tạo một hàng ở dòng đầu tiên trong file excel
			String[] headers = { "Mã nhân viên", "Họ và tên", "Phòng ban", "Lương" };
			for (int i = 0; i < headers.length; i++) {
				Cell cell = rowTitle.createCell(i); // tạo các ô ở dòng đầu tiên
				cell.setCellValue(headers[i]); //gán data vào các ô đã tạo
			}
			BatchEntity batch = batchRepository.findById(id).orElseThrow(null);
			int rowNum = 1;
			for (DataRows dataRow : batch.getDataRows()) {
				Row row = sheet.createRow(rowNum++);

				// Ghi chuỗi bình thường
				row.createCell(0).setCellValue(dataRow.getEmployeeCode());
				row.createCell(1).setCellValue(dataRow.getFullName());
				row.createCell(2).setCellValue(dataRow.getDepartment());

				// 3. Xử lý ghi số cho cột Lương (Tránh lỗi Number Stored as Text)
				Cell salaryCell = row.createCell(3);
				if (dataRow.getSalary() != null) {
					// Giả sử getSalary() trả về Double hoặc BigDecimal
					salaryCell.setCellValue(dataRow.getSalary().doubleValue());
				} else {
					salaryCell.setCellValue(0); // hoặc để trống tùy bạn
				}
			}
			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
		}
	}
}
