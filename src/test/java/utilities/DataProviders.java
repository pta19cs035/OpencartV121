package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] logindata() throws IOException {

        ExcelUtility xlut = new ExcelUtility(
            "C:\\Users\\ASUS\\OpencartV121\\testData\\Opencarttestdata.xlsx"
        );

        int rcount = xlut.getRowCount("Sheet1");
        int colcount = xlut.getCellCount("Sheet1", 1);

        // 🔥 REMOVE EMPTY ROWS AT THE END
        while (xlut.getCellData("Sheet1", rcount, 0).trim().isEmpty()) {
            rcount--;
        }

        String data[][] = new String[rcount][colcount];

        for (int r = 1; r <= rcount; r++) {
            for (int c = 0; c < colcount; c++) {
                data[r - 1][c] = xlut.getCellData("Sheet1", r, c);
            }
        }
        return data;
    }
}
