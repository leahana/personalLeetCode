package y2023.m5.day09.poet;

import java.lang.String;



@ETable(
        value = "Site",
        tableClass = SiteEntity.class
)
public class SiteEntity {
  @EColumn("名称")
  private String name;

  @EColumn("全局名称")
  private String fullName;

  @EColumn("所属区域")
  private String parZone;

  @EColumn("简称")
  private String abbrName;
}
