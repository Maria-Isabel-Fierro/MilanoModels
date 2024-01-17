package Page;

public class SistemPage {

    MilanoPage milanoPage = new MilanoPage();
    ExcelReaderPage excelReader = new ExcelReaderPage();
    EscribirExcelPage escribirExcelPage = new EscribirExcelPage();

    public void test(){
        String filepath = "src/test/Datos/ejemplo-cargamilano.xlsx";

        for (int i = 1; i < 9; i++) {


            String Snombre, apellido, rut, telefono, email, telefonoE;


            Snombre = excelReader.getCellValue(filepath, i, 0);
            apellido = excelReader.getCellValue(filepath, i, 1);
            rut = excelReader.getCellValue(filepath, i, 5);
            telefono = excelReader.getCellValue(filepath, i, 2);
            telefonoE = excelReader.getCellValue(filepath, i, 4);
            email = excelReader.getCellValue(filepath, i, 3);

            milanoPage.inRun(rut);


            if (milanoPage.esperarMensajeRutNoIngresado()) {
                System.out.println("RUT no válido: " + rut);

                // Aceptar automáticamente el alert
                milanoPage.aceptarAlertRutNoValido();

                // Marcar en el Excel que el ingreso no fue exitoso
                escribirExcelPage.escribirExcel("No Ingresado : Rut no valido", i);


            } else {

                milanoPage.ingresardatos(Snombre,apellido,0,"0","Otro","ADRIANA OÑATE",
                        telefono,email,"15122023","sin direccion","santiago","sin comuna",
                        "telefono emergencia",telefonoE,email,"Principiante",15122023,0,"Miércoles P9 11:00 - 13:00");


                if (milanoPage.esperarMensajeDatosInsertados()) {
                    escribirExcelPage.escribirExcel("Ingresado", i);// Llamar al método para escribir en el Excel
                    milanoPage.okAlumnoAgregado();
                } else {
                    //String mensaje = registroPage.mensajeModal();
                    //agregar metodo validar si existe en lista de alumnos, si existe

                    if(milanoPage.esperarMensajeDatosInsertados2()){
                        escribirExcelPage.escribirExcel("No Ingresado", i);
                        milanoPage.okAlumnoNoAgregado(rut);
                    } else {
                        if(milanoPage.okAlumnoNoAgregado2(rut,i)){
                            escribirExcelPage.escribirExcel("Ingresado", i);
                        } else {
                            escribirExcelPage.escribirExcel("No Ingresado", i);
                        }
                    }

                }

            }
        }
    }
}

