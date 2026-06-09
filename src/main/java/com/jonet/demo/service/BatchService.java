package com.jonet.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jonet.demo.entity.BatchEntity;
import com.jonet.demo.entity.DataRows;
import com.jonet.demo.entity.ExcelMapping;
import com.jonet.demo.entity.ExcelTemplate;
import com.jonet.demo.repository.BatchRepository;
import com.jonet.demo.repository.ExcelTemplateRepository;
import com.jonet.demo.util.ExcelUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {
	private final BatchRepository batchRepository;
	private final ExcelTemplateRepository excelTemplateRepository;

	public void importExcel(MultipartFile file, String code) {
		List<DataRows> dataRows = new ArrayList<DataRows>();
		ExcelTemplate template = excelTemplateRepository.findByCode(code);
		try {
			InputStream is = file.getInputStream();
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				DataRows dataRow = new DataRows();
				template.getMappings().forEach(map -> {
					Cell cell = row.getCell(map.getColumnIndex());
					Object value = ExcelUtils.getValueCell(cell);
					try {
						BeanUtils.setProperty(dataRow, map.getFieldName(), value);
					} catch (IllegalAccessException | InvocationTargetException e) {
					}
				});
				dataRows.add(dataRow);
			}

		} catch (Exception e) {
		}
		BatchEntity batch = BatchEntity.builder().batchCode("BATCH_" + UUID.randomUUID().toString()).dataRows(dataRows)
				.importedBy("ADMIN").status("PENDING").build();
		dataRows.forEach(r -> {
			r.setBatch(batch);
		});
		batchRepository.save(batch);

	}

	public void exportExcel(HttpServletResponse response, String fileName, UUID id, String code) {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");// Nói với browser
																										// rằng đây là
																										// file .xlsx
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName); // Yêu cầu browser tự động tải
																						// file về thay vì hiển thị trên
																						// trang web, và đặt tên file.
		try {
			Workbook workbook = new XSSFWorkbook(); // tạo một excel
			Sheet sheet = workbook.createSheet("Employee"); // tạo một trang tính trong file excel
			Row rowTitle = sheet.createRow(0); // tạo một hàng ở dòng đầu tiên trong file excel
			ExcelTemplate template = excelTemplateRepository.findByCode(code);
			List<ExcelMapping> mappings = template.getMappings();
			for (ExcelMapping ex : mappings) {
				Cell cell = rowTitle.createCell(ex.getColumnIndex());
				cell.setCellValue(ex.getHeaderName());
			}
			int rowNum = 1;
			BatchEntity batch = batchRepository.findById(id).orElseThrow();
			for (DataRows dataRow : batch.getDataRows()) {
				Row row = sheet.createRow(rowNum++);
				for (ExcelMapping map : mappings) {
					try {
						Object value = PropertyUtils.getProperty(dataRow, map.getFieldName());
						Cell cell = row.createCell(map.getColumnIndex());
						cell.setCellValue(value.toString());
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						
					}
				}
			}
			for (ExcelMapping mapping : mappings) {
				sheet.autoSizeColumn(mapping.getColumnIndex());
			}
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
		}
	}

}
