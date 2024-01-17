package Page;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirExcelPage {
    public void escribirExcel(String estado, int filaRegistro) {
        String filePath = "src/test/Datos/ejemplo-cargamilano.xlsx";

        // Columna para actualizar
        int columnaEstado = 6;

        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            // Obtener la hoja de trabajo (o crear una nueva si no existe)
            Sheet sheet = workbook.getSheet("Hoja1");
            if (sheet == null) {
                sheet = workbook.createSheet("Hoja1");
            }

            // Obtener la fila actual para el registro
            Row row = sheet.getRow(filaRegistro);

            // Crear una celda en la columna de estado y establecer el estado del registro
            Cell cell = row.createCell(columnaEstado);
            cell.setCellValue(estado);

            // Guardar los cambios en el archivo
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Estado actualizado en Excel: " + estado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




