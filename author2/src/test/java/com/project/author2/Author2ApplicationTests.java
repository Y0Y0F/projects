package com.project.author2;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Author2ApplicationTests {

  @Test
  void contextLoads() {
    ExcelReader reader = ExcelUtil.getReader("C:\\Users\\YYF\\Desktop\\hello.xlsx");
    List<Map<String, Object>> readAll = reader.readAll();
    for (Map<String, Object> stringObjectMap : readAll) {
      System.out.println(stringObjectMap);
    }
  }
}
