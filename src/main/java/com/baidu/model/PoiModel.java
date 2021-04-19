package com.baidu.model;

/*
 * @Auther fandaoman
 * @date 2020/1/9 10:39
 * @Ver 1.0
 * */
public class PoiModel {
    private String content;//当前值

    private String oldContent;//同一列上一行的值

    private int rowIndex;//当前行

    private int cellIndex;//当前列

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(int cellIndex) {
        this.cellIndex = cellIndex;
    }
}
