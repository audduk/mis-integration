package mis.integration.ariadna.data.vocabulary;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Базовая структура словаря ЛИС Ариадна.
 * Используется для определения типа словаря
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Vocabulary")
public class BaseVocabulary {
  /** Цели исследований (обрабатываем) */
  public static final String EXPLORE = "EXPLORE";
  /** Тип материала (обрабатываем) */
  public static final String T_SAMPLE = "T_SAMPLE";
  /** Состояние пациента (пропускаем) */
  public static final String CONDITION = "CONDITION";
  /** Группа состоянии пациента (выбираем "Фазы цикла") */
  public static final String CONDITION_GROUP = "CONDITION_GROUP";
  /** Категория пациента - вид оплаты (пропускаем) */
  public static final String KATPAC = "KATPAC";

  /** Наименование словаря */
  @XmlElement(name = "Domain")
  private String domain;

  @XmlElementWrapper(name = "Contents")
  @XmlElement(name = "item")
  private List<BaseItem> contents;

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public List<BaseItem> getContents() {
    return contents;
  }

  public void setContents(List<BaseItem> contents) {
    this.contents = contents;
  }
}
