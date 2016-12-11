package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseVocabulary;

/**
 * Created by Pavel on 11.12.2016.
 */
public class AbstractVocProcessor {
  public void process(BaseVocabulary vocabulary) {
    System.out.println("Process vocabulary:\t" + vocabulary.getDomain());
  }
}
