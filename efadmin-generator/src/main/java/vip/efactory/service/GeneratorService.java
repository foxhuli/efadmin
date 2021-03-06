package vip.efactory.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.annotation.Async;

import vip.efactory.domain.ColumnInfo;
import vip.efactory.domain.GenConfig;
import vip.efactory.ejpa.utils.R;


public interface GeneratorService {

    /**
     * 查询数据库元数据
     * @param name 表名
     * @param startEnd 分页参数
     * @return /
     */
    Object getTables(String name, int[] startEnd);

    /**
     * 得到数据表的元数据
     * @param name 表名
     * @return /
     */
    List<ColumnInfo> getColumns(String name);

    /**
     * 同步表数据
     * @param columnInfos /
     * @param columnInfoList
     */
    @Async
    void sync(List<ColumnInfo> columnInfos, List<ColumnInfo> columnInfoList);

    /**
     * 保持数据
     * @param columnInfos /
     */
    void save(List<ColumnInfo> columnInfos);

    /**
     * 获取所有table
     * @return /
     */
    Object getTables();

    /**
     * 代码生成
     * @param genConfig 配置信息
     * @param columns 字段信息
     */
    void generator(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 预览
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @return /
     */
    @SuppressWarnings("rawtypes")   // 压制原生类型的警告
    R preview(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 打包下载
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @param request /
     * @param response /
     */
    void download(GenConfig genConfig, List<ColumnInfo> columns, HttpServletRequest request, HttpServletResponse response);

    /**
     * 查询数据库的表字段数据数据
     * @param table /
     * @return /
     */
    List<ColumnInfo> query(String table);
}
