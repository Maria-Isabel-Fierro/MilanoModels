package Page;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaderPage {

    public String getCellValue(String filepath, int fila, int columna) {

        FileInputStream file = null;
        XSSFWorkbook wb = null;
        try {
            file = new FileInputStream(filepath);
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet hoja = wb.getSheetAt(0); //trae la hoja 0, no importando el nombre


        XSSFRow rfila = hoja.getRow(fila);
        XSSFCell celda = rfila.getCell(columna);
        String valor;
        if (columna == 2 || columna == 4) { /* columnas con tipo numero */
            valor = celda.getRawValue(); /* utilizar getRawValue para celdas con solo numeros*/
        } else {
            valor = celda.getStringCellValue();
        }
        return valor;
    }

    public static void main(String[] args) {

        ExcelReaderPage data = new ExcelReaderPage();
        String nombre, apellido, rut, telefono, email, telefonoE;

        for (int i = 1; i < 9; i++) {
            nombre = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 0);
            apellido = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 1);
            telefono = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 2);
            email = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 3);
            telefonoE = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 4);
            rut = data.getCellValue("src/test/Datos/ejemplo-cargamilano.xlsx", i, 5);

        }


    }
}


