package org.exampleUtils01.poi;

import com.google.common.collect.Lists;
import org.exampleUtils01.dateUtils.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * poi操作Excel类
 * Apache POI 是一种流行的API,可以使用Java读写MS Excel文件，可以使用Java读写MS Word和MS PowerPoint文件。
 * @author hezhengzheng
 * @version 1.0
 * @since Mar 9, 2014
 */
public class ExcelUtils
{

    /**
     * 只读取excel中第一个sheet中的数据
     *
     * @param file 文件的file对象
     * @param cellSize 每行读取至多少格为止
     * @return List<List<String>> 数据列表 外层list为行，内层list为列
     * @throws Exception
     */
    public static List<List<String>> getByFileAndKeyMap(File file, int cellSize) throws Exception
    {
        return getBySheet(getByFile(file).getSheetAt(0), cellSize);
    }

    /**
     * 读取excel中制定的sheet名的数据
     *
     * @param file 文件的file对象
     * @param sheetNameList 根据sheet列表读取sheet中的数据，若文件中的sheet名不存在于该列表中则不会被读取。
     * @param cellSize 每行读取至多少格为止
     * @return List<KeyValue<String,List<List<String>>>> 数据列表
     *         KeyValue中key为sheet名，value为该sheet中的二维列表数据，外层list为行，内层list为列
     * @throws Exception
     */
    public static List<KeyValue<String, List<List<String>>>> getByFileAndKeyMap(File file, List<String> sheetNameList,
                                                                                int cellSize) throws Exception
    {
        Workbook wb = getByFile(file);
        List<KeyValue<String, List<List<String>>>> result = Lists.newArrayList();
        Sheet sheet;
        for (String sheetName : sheetNameList)
        {
            sheet = wb.getSheet(sheetName);
            if (null != sheet)
            {
                result.add(new KeyValue<String, List<List<String>>>(sheetName, getBySheet(sheet, cellSize)));
            }
        }
        return result;
    }

    /**
     * 文件流
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static Workbook getByWorkbook(InputStream inputStream)
            throws Exception
    {
        Workbook wb = null;
        wb = WorkbookFactory.create(inputStream);
        return wb;
    }


    /**
     *
     * 读取execl文件
     *
     * @since Mar 9, 2014
     * @author hezhengzheng
     * @param file excel的File对象
     * @return poi中指定的Workbook对象
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static Workbook getByFile(File file) throws Exception
    {
        if (!file.isFile())
        {
            throw new Exception(file + " 不存在");
        }
        String filetype = file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase();

        Workbook wb = null;
        if ((!"xlsx".equalsIgnoreCase(filetype)) && (!"xls".equalsIgnoreCase(filetype))) {
            throw new Exception(" 文件格式不正确！");
        }
        wb = WorkbookFactory.create(file);

        return wb;
    }

    /**
     *
     * 获取当前sheet中的数据源
     *
     * @since Mar 9, 2014
     * @author hezhengzheng
     * @param 指定的poi的sheet对象
     * @param 读取行数的限制
     * @return 数据源 外层list为行，内层list为列
     */
    public static List<List<String>> getBySheet(Sheet sheet, int cellSize)
    {
        List<List<String>> result = Lists.newArrayList();
        List<String> tmpList;
        Cell cell;
        for (Row row : sheet)
        {
            tmpList = Lists.newArrayList();
            for (int i = 0; i < cellSize; i++)
            {
                cell = row.getCell(i);
                String value = getByCellData(cell);
                tmpList.add(value);
            }
            result.add(tmpList);
        }
        return result;
    }


    /**
     * 取行数据
     * @param sheet
     * @param rowNum
     * @param titleSize
     * @return
     */
    public static List<String> getByRowData(Sheet sheet, int rowNum, int titleSize)
    {
        List<String> result = new ArrayList<String>();

        Row row = sheet.getRow(rowNum);

        if(row != null){
//    	  for (int i = 0; i < row.getPhysicalNumberOfCells(); i++)
            for (int i = 0; i < titleSize; i++)
            {
                Cell cell = row.getCell(i);
                String value = getByCellData(cell);
                result.add(value);
            }
        }

        return result;
    }


    /**
     * 取列值
     * @param cell
     * @return
     */
    public static String getByCellData(Cell cell)
    {
        String value = null;
        if (cell != null)
        {
            switch (cell.getCachedFormulaResultType())
            {
//        	case Cell.CELL_TYPE_FORMULA:
                case FORMULA:
                    value = String.valueOf(cell.getCellFormula());
                    break;
//	        case Cell.CELL_TYPE_NUMERIC:
                case NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell) || HSSFDateUtil.isCellInternalDateFormatted(cell)) {
                        Date cellValue = cell.getDateCellValue();
                        value = DateUtil.day2String(cellValue);
                    }
                    else
                    {
                        double strCell = cell.getNumericCellValue();
                        DecimalFormat formatCell = (DecimalFormat)NumberFormat.getPercentInstance();
                        formatCell.applyPattern("0");
                        value = formatCell.format(strCell);
                        if (Double.parseDouble(value) != strCell)
                        {
                            //TODO　格式化小数会错，暂时改为空
                            formatCell.applyPattern("#.######");
                            value = formatCell.format(strCell);
                        }
                    }
                    break;
//	        case Cell.CELL_TYPE_STRING:
                case STRING:
                    value = cell.getStringCellValue();
                    break;
//	        case Cell.CELL_TYPE_BOOLEAN:
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    cell.getDateCellValue();
                    break;
                default:
            }

        }

        return value;
    }
}