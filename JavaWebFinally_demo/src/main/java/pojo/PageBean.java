package pojo;


import java.util.List;

/**
 * 分页查询的JavaBean
 */
public class PageBean<T> {
    //总记录数
    private Integer totalCount;

    //当前页数据
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(Integer totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
